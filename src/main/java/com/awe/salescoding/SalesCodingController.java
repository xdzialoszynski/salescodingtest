package com.awe.salescoding;

import com.awe.salescoding.data.Input;
import com.awe.salescoding.data.Output;
import com.awe.salescoding.service.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesCodingController {

    @Autowired
    TaxeService taxeService;

    @PostMapping("/sales/output")
    private ResponseEntity<Output> getOutput(@RequestBody Input input) {
        return ResponseEntity.ok(taxeService.computeOutput(input));
    }

    @GetMapping("/titi")
    private ResponseEntity<String> getCoucou(){
        return ResponseEntity.ok("coucou");
    }
}

