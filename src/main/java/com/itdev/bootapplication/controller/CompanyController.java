package com.itdev.bootapplication.controller;

import com.itdev.bootapplication.model.CompanyModel;
import com.itdev.bootapplication.projection.CompanyProjection;
import com.itdev.bootapplication.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService dataService;

    @Autowired
    public CompanyController(CompanyService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyProjection> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(dataService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CompanyProjection>> getAll() {
        return new ResponseEntity<>(dataService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyModel> create(@RequestBody CompanyModel model) {
        return new ResponseEntity<>(dataService.create(model), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CompanyModel> update(@RequestBody CompanyModel model) {
        return new ResponseEntity<>(dataService.update(model), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        dataService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
