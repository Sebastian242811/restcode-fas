package com.example.salesservice.controller;

import com.example.salesservice.domain.model.Sale;
import com.example.salesservice.domain.model.SaleItem;
import com.example.salesservice.service.SaleItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v2/sale-items")
public class SaleItemController {

    private final SaleItemService service;

    @PostMapping()
    public SaleItem create(@RequestBody() SaleItem saleItem, @RequestParam() Long saleId, @RequestParam() Long productId) {
        return service.create(saleItem, saleId, productId);
    }

    @GetMapping()
    public List<SaleItem> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public SaleItem getOne(@PathVariable(name = "id") Long id) {
        return service.getOne(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable(name = "id") Long id) {
        return service.delete(id);
    }
}