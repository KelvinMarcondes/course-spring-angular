package com.marcondes.services;

import com.marcondes.domains.Pessoa;
import com.marcondes.domains.Cliente;
import com.marcondes.domains.dtos.ClienteDTO;
import com.marcondes.repositories.PessoaRepository;
import com.marcondes.repositories.ClienteRepository;
import com.marcondes.services.exceptions.DataIntegrityViolationException;
import com.marcondes.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    @Autowired
    PessoaRepository pessoaRepository;

    public Cliente findById(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado! Id: " + id));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        validaPorEmailECpf(objDTO);
        Cliente newObj = new Cliente(objDTO);
        return repository.save(newObj);
    }

    public Cliente update(Integer id, ClienteDTO ClienteDTO) {
        ClienteDTO.setId(id);
        Cliente Cliente = findById(id);
        validaPorEmailECpf(ClienteDTO);
        Cliente = new Cliente(ClienteDTO);
        return repository.save(Cliente);
    }

    public void delete(Integer id) {
        Cliente obj = findById(id);

        if (!obj.getChamados().isEmpty()){
            throw new DataIntegrityViolationException("Não é possivel deletar um técnico que possua ordens de serviço.");
        }
        repository.deleteById(id);
    }

    private void validaPorEmailECpf(ClienteDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }
}
