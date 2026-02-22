package com.api.base;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.api.models.request.LoginRequest;
import com.api.filters.*;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseService {

	/*
	 * Wrapper for Rest Assured!!! This class is responsible for to handling below methods 
	 * 1. Base URI 
	 * 2. Creating the request 
	 * 3. Handling the response
	 */

	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	
	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {

		requestSpecification = given().baseUri(BASE_URL);
	}

	public Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	public Response putRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}

	public Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}

	public RequestSpecification setAuthToken(String token) {
		return requestSpecification.header("Authorization", "Bearer " + token);
	}

}
