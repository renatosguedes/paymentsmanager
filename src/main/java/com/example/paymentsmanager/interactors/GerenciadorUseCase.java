package com.example.paymentsmanager.interactors;

import com.example.paymentsmanager.datasources.SistemaFluxosClient;
import com.example.paymentsmanager.entities.FluxoPagamento;
import com.example.paymentsmanager.entities.Pagamento;
import com.example.paymentsmanager.entities.RetornoProcessamento;
import com.example.paymentsmanager.entities.dtos.GetFluxoByIdPagamentoResponse;
import com.example.paymentsmanager.entities.dtos.GetFluxoByIdResponse;
import com.example.paymentsmanager.entities.dtos.GetFluxosResponse;
import com.example.paymentsmanager.entities.enums.StatusPagamento;
import com.example.paymentsmanager.interactors.exceptions.BusinessException;
import com.example.paymentsmanager.interactors.exceptions.NotFoundException;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.paymentsmanager.utils.ConstantsUtil.NOT_FOUND;
import static com.example.paymentsmanager.utils.ConstantsUtil.NO_PAYMENTS_TO_PROCESS;

@Service
public class GerenciadorUseCase {

    private final SistemaFluxosClient sistemaFluxosClient;

    public GerenciadorUseCase(SistemaFluxosClient sistemaFluxosClient) {
        this.sistemaFluxosClient = sistemaFluxosClient;
    }

    public GetFluxosResponse buscarFluxos() {
        return sistemaFluxosClient.getFluxos();
    }

    public RetornoProcessamento processarPagamentos(String id) {
        List<Pagamento> pagamentosProcessados = new ArrayList<>();
        double valorPago = 0.0;
        int quantidade = 0;
        for (Pagamento p : buscarFluxoPagamento(id).getPagamentos()) {
            if (p.getStatusPagamento().equals(StatusPagamento.PAGAMENTO_PENDENTE)) {
                p.setStatusPagamento(StatusPagamento.REALIZADO);
                pagamentosProcessados.add(p);
                valorPago = valorPago + p.getValorPagamento();
                quantidade++;
            }
        }
        if (quantidade == 0) {
            throw new BusinessException(NO_PAYMENTS_TO_PROCESS);
        }
        return new RetornoProcessamento(id, quantidade, valorPago, pagamentosProcessados);
    }

    public FluxoPagamento buscarFluxoPagamento(String id) {
        try {
            return converterFluxo(sistemaFluxosClient.getFluxoById(id));
        } catch (FeignException e) {
            throw new NotFoundException(NOT_FOUND);
        }
    }

    private FluxoPagamento converterFluxo(GetFluxoByIdResponse getFluxoByIdResponse) {
        FluxoPagamento response = new FluxoPagamento();
        response.setId(getFluxoByIdResponse.getId());
        response.setPagamentos(converterPagamento(getFluxoByIdResponse.getFluxo()));
        return response;
    }

    private List<Pagamento> converterPagamento(List<GetFluxoByIdPagamentoResponse> pagamentos) {
        List<Pagamento> response = new ArrayList<>();
        for (GetFluxoByIdPagamentoResponse p : pagamentos) {
            OffsetDateTime data = OffsetDateTime.parse(p.getData());
            Pagamento pagamento = new Pagamento();
            pagamento.setDataPagamento(data);
            pagamento.setStatusPagamento(getStatusPagamento(data));
            pagamento.setValorPagamento(p.getPmt());
            response.add(pagamento);
        }
        return response;
    }

    private static StatusPagamento getStatusPagamento(OffsetDateTime data) {
        OffsetDateTime agora = OffsetDateTime.now();
        if (agora.isAfter(data)) {
            return StatusPagamento.REALIZADO;
        }
        if (agora.isBefore(data)) {
            return StatusPagamento.A_VENCER;
        }
        return StatusPagamento.PAGAMENTO_PENDENTE;
    }

}