package com.marcondes.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcondes.domains.Cliente;
import com.marcondes.domains.Tecnico;
import com.marcondes.domains.enuns.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {

    protected Integer id;

    @NotNull(message = "O Campo NOME  é requerido!")
    protected String nome;

    @NotNull(message = "O Campo CPF  é requerido!")
    protected String cpf;

    @NotNull(message = "O Campo E-MAIL  é requerido!")
    protected String email;

    @NotNull(message = "O Campo SENHA  é requerido!")
    protected String senha;

    protected Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(Perfil::getCodigo).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }


    public Set<Perfil> getPerfis() {
        return perfis.stream().map(Perfil::toEnum).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

}