package com.marcosvidolin.sbapi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties({"dadosAnaliticoLancamentoFinanceiroCliente"})
public class LancamentoContaCorrenteClienteEntity {

    private Long numeroRemessaBanco;
    private String nomeSituacaoRemessa;
    private DadosDomicilioBancarioEntity dadosDomicilioBancario;
    private String nomeTipoOperacao;

}
