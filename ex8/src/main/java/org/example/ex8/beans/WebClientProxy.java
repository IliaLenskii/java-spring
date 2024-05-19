package org.example.ex8.beans;

import org.example.ex8.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientProxy {

    private final WebClient webClient;

    public WebClientProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    @Value("${bank.url}")
    private String paymentsServiceUrl;

    public Mono<String> createPayment(Payment payment) {

        String uri = paymentsServiceUrl + "/payment-to-bank";

        return webClient
                .post()
                .uri(uri)
                .body(Mono.just(payment), Payment.class)
                .retrieve()
                .bodyToMono(String.class);
    }
}
