package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	Response response ;
	@Test
	public void getProfileRequestTest()
	{
		//Generate a authorization token
		AuthService authService = new AuthService();
		response = authService.login(new LoginRequest("Sachin7972","Sachin7972"));
		LoginResponse loginResponse= response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		
		//get a profile details
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		
	}
}
