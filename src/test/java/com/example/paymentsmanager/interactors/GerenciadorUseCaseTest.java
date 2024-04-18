package com.example.paymentsmanager.interactors;

import com.example.paymentsmanager.datasources.SistemaFluxosClient;
import com.example.paymentsmanager.entities.dtos.GetFluxoByIdResponse;
import com.example.paymentsmanager.entities.dtos.GetFluxosResponse;
import com.example.paymentsmanager.interactors.exceptions.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
}
