package com.example.paymentsmanager.transporlayers;

import com.example.paymentsmanager.entities.FluxoPagamento;
import com.example.paymentsmanager.entities.RetornoProcessamento;
import com.example.paymentsmanager.entities.dtos.GetFluxosResponse;
import com.example.paymentsmanager.interactors.GerenciadorUseCase;
import com.example.paymentsmanager.transportlayers.impl.GerenciadorController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GerenciadorControllerTest {

    @Mock
    private GerenciadorUseCase gerenciadorUseCase;
    @InjectMocks
    private GerenciadorController gerenciadorController;

    @Test
    void buscarFluxoPagamento() {
        // Arrange
        String idFluxo = UUID.randomUUID().toString();
        FluxoPagamento fluxoPagamento = new FluxoPagamento();
        when(gerenciadorUseCase.buscarFluxoPagamento(idFluxo)).thenReturn(fluxoPagamento);

        // Act
        ResponseEntity<FluxoPagamento> responseEntity = gerenciadorController.buscarFluxoPagamento(idFluxo);

        // Assert
        verify(gerenciadorUseCase).buscarFluxoPagamento(idFluxo);
        assertEquals(fluxoPagamento, responseEntity.getBody());
    }

    @Test
    void buscarFluxos() {
        // Arrange
        GetFluxosResponse getFluxosResponse = new GetFluxosResponse();
        when(gerenciadorUseCase.buscarFluxos()).thenReturn(getFluxosResponse);

        // Act
        ResponseEntity<GetFluxosResponse> responseEntity = gerenciadorController.buscarFluxos();

        // Assert
        verify(gerenciadorUseCase).buscarFluxos();
        assertEquals(getFluxosResponse, responseEntity.getBody());
    }

    @Test
    void processarFluxo() {
        // Arrange
        String idFluxo = "123";
        RetornoProcessamento retornoProcessamento = new RetornoProcessamento();
        when(gerenciadorUseCase.processarPagamentos(idFluxo)).thenReturn(retornoProcessamento);

        // Act
        ResponseEntity<RetornoProcessamento> responseEntity = gerenciadorController.processarFluxo(idFluxo);

        // Assert
        verify(gerenciadorUseCase).processarPagamentos(idFluxo);
        assertEquals(retornoProcessamento, responseEntity.getBody());
    }
}
