package com.example.paymentsmanager.entities.dtos;

import java.util.List;

public class GetFluxoByIdResponse {

    private String id;
    private List<GetFluxoByIdFluxoResponse> fluxo;

    public GetFluxoByIdResponse() {
    }

    public GetFluxoByIdResponse(String id, List<GetFluxoByIdFluxoResponse> fluxo) {
        this.id = id;
        this.fluxo = fluxo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<GetFluxoByIdFluxoResponse> getFluxo() {
        return fluxo;
    }

    public void setFluxo(List<GetFluxoByIdFluxoResponse> fluxo) {
        this.fluxo = fluxo;
    }
}
