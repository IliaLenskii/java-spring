package org.example.ex8.controller;

import org.example.ex8.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestBank {

    @PostMapping("/payment-to-bank")
    public ResponseEntity<String> payment(@RequestBody Payment payment) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("successful at bank - ok + restTempl + WebClient");
    }
}
