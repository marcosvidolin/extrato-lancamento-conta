package com.marcosvidolin.sbapi.model;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class ExtratoDeLancamentoEmConta {

    @Getter
    private Collection<LancamentoEmConta> lancamentosEmConta = new ArrayList<>();
    private int totalLancamentos;

    public void add(LancamentoEmConta lancamentoEmConta) {
        this.lancamentosEmConta.add(lancamentoEmConta);
    }

    public int getTotalLancamentos() {
        return this.lancamentosEmConta.size();
    }
}
