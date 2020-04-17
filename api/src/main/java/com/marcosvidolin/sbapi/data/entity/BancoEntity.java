package com.marcosvidolin.sbapi.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BancoEntity {

    private String nome;
    private String agencia;
    private String contaCorrente;

    public BancoEntity(String nome, DadosDomicilioBancarioEntity dadosDomicilioBancario) {
        this.setNome(nome);
        this.agencia = dadosDomicilioBancario.getNumeroAgencia();
        this.contaCorrente = dadosDomicilioBancario.getNumeroContaCorrente();
    }

    public void setNome(String nome) {
        this.nome = "";
        if (nome != null) {
            this.nome = nome.trim();
        }
    }

}
