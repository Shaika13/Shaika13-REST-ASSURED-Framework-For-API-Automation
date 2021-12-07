package tests.Practice;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import configurations.config;
import io.restassured.RestAssured;

public class TC002_POST_REQUEST {

	@Test(priority=0)
	public void test01() {
		
		Map<String, Object> map=new HashMap<String, Object>();
		JSONObject request=new JSONObject(map);
		
		request.put("name", "abc");
		request.put("job", "Automatedjob");
		System.out.println(request.toJSONString());
		
		RestAssured.given().body(request.toJSONString()).when().post(config.baseUrI1+"/users").then().statusCode(201).log().all();
		
		
	}
	
	
	@Test(priority=1)
	public void test02() {
		

		Map<String, Object> map=new HashMap<String, Object>();
		JSONObject request=new JSONObject(map);
		
		request.put("email","abc@yopmail.com");
		
		System.out.println(request.toJSONString());
		
		RestAssured.given().body(request.toJSONString()).when().post(config.baseUrI1+"/register").then().statusCode(400).log().all();
		
		
	}
	
}
