package com.eypa.msa.customer_microservice.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eypa.msa.customer_microservice.entity.CustomerEntity;
import com.eypa.msa.customer_microservice.service.CustomerService;

@RestController
@RequestMapping("/customer")

public class CustomerController {
	
	private final CustomerService _customerService;

    public CustomerController(CustomerService customerService){
        this._customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerEntity> add(@RequestBody CustomerEntity customer) {
        CustomerEntity savedCustomer = _customerService.addCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/views")
    public List<CustomerEntity> views(){
        return _customerService.getAllCustomer();
    }

    @GetMapping("/views/{id}")
    public ResponseEntity<CustomerEntity> views(@PathVariable Long id){
        try{
            CustomerEntity customer = _customerService.getCustomerById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerEntity> update(@RequestBody CustomerEntity customer) {
        try{
            CustomerEntity updatedCustomer = _customerService.updateCustomer(customer);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try{
            _customerService.deleteCustomer(id);
            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }

}
