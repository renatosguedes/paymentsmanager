package com.example.paymentsmanager.transportlayers;

import com.example.paymentsmanager.entities.FluxoPagamento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value = "Gerenciador fluxos", tags = "Permite que o usuário busque, verifique o status e pagamentos de um fluxo.")
public interface GerenciadorApi {

    /**
     * Busca um fluxo a partir de seu ID.
     *
     * @param idFluxo ID do fluxo a ser buscado.
     * @return O fluxo e todos os seus pagamentos
     */
    @ApiOperation("Busca um fluxo a partir de seu ID.")
    @GetMapping(value = "/fluxo/{idFluxo}")
    ResponseEntity<FluxoPagamento> buscarFluxoPagamento(@ApiParam("ID do Fluxo") @PathVariable String idFluxo);
}
