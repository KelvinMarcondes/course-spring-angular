package com.marcondes.services;

import com.marcondes.domains.Tecnico;
import com.marcondes.domains.dtos.TecnicoDTO;
import com.marcondes.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElse(null);
    }

    public List<ResponseEntity<TecnicoDTO>> findAll() {
    return null;
    }
}
