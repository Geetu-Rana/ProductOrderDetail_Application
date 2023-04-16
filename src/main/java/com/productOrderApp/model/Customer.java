package com.productOrderApp.model;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Customer {

	private Long customerId;
	
	@NotNull
	private String name;
	
	@Min(value = 15,message = "age should be greater than 15" )
	private Integer age;
	
	@Email(message = "email should be in proper format 'example@email.com'")
	private String email;
	
	private String gender;
	
	private Set<Address> addresses;
}
