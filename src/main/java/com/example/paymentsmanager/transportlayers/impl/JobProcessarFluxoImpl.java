package com.example.paymentsmanager.transportlayers.impl;

import com.example.paymentsmanager.interactors.GerenciadorService;
import org.springframework.scheduling.annotation.Scheduled;

public class JobProcessarFluxoImpl {

    private final GerenciadorService gerenciadorService;

    public JobProcessarFluxoImpl(GerenciadorService gerenciadorService) {
        this.gerenciadorService = gerenciadorService;
    }

    @Scheduled(cron = "0 0 0 * * MON-FRI")
    private void processarFluxo() {
        gerenciadorService.processarPagamento();
    }
}
