package com.api.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	
	@Test(description="Verfiy if SignUP API is working....")
	public void creatAccountTest() {
		
		SignUpRequest signUpRequest	= new SignUpRequest.Builder()
		.username("Sac2456")
		.email("Sac1@yahoo.com")
		.firstName("Sac")
		.password("Sa2456")
		.lastName("Sac2456")
		.mobileNumber("7888885521")
		.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		//Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);
		
		
	}

}
