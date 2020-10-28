package com.itdev.bootapplication.controller;

import com.itdev.bootapplication.model.EmployeeModel;
import com.itdev.bootapplication.projection.EmployeeFullProjection;
import com.itdev.bootapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService dataService;

    @Autowired
    public EmployeeController(EmployeeService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeFullProjection> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(dataService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeFullProjection>>getAll() {
        return new ResponseEntity<>(dataService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeModel> create(@RequestBody EmployeeModel model) {
        return new ResponseEntity<>(dataService.create(model), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EmployeeModel> update(@RequestBody EmployeeModel model) {
        return new ResponseEntity<>(dataService.update(model), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        dataService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
