package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;
import junit.framework.Assert;

public class UpdateProfileTest {
	
	Response response ;
	
	@Test(description= "Verfiy if Profile Update API is working....")
	public void UpdateProfileTest()
	{
		AuthService authService = new AuthService();
		response = authService.login(new LoginRequest("Sachin7972","Sachin7972"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		
		System.out.println("--------Token Generated------------------");
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "Sachin7972");
		
		System.out.println("--------Profile Created---------------");
		
		ProfileRequest profileRequest	= new ProfileRequest.Builder()
				.firstName("Disha")
				.lastName("Dsaw")
				.email("Disha1234@gmail.com")
				.mobileNumber("1111122223")
				.Build();
					
		response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		
		System.out.println(response.asPrettyString());
		System.out.println("-----------Profile Update---------------");
		
		
	}

}
