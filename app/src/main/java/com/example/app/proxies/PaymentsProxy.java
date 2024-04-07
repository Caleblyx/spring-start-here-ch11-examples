package com.example.app.proxies;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.method.annotation.HttpHeadersReturnValueHandler;

import com.example.app.models.Payment;

import reactor.core.publisher.Mono;

@Component
public class PaymentsProxy {
    
    private final WebClient webClient;

    @Value("${name.service.url}")
    private String paymentsServiceUrl;

    public PaymentsProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(String requestId, Payment payment) {
        String uri = paymentsServiceUrl + "/payment";

        return webClient.post()
                    .uri(paymentsServiceUrl + "/payment")
                    .header("requestId", requestId)
                    .body(Mono.just(payment), Payment.class)
                    .retrieve()
                    .bodyToMono(Payment.class);

    }
}
