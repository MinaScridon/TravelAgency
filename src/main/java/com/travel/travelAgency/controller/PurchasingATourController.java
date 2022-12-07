package com.travel.travelAgency.controller;

import com.travel.travelAgency.dto.PurchasingATourDto;
import com.travel.travelAgency.entities.Tour;
import com.travel.travelAgency.service.PurchasingATourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PurchasingATourController {
    private final PurchasingATourService purchasingATourService;
    private Tour tour;

    @GetMapping("/purchases")
    public ResponseEntity<List<PurchasingATourDto>> findAllThePurchases() {
        List<PurchasingATourDto> allPurchases = purchasingATourService.findAllPurchases();
        return new ResponseEntity<>(allPurchases, HttpStatus.OK);
    }

    @GetMapping("/purchases/{idPurchasingATour}")
    public ResponseEntity<PurchasingATourDto> findByIdPurchasingATour(@PathVariable Long idPurchasingATour) {
        PurchasingATourDto purchasingATourDto = purchasingATourService.findById(idPurchasingATour).get();
        return new ResponseEntity<>(purchasingATourDto, HttpStatus.OK);
            }




    @PostMapping("/createPurchase")
    public ResponseEntity<PurchasingATourDto> createPurchase(@RequestBody PurchasingATourDto purchasingATourDto) {
        PurchasingATourDto purchasingATourDto1 = purchasingATourService.createPurchase(purchasingATourDto);
        return new ResponseEntity<>(purchasingATourDto1, HttpStatus.OK);
    }

    @PutMapping("/editPurchase/{idPurchasingATour}")
    public ResponseEntity<PurchasingATourDto> editPurchase(
            @RequestBody PurchasingATourDto purchasingATourDto, @PathVariable Long idPurchasingATour) {
        PurchasingATourDto purchasingATourDto1 = purchasingATourService.editPurchase(idPurchasingATour, purchasingATourDto);

        return new ResponseEntity<>(purchasingATourDto1, HttpStatus.OK);
    }

    @DeleteMapping("/deletePurchase/{idPurchasingATour}")
    public ResponseEntity<?> deletePurchase(@PathVariable Long idPurchasingATour) {
        purchasingATourService.deletePurchase(idPurchasingATour);
        return new ResponseEntity<>(
                "The purchase with name " + idPurchasingATour + " has been deleted successfully.", HttpStatus.OK);
    }
}
