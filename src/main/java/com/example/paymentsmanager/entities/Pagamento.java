package com.example.paymentsmanager.entities;

import com.example.paymentsmanager.entities.enums.StatusPagamento;

import java.time.OffsetDateTime;

public class Pagamento {

    private OffsetDateTime dataPagamento;
    private double valorPagamento;
    private StatusPagamento statusPagamento;

    public Pagamento() {
    }

    public OffsetDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(OffsetDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}
