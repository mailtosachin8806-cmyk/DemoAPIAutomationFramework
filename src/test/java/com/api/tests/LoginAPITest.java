package com.api.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class LoginAPITest {
	
	@Test(description="Verfiy if login API is working....")
	public void loginTest()
	{
		//RestAssured.base -> no need to write a RestAssured if i use import static io.restassured.RestAssured.*
	//	baseURI = "http://64.227.160.186:8080";	
		
		
		Response response = given().baseUri("http://64.227.160.186:8080")
				.log().all().header("Content-Type","application/json")
				.body("{\r\n"
				+ "  \"username\": \"Sachin7972\",\r\n"
				+ "  \"password\": \"Sachin7972\"\r\n"
				+ "}").when().post("/api/auth/login").then().log().all().extract().response();
		
		// System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
