package com.example.paymentsmanager.transportlayers.impl;

import com.example.paymentsmanager.entities.FluxoPagamento;
import com.example.paymentsmanager.entities.RetornoProcessamento;
import com.example.paymentsmanager.entities.dtos.GetFluxosResponse;
import com.example.paymentsmanager.interactors.GerenciadorUseCase;
import com.example.paymentsmanager.transportlayers.GerenciadorApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerenciador")
public class GerenciadorController implements GerenciadorApi {

    private final GerenciadorUseCase gerenciadorUseCase;

    public GerenciadorController(GerenciadorUseCase gerenciadorUseCase) {
        this.gerenciadorUseCase = gerenciadorUseCase;
    }

    @Override
    public ResponseEntity<FluxoPagamento> buscarFluxoPagamento(String idFluxo) {
        return ResponseEntity.ok().body(gerenciadorUseCase.buscarFluxoPagamento(idFluxo));
    }

    @Override
    public ResponseEntity<GetFluxosResponse> buscarFluxos() {
        return ResponseEntity.ok().body(gerenciadorUseCase.buscarFluxos());
    }

    @Override
    public ResponseEntity<RetornoProcessamento> processarFluxo(String idFluxo) {
        return ResponseEntity.ok().body(gerenciadorUseCase.processarPagamentos(idFluxo));
    }
}
