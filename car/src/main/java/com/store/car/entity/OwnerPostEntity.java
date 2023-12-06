package com.store.car.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "owner_post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerPostEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "owner_type")
    private String type;

    @Column(name = "owner_contact_number")
    private String contactNumber;
}

