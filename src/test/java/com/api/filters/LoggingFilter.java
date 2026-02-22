package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{
	
	private static final Logger Logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
	logRequest(requestSpec);
	Response response	= ctx.next(requestSpec,responseSpec);
	logResponse(response);
	return response; //Test for assertion
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		Logger.info("BASE URI:"+ requestSpec.getBaseUri());
		Logger.info("Request Header:"+ requestSpec.getHeaders());
		Logger.info("Request PayLoad:"+ requestSpec.getBody());
		
	}
	
	public void logResponse(Response responseSpec) {
		Logger.info("STATUS CODE:"+ responseSpec.getStatusCode());
		Logger.info("RESPONSE HEADER:"+ responseSpec.headers());
		Logger.info("RESPONSE HEADER:"+ responseSpec.getBody().asPrettyString());
	}


}
