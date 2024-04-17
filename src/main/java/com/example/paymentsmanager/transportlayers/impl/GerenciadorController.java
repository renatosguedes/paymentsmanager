package com.example.paymentsmanager.transportlayers.impl;

import com.example.paymentsmanager.entities.FluxoPagamento;
import com.example.paymentsmanager.interactors.GerenciadorService;
import com.example.paymentsmanager.transportlayers.GerenciadorApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class GerenciadorController implements GerenciadorApi {

    private final GerenciadorService gerenciadorService;

    public GerenciadorController(GerenciadorService gerenciadorService) {
        this.gerenciadorService = gerenciadorService;
    }

    @Override
    public ResponseEntity<FluxoPagamento> buscarFluxoPagamento(String idFluxo) {
        return ResponseEntity.ok().body(gerenciadorService.buscarFluxoPagamento());
    }
}
