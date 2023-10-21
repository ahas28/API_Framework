package curdOperations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GET_Read {
	
	Response resp;
	SoftAssert sf = new SoftAssert();
	
	@BeforeTest
	public void setUp() {
	resp = RestAssured.get("https://httpbin.org/get");
	}
	
	@Test(priority = 0)
	public void getStausCode() {
		sf.assertEquals(resp.statusCode(),200);
	}	
	@Test(priority = 1)
	public void getResponseTime() {
		sf.assertTrue(resp.time()<2000);
	}
	@Test(priority = 2)
	public void getHeaderDataType () {
		sf.assertTrue(resp.contentType().contains("json"));
	}
	@Test(priority = 3)
	public void getBodyNullCheck() {
	sf.assertTrue(!resp.body().toString().equals(null));
	
	}
	@Test(priority = 4)
	public void getCheckAttributeKey() {
	sf.assertTrue(resp.body().toString().contains("origin"));
	}
	
	@Test(priority = 5)
	public void getURLValue() {
	JsonPath jp =  resp.jsonPath();	
	System.out.println(" URL value = " + jp.get("url"));
   // sf.assertTrue(jp.get("url").toString().contains("get"));
	sf.assertEquals(jp.get("url"), "https://httpbin.org/get");
    sf.assertAll();
	
	}
	
	@AfterTest
	public void tearDown() {
		
	}

}
