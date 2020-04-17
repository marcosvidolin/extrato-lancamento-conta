package com.marcosvidolin.sbapi.data.entity;

import lombok.Data;

@Data
public class TotalControleLancamentoEntity {

    private int quantidadeLancamentos;
    private int quantidadeRemessas;
    private double valorLancamentos;

}
