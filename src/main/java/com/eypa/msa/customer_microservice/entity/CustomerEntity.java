package com.eypa.msa.customer_microservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerEntity {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private LocalDateTime created_at = LocalDateTime.now();

}
