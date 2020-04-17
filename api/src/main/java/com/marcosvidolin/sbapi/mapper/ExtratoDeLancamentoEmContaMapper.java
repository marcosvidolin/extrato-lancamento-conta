package com.marcosvidolin.sbapi.mapper;

import com.marcosvidolin.sbapi.data.entity.ControleLancamentoEntity;
import com.marcosvidolin.sbapi.data.entity.LancamentoContaEntity;
import com.marcosvidolin.sbapi.model.ExtratoDeLancamentoEmConta;
import com.marcosvidolin.sbapi.model.LancamentoEmConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExtratoDeLancamentoEmContaMapper
        implements Mapable<ExtratoDeLancamentoEmConta, LancamentoContaEntity> {

    private LancamentoEmContaMapper lancamentoEmContaMapper;

    @Autowired
    public ExtratoDeLancamentoEmContaMapper(LancamentoEmContaMapper lancamentoEmContaMapper) {
        this.lancamentoEmContaMapper = lancamentoEmContaMapper;
    }

    @Override
    public ExtratoDeLancamentoEmConta map(LancamentoContaEntity lancamentoContaEntity) {
        ExtratoDeLancamentoEmConta extratoLancamentoEmConta = new ExtratoDeLancamentoEmConta();
        for (ControleLancamentoEntity lancamento : lancamentoContaEntity.getListaControleLancamento()) {
            LancamentoEmConta lancamentoEmConta = this.lancamentoEmContaMapper.map(lancamento);
            extratoLancamentoEmConta.add(lancamentoEmConta);
        }
        return extratoLancamentoEmConta;
    }

}
