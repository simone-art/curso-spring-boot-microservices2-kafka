package com.store.car.service;

import com.store.car.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createdOwnerPots(OwnerPostDto ownerPostDto);
}
