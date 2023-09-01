package com.marcondes.domains;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Tecnico extends Pessoa{

    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }
}
