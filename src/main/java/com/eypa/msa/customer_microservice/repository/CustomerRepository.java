package com.eypa.msa.customer_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eypa.msa.customer_microservice.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
