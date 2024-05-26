package org.example.ex9.controller;

import org.example.ex9.beans.PurchaseRepository;
import org.example.ex9.model.Purchase;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Index {

    private final PurchaseRepository purRep;

    public Index(PurchaseRepository purRep) {
        this.purRep = purRep;
    }

    @GetMapping("/")
    public String index(Model model) {

        List<Purchase> findAllPur = purRep.findAllPurchases();

        model.addAttribute("purchase", findAllPur);

        return "index.html";
    }

    @PostMapping("/")
    public ResponseEntity<Purchase> putPurchase(@RequestBody Purchase purchase){

        purRep.storePurchase(purchase);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(purchase);
    }
}
