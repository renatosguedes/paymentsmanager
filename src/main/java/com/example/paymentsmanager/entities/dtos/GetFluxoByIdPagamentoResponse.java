package com.example.paymentsmanager.entities.dtos;

public class GetFluxoByIdPagamentoResponse {

    private String data;
    private double pmt;

    public GetFluxoByIdPagamentoResponse() {
    }

    public GetFluxoByIdPagamentoResponse(String data, double pmt) {
        this.data = data;
        this.pmt = pmt;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getPmt() {
        return pmt;
    }

    public void setPmt(double pmt) {
        this.pmt = pmt;
    }
}
