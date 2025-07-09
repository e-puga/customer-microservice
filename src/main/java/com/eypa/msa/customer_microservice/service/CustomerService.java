package com.eypa.msa.customer_microservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eypa.msa.customer_microservice.entity.CustomerEntity;
import com.eypa.msa.customer_microservice.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository _customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        _customerRepository = customerRepository;
    }

    public CustomerEntity addCustomer(CustomerEntity customer){
        return _customerRepository.save(customer);
    }

    public List<CustomerEntity> getAllCustomer(){
        return _customerRepository.findAll();
    }

    public CustomerEntity getCustomerById(long id){
        return _customerRepository.findById(id).orElseThrow(() ->  new RuntimeException("Customer no exists"));
    }

    public CustomerEntity updateCustomer(CustomerEntity customer){
        if(!_customerRepository.existsById(customer.getId())){
            throw new RuntimeException("Customer not found with id " + customer.getId());
        }
        return _customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
        if(!_customerRepository.existsById(id)){
            throw new RuntimeException("Customer not found with id " + id);
        }
        _customerRepository.deleteById(id);
    }
}
