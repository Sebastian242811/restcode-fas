package com.example.salesservice.service;

import com.example.salesservice.domain.client.ProductClient;
import com.example.salesservice.domain.model.SaleItem;
import com.example.salesservice.domain.repository.SaleItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleItemService {
    private final SaleItemRepository repository;
    private final SaleService saleService;
    private final ProductClient productClient;

    public SaleItem create(SaleItem item, Long saleId, Long productId) {
        item.setSale(saleService.getOne(saleId));
        item.setProduct(productClient.getOne(productId));
        return repository.save(item);
    }

    public List<SaleItem> getAll(){
        return repository.findAll();
    }

    public SaleItem getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public SaleItem update(SaleItem item) {
        SaleItem _item = getOne(item.getId());
        _item.setQuantity(item.getQuantity());
        _item.setPrice(item.getPrice());
        _item.setOnSale(item.getOnSale());
        return repository.save(_item);
    }

    public ResponseEntity<?> delete(Long id){
        SaleItem item = getOne(id);
        repository.delete(item);
        return ResponseEntity.ok().build();
    }

}