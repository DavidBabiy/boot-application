package com.itdev.bootapplication.repository;

import com.itdev.bootapplication.entity.Company;
import com.itdev.bootapplication.projection.CompanyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<CompanyProjection> findProjectedById(Integer id);
    List<CompanyProjection> findProjectedBy();

}
