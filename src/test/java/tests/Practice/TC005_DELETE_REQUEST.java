package tests.Practice;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import configurations.config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TC005_DELETE_REQUEST {

	
	@Test(priority=0)
	public void test01() {
		
		
		RestAssured.given().when().delete(config.baseUrI1+"/users/2").then().statusCode(204).
		log().all();
		
		
	}
	
}
