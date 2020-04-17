package com.marcosvidolin.sbapi.mapper;

import com.marcosvidolin.sbapi.data.entity.BancoEntity;
import com.marcosvidolin.sbapi.model.Banco;
import org.springframework.stereotype.Component;

@Component
public class BancoMapper implements Mapable<Banco, BancoEntity> {

    @Override
    public Banco map(BancoEntity bancoEntity) {
        Banco banco = new Banco();
        banco.setNome(bancoEntity.getNome());
        banco.setAgencia(bancoEntity.getAgencia());
        banco.setContaCorrente(bancoEntity.getContaCorrente());
        return banco;
    }

}
