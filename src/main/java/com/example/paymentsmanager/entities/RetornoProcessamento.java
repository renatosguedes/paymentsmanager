package com.example.paymentsmanager.entities;

import java.util.List;

public class RetornoProcessamento {

    private String id;
    private Integer quantidadeProcessada;
    private double valorTotalPago;
    private List<Pagamento> pagamentosProcessados;

    public RetornoProcessamento() {
    }

    public RetornoProcessamento(String id, Integer quantidadeProcessada, double valorTotalPago, List<Pagamento> pagamentosProcessados) {
        this.id = id;
        this.quantidadeProcessada = quantidadeProcessada;
        this.valorTotalPago = valorTotalPago;
        this.pagamentosProcessados = pagamentosProcessados;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantidadeProcessada() {
        return quantidadeProcessada;
    }

    public void setQuantidadeProcessada(Integer quantidadeProcessada) {
        this.quantidadeProcessada = quantidadeProcessada;
    }

    public List<Pagamento> getPagamentosProcessados() {
        return pagamentosProcessados;
    }

    public void setPagamentosProcessados(List<Pagamento> pagamentosProcessados) {
        this.pagamentosProcessados = pagamentosProcessados;
    }

    public double getValorTotalPago() {
        return valorTotalPago;
    }

    public void setValorTotalPago(double valorTotalPago) {
        this.valorTotalPago = valorTotalPago;
    }
}
