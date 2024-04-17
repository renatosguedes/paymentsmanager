package com.example.paymentsmanager.configs;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import feign.RequestInterceptor;
import feign.Util;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder() {
        return (response, type) -> {
            String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
            JavaType javaType = TypeFactory.defaultInstance().constructType(type);
            return new ObjectMapper().readValue(bodyStr, javaType);
        };
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Delay interrupted", e);
            }
        };
    }
}
