package com.example.paymentsmanager.entities;

import java.util.Date;

public class Pagamento {

    private Date dataPagamento;
    private double valorPagamento;

    public Pagamento(Date dataPagamento, double valorPagamento) {
        this.dataPagamento = dataPagamento;
        this.valorPagamento = valorPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }
}
