package com.marcondes.domains.enuns;

import lombok.Getter;

public enum Prioridade {

    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    @Getter
    private Integer codigo;

    @Getter
    private String descricao;

    public static Prioridade toEnum(Integer cod){
        if (cod==null){
            return null;
        }
        for (Prioridade x : Prioridade.values()){
            if (cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida.");
    }

    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}

