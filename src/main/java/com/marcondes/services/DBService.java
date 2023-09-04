package com.marcondes.services;

import com.marcondes.domains.Chamado;
import com.marcondes.domains.Cliente;
import com.marcondes.domains.Tecnico;
import com.marcondes.domains.enuns.Perfil;
import com.marcondes.domains.enuns.Prioridade;
import com.marcondes.domains.enuns.Status;
import com.marcondes.repositories.ChamadoRepository;
import com.marcondes.repositories.ClienteRepository;
import com.marcondes.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {


    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void InstanciaDB(){

        Tecnico tecnico1 = new Tecnico(null, "Kelvin Marcondes", "111.111.111-11", "kelvin@mail.com", "123");
        tecnico1.addPerfil(Perfil.TECNICO);

        Cliente cliente1 = new Cliente(null, "Paulo Reis", "222.222.222-22", "paulon@mail.com", "123");

        Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tecnico1, cliente1);

        tecnicoRepository.saveAll(Arrays.asList(tecnico1));
        clienteRepository.saveAll(Arrays.asList(cliente1));
        chamadoRepository.saveAll(Arrays.asList(chamado1));
    }

}
