package com.example.paymentsmanager.utils;

import com.example.paymentsmanager.entities.FluxoPagamento;
import com.example.paymentsmanager.entities.RetornoProcessamento;
import com.example.paymentsmanager.entities.dtos.GetFluxoByIdResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class TestUtils {

    public static GetFluxoByIdResponse getFluxoByIdResponse() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        File file = new File("src/test/resources/fluxo-response.json");
        return mapper.readValue(file, GetFluxoByIdResponse.class);
    }

    public static FluxoPagamento getFluxoPagamento() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        File file = new File("src/test/resources/fluxo-pagamento.json");
        return mapper.readValue(file, FluxoPagamento.class);
    }

    public static RetornoProcessamento getRetornoProcessamento() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        File file = new File("src/test/resources/retorno-processamento.json");
        return mapper.readValue(file, RetornoProcessamento.class);
    }
}
