package com.example.paymentsmanager.datasources;

import com.example.paymentsmanager.configs.FeignConfig;
import com.example.paymentsmanager.entities.dtos.GetFluxoByIdResponse;
import com.example.paymentsmanager.entities.dtos.GetFluxosResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.example.paymentsmanager.utils.ConstantsUtil.CLIENT_URL;

@FeignClient(name = "fluxosClient", url = CLIENT_URL,
        configuration = FeignConfig.class)
public interface SistemaFluxosClient {

    @GetMapping("/fluxos.json")
    @Cacheable("fluxos")
    GetFluxosResponse getFluxos();

    @GetMapping("/fluxos/{id}.json")
    @Cacheable("fluxoById")
    GetFluxoByIdResponse getFluxoById(@PathVariable String id);

}