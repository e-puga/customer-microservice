package com.eypa.msa.customer_microservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping("api/types")
@Data
@RefreshScope
public class TypeController {
	
	@Value("${app.testProp}")
	public String testProp;

	@GetMapping("test-prop")
	public String getTestProp() {
		return this.testProp;
	}

}
