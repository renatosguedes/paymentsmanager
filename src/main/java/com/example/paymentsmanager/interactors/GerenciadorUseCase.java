package com.example.paymentsmanager.interactors;

import com.example.paymentsmanager.datasources.SistemaFluxosClient;
import com.example.paymentsmanager.entities.FluxoPagamento;
import com.example.paymentsmanager.entities.Pagamento;
import com.example.paymentsmanager.entities.dtos.GetFluxoByIdPagamentoResponse;
import com.example.paymentsmanager.entities.dtos.GetFluxoByIdResponse;
import com.example.paymentsmanager.entities.dtos.GetFluxosResponse;
import com.example.paymentsmanager.entities.enums.StatusPagamento;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GerenciadorUseCase {

    private final SistemaFluxosClient sistemaFluxosClient;

    public GerenciadorUseCase(SistemaFluxosClient sistemaFluxosClient) {
        this.sistemaFluxosClient = sistemaFluxosClient;
    }

    public GetFluxosResponse buscarFluxos() {
        return sistemaFluxosClient.getFluxos();
    }

    public FluxoPagamento buscarFluxoPagamento(String id) {
        return converterFluxo(sistemaFluxosClient.getFluxoById(id));
    }

    private FluxoPagamento converterFluxo(GetFluxoByIdResponse getFluxoByIdResponse) {
        FluxoPagamento response = new FluxoPagamento();
        response.setId(getFluxoByIdResponse.getId());
        response.setPagamentos(converterPagamento(getFluxoByIdResponse.getFluxo()));
        return response;
    }

    private List<Pagamento> converterPagamento(List<GetFluxoByIdPagamentoResponse> pagamentos) {
        OffsetDateTime agora = OffsetDateTime.now();
        List<Pagamento> response = new ArrayList<>();
        for (GetFluxoByIdPagamentoResponse p : pagamentos) {
            OffsetDateTime data = OffsetDateTime.parse(p.getData());
            Pagamento pagamento = new Pagamento();
            pagamento.setDataPagamento(data);
            pagamento.setStatusPagamento(agora.isBefore(data) ? StatusPagamento.PENDENTE : StatusPagamento.REALIZADO);
            pagamento.setValorPagamento(p.getPmt());
            response.add(pagamento);
        }
        return response;
    }

}
