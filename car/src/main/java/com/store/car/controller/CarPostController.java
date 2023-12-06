package com.store.car.controller;

import com.store.car.dto.CarPostDto;
import com.store.car.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDto>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getAllCarSales());
    }


    @PutMapping("/car/{id}")
    public ResponseEntity updateCarForSale (@RequestBody CarPostDto carPostDto, @PathVariable("id") String id){
        carPostService.updateCarForSale(carPostDto, Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity deleteCarForSale (@PathVariable("id") String id){
        carPostService.removeCarForSale(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
