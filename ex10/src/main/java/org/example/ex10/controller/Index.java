package org.example.ex10.controller;

import org.example.ex10.model.Account;
import org.example.ex10.model.TransferRequest;
import org.example.ex10.services.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class Index {

    private final TransferService trServ;

    public Index(TransferService trServ) {
        this.trServ = trServ;
    }

    @GetMapping("/")
    public String index(Model model) {

        List<Account> res = trServ.getAllAccounts();

        model.addAttribute("accounts", res);

        return "index.html";
    }

    @PostMapping("/transfer")
    public ResponseEntity<List<Account>> putPurchase(@RequestBody TransferRequest request) {

        if(request.getSenderAccountId() == request.getReceiverAccountId())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        trServ.transferMoney(
            request.getSenderAccountId(),
            request.getReceiverAccountId(),
            request.getAmount()
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(trServ.getAllAccounts());
    }

}
