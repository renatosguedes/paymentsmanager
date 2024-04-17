package com.example.paymentsmanager.entities;

import java.util.List;

public class FluxoPagamento {

    private String id;
    private List<Pagamento> pagamentos;

    public FluxoPagamento(String id, List<Pagamento> pagamentos) {
        this.id = id;
        this.pagamentos = pagamentos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
}
