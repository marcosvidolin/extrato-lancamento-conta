package com.marcosvidolin.sbapi.mapper;

import com.marcosvidolin.sbapi.data.entity.ControleLancamentoEntity;
import com.marcosvidolin.sbapi.model.Banco;
import com.marcosvidolin.sbapi.model.LancamentoEmConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LancamentoEmContaMapper implements Mapable<LancamentoEmConta, ControleLancamentoEntity> {

    private BancoMapper bancoMapper;

    @Autowired
    public LancamentoEmContaMapper(BancoMapper bancoMapper) {
        this.bancoMapper = bancoMapper;
    }

    @Override
    public LancamentoEmConta map(ControleLancamentoEntity controleLancamentoEntity) {

        LancamentoEmConta lancamentoEmConta = new LancamentoEmConta();
        lancamentoEmConta.setNumeroRemessa(controleLancamentoEntity.getNumero());
        lancamentoEmConta.setSituacao(controleLancamentoEntity.getSituacao());
        lancamentoEmConta.setDataConfirmacao(controleLancamentoEntity.getDataEfetivaLancamento());
        lancamentoEmConta.setDataLancamento(controleLancamentoEntity.getDataLancamentoContaCorrenteCliente());
        lancamentoEmConta.setDescricao(controleLancamentoEntity.getNomeTipoOperacao());
        lancamentoEmConta.setValor(controleLancamentoEntity.getValorLancamentoRemessa());
        Banco banco = this.bancoMapper.map(controleLancamentoEntity.getBancoEntity());
        lancamentoEmConta.setBanco(banco);

        return lancamentoEmConta;
    }
}
