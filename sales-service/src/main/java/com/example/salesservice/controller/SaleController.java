package com.example.salesservice.controller;

import com.example.salesservice.domain.model.Sale;
import com.example.salesservice.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v2/sales")
public class SaleController {

    private final SaleService service;

    @PostMapping()
    public Sale create(@RequestBody() Sale sale) {
        return service.create(sale);
    }

    @GetMapping()
    public List<Sale> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Sale getOne(@PathVariable(name = "id") Long id) {
        return service.getOne(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable(name = "id") Long id) {
        return service.delete(id);
    }
}
