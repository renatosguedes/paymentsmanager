package com.example.paymentsmanager.transportlayers;

import com.example.paymentsmanager.entities.FluxoPagamento;
import com.example.paymentsmanager.entities.RetornoProcessamento;
import com.example.paymentsmanager.entities.dtos.GetFluxosResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@OpenAPIDefinition(info = @Info(title = "Gerenciador de Fluxos",
        description = "Permite que o usuário busque, verifique o status e pagamentos de um fluxo."))
public interface GerenciadorApi {

    /**
     * Busca um fluxo a partir de seu ID.
     *
     * @param idFluxo ID do fluxo a ser buscado.
     * @return O fluxo e todos os seus pagamentos
     */
    @Operation(summary = "Busca um fluxo a partir de seu ID")
    @GetMapping(value = "/fluxo/{idFluxo}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fluxo encontrado", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = FluxoPagamento.class))}),
            @ApiResponse(responseCode = "400", description = "ID inválido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Fluxo não encontrado", content = @Content)
    })
    ResponseEntity<FluxoPagamento> buscarFluxoPagamento(@Parameter(description = "ID do fluxo a ser buscado") @PathVariable String idFluxo);

    /**
     * Busca todos os fluxos disponíveis.
     *
     * @return Um objeto contendo todos os IDs dos fluxos
     */
    @Operation(summary = "Busca todos os fluxos disponíveis")
    @GetMapping(value = "/fluxos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fluxos encontrados", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = FluxoPagamento.class))}),
            @ApiResponse(responseCode = "404", description = "Fluxos não encontrados", content = @Content)
    })
    ResponseEntity<GetFluxosResponse> buscarFluxos();

    /**
     * Processa os pagamentos pendentes de determinado fluxo.
     *
     * @param idFluxo ID do fluxo cujos pagamentos serão processados.
     * @return Um objeto contendo as informações sobre o processamento.
     */
    @Operation(summary = "Processa os pagamentos pendentes de determinado fluxo")
    @PostMapping(value = "/fluxo/{idFluxo}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamentos processados", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = RetornoProcessamento.class))}),
            @ApiResponse(responseCode = "400", description = "Não há pagamentos para processar", content = @Content)
    })
    ResponseEntity<RetornoProcessamento> processarFluxo(@Parameter(description = "ID do fluxo a ser processado") @PathVariable String idFluxo);
}
