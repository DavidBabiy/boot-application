package com.itdev.bootapplication.service;

import com.itdev.bootapplication.entity.Address;
import com.itdev.bootapplication.entity.Company;
import com.itdev.bootapplication.model.AddressModel;
import com.itdev.bootapplication.model.CompanyModel;
import com.itdev.bootapplication.projection.AddressProjection;
import com.itdev.bootapplication.projection.CompanyProjection;
import com.itdev.bootapplication.repository.AddressRepository;
import com.itdev.bootapplication.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public AddressProjection getById(Integer id) {
        return repository.findProjectedById(id).orElseThrow(NullPointerException::new);
    }

    public List<AddressProjection> getAll() {
        return repository.findProjectedBy();
    }

    public AddressModel create(AddressModel model) {
        Address address = Address
                .builder()
                .city(model.getCity())
                .street(model.getStreet())
                .apartmentNumber(model.getApartmentNumber())
                .houseNumber(model.getHouseNumber())
                .build();
        repository.save(address);
        model.setId(address.getId());
        return model;
    }

    public AddressModel update(AddressModel model) {
        Address address = repository.findById(model.getId()).orElseThrow(NullPointerException::new);
        address.setApartmentNumber(model.getApartmentNumber())
                .setCity(model.getCity())
                .setStreet(model.getStreet())
                .setHouseNumber(model.getHouseNumber());
        repository.save(address);
        return model;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
