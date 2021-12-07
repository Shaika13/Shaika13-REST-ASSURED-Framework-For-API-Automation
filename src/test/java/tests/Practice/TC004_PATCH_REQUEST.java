package tests.Practice;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import configurations.config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TC004_PATCH_REQUEST {

	@Test(priority=0)
	public void test01() {
		
		Map<String, Object> map=new HashMap<String, Object>();
		JSONObject request=new JSONObject(map);
		
		request.put("name", "abc");
		request.put("job", "Automatedjob");
		System.out.println(request.toJSONString());
		
		RestAssured.given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().patch(config.baseUrI1+"/users/2").then().statusCode(200).
		log().all();
		
		
	}
	
}
