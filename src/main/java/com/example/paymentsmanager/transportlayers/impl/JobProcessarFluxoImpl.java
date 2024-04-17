package com.example.paymentsmanager.transportlayers.impl;

import com.example.paymentsmanager.interactors.GerenciadorUseCase;
import org.springframework.scheduling.annotation.Scheduled;

public class JobProcessarFluxoImpl {

    private final GerenciadorUseCase gerenciadorUseCase;

    public JobProcessarFluxoImpl(GerenciadorUseCase gerenciadorUseCase) {
        this.gerenciadorUseCase = gerenciadorUseCase;
    }

    @Scheduled(cron = "0 0 0 * * MON-FRI")
    private void processarFluxo() {
        gerenciadorUseCase.processarPagamento();
    }
}
