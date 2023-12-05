package com.store.car.service;

import com.store.car.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostServiceImpl implements CarPostService{

    @Override
    public void newPostDetails(CarPostDto carPostDto) {

    }

    @Override
    public List<CarPostDto> getAllCarSales() {
        return null;
    }

    @Override
    public void updateCarForSale(CarPostDto carPostDto, Long postId) {

    }

    @Override
    public void removeCarForSale(Long postId) {

    }
}
