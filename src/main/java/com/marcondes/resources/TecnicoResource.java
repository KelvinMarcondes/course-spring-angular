package com.marcondes.resources;

import com.marcondes.domains.Tecnico;
import com.marcondes.domains.dtos.TecnicoDTO;
import com.marcondes.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
        Tecnico obj = service.findById(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        List<Tecnico> tecnicoList = service.findAll();
        List<TecnicoDTO> tecnicoDTOList = tecnicoList.stream().map(TecnicoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(tecnicoDTOList);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDTO){
        Tecnico newOBJ = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newOBJ.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<TecnicoDTO> update (@PathVariable Integer id, @Valid @RequestBody TecnicoDTO objDTO){
        Tecnico tecnico = service.update(id, objDTO);
        return ResponseEntity.ok().body(new TecnicoDTO(tecnico));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> delete (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
