package com.itdev.bootapplication.repository;

import com.itdev.bootapplication.entity.Employee;
import com.itdev.bootapplication.projection.EmployeeFullProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<EmployeeFullProjection> findProjectedById(Integer id);
    List<EmployeeFullProjection> findProjectedBy();

}
