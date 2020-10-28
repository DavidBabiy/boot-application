package com.itdev.bootapplication.service;

import com.itdev.bootapplication.entity.Company;
import com.itdev.bootapplication.model.CompanyModel;
import com.itdev.bootapplication.projection.CompanyProjection;
import com.itdev.bootapplication.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public CompanyProjection getById(Integer id) {
        return repository.findProjectedById(id).orElseThrow(NullPointerException::new);
    }

    public List<CompanyProjection> getAll() {
        return repository.findProjectedBy();
    }

    public CompanyModel create(CompanyModel model) {
        Company company = Company
                .builder()
                .name(model.getName())
                .build();
        repository.save(company);
        model.setId(company.getId());
        return model;
    }

    public CompanyModel update(CompanyModel model) {
        Company company = repository.findById(model.getId()).orElseThrow(NullPointerException::new);
        company.setName(model.getName());
        repository.save(company);
        return model;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
