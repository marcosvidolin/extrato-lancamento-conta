package com.marcosvidolin.sbapi.model;

import lombok.Data;

@Data
public class LancamentoEmConta {

    private Long numeroRemessa;
    private String situacao;
    private String descricao;
    private String dataLancamento;
    private String dataConfirmacao;
    private Banco banco;
    private double valor;

}
