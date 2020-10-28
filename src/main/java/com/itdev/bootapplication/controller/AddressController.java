package com.itdev.bootapplication.controller;

import com.itdev.bootapplication.entity.Address;
import com.itdev.bootapplication.model.AddressModel;
import com.itdev.bootapplication.projection.AddressProjection;
import com.itdev.bootapplication.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService dataService;

    @Autowired
    public AddressController(AddressService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressProjection> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(dataService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AddressProjection>> getAll() {
        return new ResponseEntity<>(dataService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressModel> create(@RequestBody AddressModel model) {
        return new ResponseEntity<>(dataService.create(model), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AddressModel> update(@RequestBody AddressModel model) {
        return new ResponseEntity<>(dataService.update(model), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        dataService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
