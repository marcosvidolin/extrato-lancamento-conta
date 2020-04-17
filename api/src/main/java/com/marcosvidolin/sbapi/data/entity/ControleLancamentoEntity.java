package com.marcosvidolin.sbapi.data.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ControleLancamentoEntity {

    private LancamentoContaCorrenteClienteEntity lancamentoContaCorrenteCliente;
	private String dataEfetivaLancamento;
    private String dataLancamentoContaCorrenteCliente;
    private Long numeroEvento;
    private String descricaoGrupoPagamento;
    private String codigoIdentificadorUnico;
    private String nomeBanco;
    private Integer quantidadeLancamentoRemessa;
    private String numeroRaizCNPJ;
    private String numeroSufixoCNPJ;
    private double valorLancamentoRemessa;
    private Date dateLancamentoContaCorrenteCliente;
    private Date dateEfetivaLancamento;
    private BancoEntity bancoEntity;

    public Long getNumero() {
        return this.lancamentoContaCorrenteCliente.getNumeroRemessaBanco();
    }

    public String getSituacao() {
        return this.lancamentoContaCorrenteCliente.getNomeSituacaoRemessa();
    }

    public BancoEntity getBancoEntity() {
        return new BancoEntity(this.nomeBanco, this.lancamentoContaCorrenteCliente.getDadosDomicilioBancario());
    }

    public String getNomeTipoOperacao() {
        if (this.getLancamentoContaCorrenteCliente() != null) {
            return this.getLancamentoContaCorrenteCliente().getNomeTipoOperacao();
        }
        return "";
    }
}
