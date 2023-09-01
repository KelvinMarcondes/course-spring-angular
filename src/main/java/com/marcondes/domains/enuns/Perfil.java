package com.marcondes.domains.enuns;

import lombok.Getter;

public enum Perfil {

    ADMIN(0, "ROLE_ADMIN"),
    CLIENTE(1, "ROLE_CLIENTE"),
    TECNICO(2, "ROLE_TECNICO");

    @Getter
    private Integer codigo;

    @Getter
    private String descricao;

    public static Perfil toEnum(Integer cod){
        if (cod==null){
            return null;
        }
        for (Perfil x : Perfil.values()){
            if (cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil inválido.");
    }

    Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}

