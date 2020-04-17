package com.marcosvidolin.sbapi.data.entity;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;

@Data
public class LancamentoContaEntity {

    private TotalControleLancamentoEntity totalControleLancamento;
    private Collection<ControleLancamentoEntity> listaControleLancamento;
    private int indice;
    private int tamanhoPagina;
    private int totalElements;

    public Collection<ControleLancamentoEntity> getListaControleLancamento() {
        if (CollectionUtils.isEmpty(this.listaControleLancamento)) {
            return Collections.EMPTY_LIST;
        }
        return this.listaControleLancamento;
    }

}
