package com.teresa.ubicua.repository;

import com.teresa.ubicua.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
