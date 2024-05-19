package org.example.ex8.services.feignclient;

import org.example.ex8.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paymentsToBank", url = "${bank.url}")
public interface IPaymentsProxy {

    @PostMapping("/payment-to-bank")
    String createPayment(@RequestBody Payment payment);
}