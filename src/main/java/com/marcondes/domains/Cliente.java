package com.marcondes.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcondes.domains.dtos.ClienteDTO;
import com.marcondes.domains.dtos.TecnicoDTO;
import com.marcondes.domains.enuns.Perfil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
public class Cliente extends Pessoa{

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(ClienteDTO obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(Perfil::getCodigo).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

}
