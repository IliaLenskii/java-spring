package org.example.ex8.controller;

import org.example.ex8.beans.RestTemplProxy;
import org.example.ex8.beans.WebClientProxy;
import org.example.ex8.model.Payment;
import org.example.ex8.services.feignclient.IPaymentsProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@RestController
public class RestPayment {

    private final IPaymentsProxy feignclient;

    private final RestTemplProxy restTemplProxy;

    private final WebClientProxy webClientProxy;

    public RestPayment(
            IPaymentsProxy feignclient,
            RestTemplProxy restTemplProxy,
            WebClientProxy webClientProxy
    ) {
        this.feignclient = feignclient;
        this.restTemplProxy = restTemplProxy;
        this.webClientProxy = webClientProxy;
    }

    @GetMapping("/")
    public String index() {

        return "index - ok";
    }

    // FeignClient
    @PostMapping("/payment")
    public ResponseEntity<String> payment(@RequestBody Payment payment) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body( feignclient.createPayment(payment) );
    }

    // RestTemplate
    @PostMapping("/rest-template")
    public ResponseEntity<String> paymentRestTemplate(@RequestBody Payment payment) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body( restTemplProxy.createPayment(payment) );
    }

    // WebClient
    @PostMapping("/web-client")
    public Mono<String> paymentWebClient(@RequestBody Payment payment) {

        return webClientProxy.createPayment(payment);
    }
}
