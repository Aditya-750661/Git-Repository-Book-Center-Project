package com.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.model.Address;
import com.model.Order;

import jakarta.transaction.Transactional;

public interface AddressRepository extends JpaRepository<Address, Long> {


    @Transactional
    @Modifying
    @Query("DELETE FROM Address a WHERE a.id = :addressId")
    void deleteAddressById(@Param("addressId")long addressId);

}
