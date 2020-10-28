package com.itdev.bootapplication.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeModel {

    private Integer id;
    private String name;
    private Integer salary;
    private Integer addressId;
    private List<Integer> companyIds = new ArrayList<>();

}
