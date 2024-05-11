package org.example.ex7.controller;

import org.example.ex7.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerCountry {

    @GetMapping("/country")
    public Country country() {

        return Country.of("Night City", 123);
    }

    @GetMapping("/countries")
    public List<Country> countries() {

        return List.of(
                Country.of("Night City", 123),
                Country.of("Fsfgs", 321)
        );
    }

    @GetMapping("/resp-entity")
    public ResponseEntity<Country> city() {

        var c = Country.of("USA", 12345);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "NA")
                .header("capital", "Washington")
                .body(c);
    }

    @PostMapping("/add-country")
    public ResponseEntity<Country> addCountry(
            @RequestBody Country country
    ) {

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(country);
    }

    @GetMapping("/err")
    public void throwException() {

        throw new Error("My exception");
    }
}
