package com.marcondes.services;

import com.marcondes.domains.Pessoa;
import com.marcondes.domains.Tecnico;
import com.marcondes.domains.dtos.TecnicoDTO;
import com.marcondes.repositories.PessoaRepository;
import com.marcondes.repositories.TecnicoRepository;
import com.marcondes.services.exceptions.DataIntegrityViolationException;
import com.marcondes.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    TecnicoRepository tecnicoRepository;
    @Autowired
    PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado! Id: " + id));
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO) {
        objDTO.setId(null);
        validaPorEmailECpf(objDTO);
        Tecnico newObj = new Tecnico(objDTO);
        return tecnicoRepository.save(newObj);
    }

    private void validaPorEmailECpf(TecnicoDTO objDTO) {
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
