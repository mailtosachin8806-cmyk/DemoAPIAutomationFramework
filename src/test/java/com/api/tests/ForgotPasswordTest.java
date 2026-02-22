package com.api.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	
	@Test(description="Verfiy if Forgot Password API is working....")
	public void forgotPasswordTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("gharsele96@gmail.com");
		System.out.println(response.asPrettyString());
	}

}
