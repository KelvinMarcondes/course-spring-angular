package com.marcondes.domains.enuns;

import lombok.Getter;

public enum Status {

    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    @Getter
    private Integer codigo;

    @Getter
    private String descricao;

    public static Status toEnum(Integer cod){
        if (cod==null){
            return null;
        }
        for (Status x : Status.values()){
            if (cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido.");
    }

    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}

