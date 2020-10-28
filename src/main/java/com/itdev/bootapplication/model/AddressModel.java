package com.itdev.bootapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {

    private Integer id;
    private String street;
    private String city;
    private Integer houseNumber;
    private Integer apartmentNumber;

}
