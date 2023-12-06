package com.store.car.service;

import com.store.car.dto.CarPostDto;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService{

    @Autowired
    private CarPostRepository carPostRepository;
    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDto carPostDto) {
      CarPostEntity carPostEntity = mapCarDtoToEntity(carPostDto);
      carPostRepository.save(carPostEntity); 
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDto carPostDto) {
        CarPostEntity carPostEntity = new CarPostEntity();
        ownerPostRepository.findById(carPostDto.getOwnerId()).ifPresentOrElse(item->{
            carPostEntity.setOwnerId(item.getId());
            carPostEntity.setContact(item.getContactNumber());
        }, ()->{
            throw new RuntimeException();
        });

        carPostEntity.setModel(carPostDto.getModel());
        carPostEntity.setBrand(carPostDto.getBrand());
        carPostEntity.setCity(carPostDto.getCity());
        carPostEntity.setDescription(carPostDto.getDescription());
        carPostEntity.setEngineVersion(carPostDto.getEngineVersion());
        carPostEntity.setCreateDate(String.valueOf(new Date()));
        carPostEntity.setPrice(carPostDto.getPrice());
        carPostEntity.setOwnerType(carPostDto.getOwnerType());
        carPostEntity.setOwnerName(carPostDto.getOwnerName());
        carPostEntity.setContact(carPostDto.getContact());
        return carPostEntity;
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
