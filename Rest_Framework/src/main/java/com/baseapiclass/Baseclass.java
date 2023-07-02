package com.baseapiclass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	public static Response GetRequest(String requesturl)
	{
		//request
		RequestSpecification requestspecification=RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		Response response=requestspecification.get(requesturl);
		return response;
	}
	public static Response postRequest(String requesturl, String requestPayload, String bearer_token)
	{
		RequestSpecification requestspecification=RestAssured.given().body(requestPayload);
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization","Bearer "+bearer_token);
		Response response=requestspecification.post(requesturl);
		return response;
		
	}
	public static Response postRequest(String requesturl,String bearer_token)
	{
		RequestSpecification requestspecification=RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization","Bearer "+bearer_token);
		Response response=requestspecification.post(requesturl);
		return response;
	}
	public static Response putRequest(String requesturl, String requestPayload, String bearer_token)
	{
		RequestSpecification requestspecification=RestAssured.given().body(requestPayload);
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization","Bearer "+bearer_token);
		Response response=requestspecification.post(requesturl);
		return response;
	}
	public static Response deleteRequest(String requesturl, String requestPayload, String bearer_token)
	{
		RequestSpecification requestspecification=RestAssured.given().body(requestPayload);
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization","Bearer "+bearer_token);
		Response response=requestspecification.delete(requesturl);
		return response;
	}
}
