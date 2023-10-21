package com.api.cucumber.stepDef;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class stepDefRead {

	Response resp;
	SoftAssert sf = new SoftAssert();
	
	@Given ("Go to https://httpbin.org/get")
	public void getURL() {
		resp = RestAssured.get("https://httpbin.org/get");
		
		
	}
	@Then ("Check connection correctly with status code 200 or not")
	public void getStatus() {
		sf.assertEquals(resp.statusCode(),200);
		
	}
	@And ("Check if response time is less than 200 ms")
	public void getResponse () {
		sf.assertTrue(resp.time()<2000);
	}
	@And ("Header check test data format is json or not")
	public void getFormat() {
		sf.assertTrue(resp.contentType().contains("json"));
	}
	@And ("Check body response should not be null")
	public void getBody() {
		sf.assertTrue(!resp.body().toString().equals(null));
	}
	@And ("Check attritubute origin should be there") 
	public void attribute() {
		sf.assertTrue(resp.body().toString().contains("origin"));
		
	}
	@And ("Check URL value should contains get only")
	public void getURLValue() {
		JsonPath jp =  resp.jsonPath();	
		System.out.println(" URL value = " + jp.get("url"));
	   // sf.assertTrue(jp.get("url").toString().contains("get"));
		sf.assertEquals(jp.get("url"), "https://httpbin.org/get");
	    sf.assertAll();
		
		
	}
	

}
