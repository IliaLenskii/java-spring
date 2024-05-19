package org.example.ex8.beans;

import org.example.ex8.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class RestTemplProxy {

    @Value("${bank.url}")
    private String paymentsServiceUrl;

    public String createPayment(Payment payment) {
        String uri = paymentsServiceUrl + "/payment-to-bank";

        var rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
                    headers.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);

        ResponseEntity<String> response = rest.exchange(uri, HttpMethod.POST, httpEntity, String.class);

        return response.getBody();
    }
}
