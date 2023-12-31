package com.store.car.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="car_post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarPostEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "car_model")
    private String model;

    @Column(name = "car_brand")
    private String brand;

    @Column(name = "car_price")
    private Double price;

    @Column(name = "car_description")
    private String description;

    @Column(name = "car_engine_version")
    private String engineVersion;

    @Column(name = "car_city")
    private String city;

    @Column(name = "car_create-date")
    private String createDate;

    @Column(name = "car_owner_id")
    private Long ownerId;

    @Column(name = "car_owner_name")
    private String ownerName;

    @Column(name = "car_owner_type")
    private String ownerType;

    @Column(name = "car_contact")
    private String contact;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_post_entity_id", nullable = false, referencedColumnName = "id")
    private OwnerPostEntity ownerPostEntity;


}
