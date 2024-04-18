package com.example.paymentsmanager.interactors;

import com.example.paymentsmanager.datasources.SistemaFluxosClient;
import com.example.paymentsmanager.entities.FluxoPagamento;
import com.example.paymentsmanager.entities.RetornoProcessamento;
import com.example.paymentsmanager.entities.dtos.GetFluxoByIdResponse;
import com.example.paymentsmanager.entities.dtos.GetFluxosResponse;
import com.example.paymentsmanager.interactors.exceptions.BusinessException;
import com.example.paymentsmanager.interactors.exceptions.NotFoundException;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;

import static com.example.paymentsmanager.utils.ConstantUtils.FLUX_ID;
import static com.example.paymentsmanager.utils.TestUtils.getFluxoByIdResponse;
import static com.example.paymentsmanager.utils.TestUtils.getFluxoPagamento;
import static com.example.paymentsmanager.utils.TestUtils.getRetornoProcessamento;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GerenciadorUseCaseTest {

    @Mock
    private SistemaFluxosClient sistemaFluxosClient;

    @InjectMocks
    private GerenciadorUseCase gerenciadorUseCase;

    @Test
    void buscarFluxos_Success() {
        // Arrange
        GetFluxosResponse expectedResponse = new GetFluxosResponse();
        when(sistemaFluxosClient.getFluxos()).thenReturn(expectedResponse);

        // Act
        GetFluxosResponse response = gerenciadorUseCase.buscarFluxos();

        // Assert
        assertSame(expectedResponse, response);
    }

    @Test
    void processarPagamentos_NoPaymentsToProcess() {
        // Arrange
        String id = "123";
        GetFluxoByIdResponse fluxoByIdResponse = new GetFluxoByIdResponse();
        fluxoByIdResponse.setFluxo(new ArrayList<>());
        when(sistemaFluxosClient.getFluxoById(id)).thenReturn(fluxoByIdResponse);

        // Act and Assert
        assertThrows(BusinessException.class, () -> gerenciadorUseCase.processarPagamentos(id));
    }

    @Test
    void processarPagamentos_Success() throws IOException {
        // Arrange
        RetornoProcessamento expectedRetornoProcessamento = getRetornoProcessamento();
        expectedRetornoProcessamento.getPagamentosProcessados().getFirst().setDataPagamento(OffsetDateTime.now());
        GetFluxoByIdResponse getFluxoByIdResponse = getFluxoByIdResponse();
        getFluxoByIdResponse.getFluxo().getFirst().setData(OffsetDateTime.now().toString());
        when(sistemaFluxosClient.getFluxoById(FLUX_ID)).thenReturn(getFluxoByIdResponse);

        // Act
        RetornoProcessamento retornoProcessamento = gerenciadorUseCase.processarPagamentos(FLUX_ID);

        assertEquals(expectedRetornoProcessamento.getQuantidadeProcessada(), retornoProcessamento.getQuantidadeProcessada());
        assertEquals(expectedRetornoProcessamento.getValorTotalPago(), retornoProcessamento.getValorTotalPago());
    }

    @Test
    void buscarFluxoPagamento_Success() throws IOException {
        // Arrange
        FluxoPagamento expectedResponse = getFluxoPagamento();
        when(sistemaFluxosClient.getFluxoById(any())).thenReturn(getFluxoByIdResponse());

        // Act
        FluxoPagamento response = gerenciadorUseCase.buscarFluxoPagamento(FLUX_ID);

        // Assert
        assertEquals(expectedResponse.getId(), response.getId());
        assertEquals(expectedResponse.getPagamentos().size(), response.getPagamentos().size());
    }

    @Test
    void buscarFluxoPagamento_NotFound() {
        // Arrange
        when(sistemaFluxosClient.getFluxoById(FLUX_ID)).thenThrow(FeignException.class);

        // Act and Assert
        assertThrows(NotFoundException.class, () -> gerenciadorUseCase.buscarFluxoPagamento(FLUX_ID));
    }
}
