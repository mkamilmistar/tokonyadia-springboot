package com.enigma.tokonyadiaboot.controller;

import com.enigma.tokonyadiaboot.entity.Product;
import com.enigma.tokonyadiaboot.entity.Purchase;
import com.enigma.tokonyadiaboot.service.ProductService;
import com.enigma.tokonyadiaboot.service.PurchaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseResController {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    ProductService productService;

    @GetMapping("/purchase/{id}")
    public Purchase findPurchaseById(@PathVariable(name = "id") String id){
        return purchaseService.getPurchaseById(id);
    }

    @GetMapping("/purchase-customer/{id}")
    public List<Purchase> findPurchaseByCustomer(@PathVariable(name = "id") String customerId){
        return purchaseService.findPurchasesByCustomerId(customerId);
    }

    @GetMapping("/purchases")
    public Page<Purchase> getPurchases(@RequestParam(name = "page") Integer page,
                                       @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return purchaseService.getPurchases(pageable);
    }

    @PostMapping("/purchase")
    public Purchase createPurchase(@RequestBody Purchase purchase) throws JsonProcessingException {
        return purchaseService.createPurchase(purchase);
    }

    @DeleteMapping("/purchase/{id}")
    public void deletePurchase(@PathVariable(name = "id") String id){
        purchaseService.deletePurchase(id);
    }
}
