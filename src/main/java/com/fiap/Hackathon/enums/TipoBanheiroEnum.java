package com.fiap.Hackathon.enums;

public enum TipoBanheiroEnum {
    SIMPLES("Simples (Box com Ducha, Privada, Ducha higiênica e pia com espelho)"),
    LUXO("Luxo (Box com Ducha, Privada, Ducha higiênica e pia dupla com espelho)"),
    PREMIUM("Premium (Box com Ducha, Privada, Ducha higiênica, pia dupla com espelho e Sauna)");

    private String descricao;

    TipoBanheiroEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
