package com.marcondes.resources;


import com.marcondes.domains.Chamado;
import com.marcondes.domains.dtos.ChamadoDTO;
import com.marcondes.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResources {

    @Autowired
    private ChamadoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id){
        Chamado chamado = service.findById(id);
        return ResponseEntity.ok().body(new ChamadoDTO(chamado));
    }

    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll(){
        List<Chamado> chamadoList = service.findAll();
        List<ChamadoDTO> chamadoDTOList = chamadoList.stream().map(ChamadoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(chamadoDTOList);
    }
}
