package com.store.car.repository;

import com.store.car.dto.CarPostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostDto, Long> {
}
