package com.marcosvidolin.sbapi.rest.controller;

import com.marcosvidolin.sbapi.exception.BusinessException;
import com.marcosvidolin.sbapi.exception.DatasourceException;
import com.marcosvidolin.sbapi.model.ExtratoDeLancamentoEmConta;
import com.marcosvidolin.sbapi.model.LancamentoEmConta;
import com.marcosvidolin.sbapi.service.ExtratoDeLancamentoEmContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Collection;

/**
 * This rest controller class exposes REST methods to the "lancamentos" resource.
 */
@Api(value = "Lancamentos")
@Validated
@RestController
@RequestMapping(value = "/api/lancamentos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExtratoDeLancamentoEmContaRestController {

    private ExtratoDeLancamentoEmContaService service;

    @Autowired
    public ExtratoDeLancamentoEmContaRestController(ExtratoDeLancamentoEmContaService service) {
        this.service = service;
    }

    /**
     * Gets a collection of "lancamentos".
     *
     * @return ResponseEntity a collection of "lancamentos"
     */
    @ApiOperation(value = "Obtem o extrato dos lançamentos em conta corrente", response = LancamentoEmConta.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resposta obtida com sucesso"),
            @ApiResponse(code = 400, message = "Parametros de requisiçao invalidos.")
    })
    @GetMapping
    public ResponseEntity<Collection<LancamentoEmConta>> get(
            @RequestParam @Min(1) int page, @RequestParam @Min(1) int items)
            throws DatasourceException, BusinessException {
        ExtratoDeLancamentoEmConta lancamentoConta = this.service.findAllByPagination(page, items);
        return ResponseEntity.ok(lancamentoConta.getLancamentosEmConta());
    }

}
