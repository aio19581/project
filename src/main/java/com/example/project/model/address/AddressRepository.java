package com.example.project.model.address;

import com.example.project.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {
    List<Address> findAllByOrderByCityAsc();
}
