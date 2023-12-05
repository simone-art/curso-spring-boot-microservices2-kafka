package com.store.car.service;

import com.store.car.dto.CarPostDto;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService{

    @Autowired
    private CarPostRepository carPostRepository;

    @Override
    public void newPostDetails(CarPostDto carPostDto) {

    }

    @Override
    public List<CarPostDto> getAllCarSales() {
        List<CarPostDto> listCarSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item->{
            listCarSales.add(mapCarEntityToDto(item));
        });
        return listCarSales;
    }




    private CarPostDto mapCarEntityToDto(CarPostEntity carPostEntity) {
        return CarPostDto.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createDate(carPostEntity.getCreateDate())
                .price(carPostEntity.getPrice())
                .ownerType(carPostEntity.getOwnerType())
                .ownerName(carPostEntity.getOwnerName())
                .contact(carPostEntity.getContact())
                .build();
    }

    @Override
    public void updateCarForSale(CarPostDto carPostDto, Long postId) {
        carPostRepository.findById(postId).ifPresentOrElse(item-> {
            item.setModel(carPostDto.getModel());
            item.setBrand(carPostDto.getBrand());
            item.setPrice(carPostDto.getPrice());
            item.setDescription(carPostDto.getDescription());
            item.setEngineVersion(carPostDto.getEngineVersion());
            item.setCity(carPostDto.getCity());
            item.setCreateDate(carPostDto.getCreateDate());
            item.setOwnerType(carPostDto.getOwnerName());
            item.setOwnerName(carPostDto.getOwnerName());
            item.setContact(carPostDto.getContact());

            carPostRepository.save(item);
        }, ()->{
            throw new NoSuchElementException();
        });

    }

    @Override
    public void removeCarForSale(Long postId) {
        carPostRepository.deleteById(postId);

    }
}
