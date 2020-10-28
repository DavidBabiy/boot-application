package com.itdev.bootapplication.repository;

import com.itdev.bootapplication.entity.Address;
import com.itdev.bootapplication.projection.AddressProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<AddressProjection> findProjectedById(Integer id);
    List<AddressProjection> findProjectedBy();

}
