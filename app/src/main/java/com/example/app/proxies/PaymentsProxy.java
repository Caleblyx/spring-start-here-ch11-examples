package com.example.app.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.app.models.Payment;

@FeignClient(name="payments", url="${name.service.url}")
public interface PaymentsProxy {
    
    @PostMapping("/payment")
    Payment createPayment(
        @RequestHeader("requestId") String requestId,
        @RequestBody Payment payment
    );
}
