package com.itdev.bootapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String city;
    @Column(name = "house_number")
    private Integer houseNumber;
    @Column(name = "apartment_number")
    private Integer apartmentNumber;

    @OneToOne(mappedBy = "address")
    private Employee employee;

}
