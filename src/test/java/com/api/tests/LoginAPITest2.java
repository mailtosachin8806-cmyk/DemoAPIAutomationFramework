package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;


@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest2 {
	
	@Test(description="Verfiy if login API is working....")
	public void loginTest()
	{
		LoginRequest loginRequest= new LoginRequest("Sachin7972","Sachin7972");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getUsername());
		
	}
	
}
