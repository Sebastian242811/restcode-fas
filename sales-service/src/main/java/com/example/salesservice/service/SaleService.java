package com.example.salesservice.service;

import com.example.salesservice.domain.model.Sale;
import com.example.salesservice.domain.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleService {
    private final SaleRepository repository;

    private final SaleItemService saleItemService;

    public Sale create(Sale sale) {
        sale.getItems().forEach(saleItem -> {
            saleItemService.create(saleItem);
        });
        return repository.save(sale);
    }

    public Sale update(Sale sale) {
        Sale existingObj = getOne(sale.getId());
        existingObj.setCurrency(sale.getCurrency());
        return repository.save(existingObj);
    }

    public Sale getOne(Long id) {
        return repository.getById(id);
    }

    public List<Sale> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<?> delete(Long id){
        Sale sale = getOne(id);
        repository.delete(sale);
        return ResponseEntity.ok().build();
    }
}
