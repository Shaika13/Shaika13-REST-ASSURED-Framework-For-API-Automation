package tests.Practice;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import configurations.config;
import io.restassured.RestAssured;

public class TC003_PUT_REQUEST {

	@Test(priority=0)
	public void test01() {
		
		Map<String, Object> map=new HashMap<String, Object>();
		JSONObject request=new JSONObject(map);
		
		request.put("name", "abc");
		request.put("job", "Automatedjob");
		System.out.println(request.toJSONString());
		
		RestAssured.given().body(request.toJSONString()).when().put(config.baseUrI1+"/users/2").then().statusCode(200).log().all();
		
		
	}
	
	
}
