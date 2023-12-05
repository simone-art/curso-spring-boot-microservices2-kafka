package com.store.car.service;

import com.store.car.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    // Método que vai salvar o post via Kakfa e não apiRest
    void newPostDetails(CarPostDto carPostDto);
    List<CarPostDto> getAllCarSales();
    void updateCarForSale(CarPostDto carPostDto, Long postId);
    void removeCarForSale(Long postId);
}
