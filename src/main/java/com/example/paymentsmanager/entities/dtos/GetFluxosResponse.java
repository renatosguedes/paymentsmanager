package com.example.paymentsmanager.entities.dtos;

import java.util.List;

public class GetFluxosResponse {

    private List<String> ids;

    public GetFluxosResponse(List<String> ids) {
        this.ids = ids;
    }

    public GetFluxosResponse() {
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
