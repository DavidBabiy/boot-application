package com.itdev.bootapplication.service;

import com.itdev.bootapplication.entity.Address;
import com.itdev.bootapplication.entity.Company;
import com.itdev.bootapplication.entity.Employee;
import com.itdev.bootapplication.model.EmployeeModel;
import com.itdev.bootapplication.projection.AddressProjection;
import com.itdev.bootapplication.projection.EmployeeFullProjection;
import com.itdev.bootapplication.repository.AddressRepository;
import com.itdev.bootapplication.repository.CompanyRepository;
import com.itdev.bootapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public EmployeeService(EmployeeRepository repository,
                           AddressRepository addressRepository,
                           CompanyRepository companyRepository) {
        this.employeeRepository = repository;
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
    }

    public EmployeeFullProjection getById(Integer id) {
        return employeeRepository.findProjectedById(id).orElseThrow(NullPointerException::new);
    }

    public List<EmployeeFullProjection> getAll() {
        return employeeRepository.findProjectedBy();
    }

    public EmployeeModel create(EmployeeModel model) {
        List<Company> companies = new ArrayList<>();
        model.getCompanyIds().forEach(id -> {
            companies.add(companyRepository.findById(id).orElseThrow(NullPointerException::new));
        });
        Address address = addressRepository.findById(model.getAddressId()).orElseThrow(NullPointerException::new);
        Employee employee = Employee
                .builder()
                .address(address)
                .companies(companies)
                .name(model.getName())
                .salary(model.getSalary())
                .build();
        employeeRepository.save(employee);
        model.setId(employee.getId());
        return model;
    }

    public EmployeeModel update(EmployeeModel model) {
        Employee employee = employeeRepository.findById(model.getId()).orElseThrow(NullPointerException::new);
        List<Company> companies = new ArrayList<>();
        model.getCompanyIds().forEach(id -> {
            companies.add(companyRepository.findById(id).orElseThrow(NullPointerException::new));
        });
        Address address = addressRepository.findById(model.getAddressId()).orElseThrow(NullPointerException::new);
        employee.setAddress(address)
                .setCompanies(companies)
                .setName(model.getName())
                .setSalary(model.getSalary());
        employeeRepository.save(employee);
        model.setId(employee.getId());
        return model;
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

}
