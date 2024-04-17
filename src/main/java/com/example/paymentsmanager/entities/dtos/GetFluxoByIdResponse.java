package com.example.paymentsmanager.entities.dtos;

import java.util.List;

public class GetFluxoByIdResponse {

    private String id;
    private List<GetFluxoByIdPagamentoResponse> fluxo;

    public GetFluxoByIdResponse() {
    }

    public GetFluxoByIdResponse(String id, List<GetFluxoByIdPagamentoResponse> fluxo) {
        this.id = id;
        this.fluxo = fluxo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<GetFluxoByIdPagamentoResponse> getFluxo() {
        return fluxo;
    }

    public void setFluxo(List<GetFluxoByIdPagamentoResponse> fluxo) {
        this.fluxo = fluxo;
    }
}
