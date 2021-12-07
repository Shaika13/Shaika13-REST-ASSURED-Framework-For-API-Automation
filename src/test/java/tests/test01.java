package tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class test01 extends Base{
	
	 
	@Test(priority=0)
	public void GetReq() {
		 		
		response=RestAssured.request(Method.GET,"/users?page=2");
	
	}
	
	
	@Test(priority=1)
	public void checkGetDetails() {
		
		checkResponseBody();
		//checkResponseBodyWithDetails(empId);
		checkStatusCode(200);
		checkStatusLine("HTTP/1.1 200 OK");
		checkContentType("application/json; charset=utf-8");
		checkServerType("cloudflare");
	}
	
	
	@Test(priority=2,dataProvider = "PostData", dataProviderClass = testData.TestDataProvider.class)
	public void PostReq(String name,String job) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		JSONObject request=new JSONObject(map);
		 String rand=randomNumberGenerator();
		request.put("name", name+rand);
		request.put("job", job+rand);
		System.out.println(request.toJSONString());
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(request.toJSONString());
		response=httpRequest.request(Method.POST,"/users");
		
		checkStatusCode(201);
		checkResponseBodyWithDetails(name+rand);
		checkResponseBodyWithDetails(job+rand);
		
	}

	
	@Test(priority=3,dataProvider = "PostData", dataProviderClass = testData.TestDataProvider.class)
	public void PutReq(String name,String job) {
		

		Map<String, Object> map=new HashMap<String, Object>();
		JSONObject request=new JSONObject(map);
		 String rand=randomNumberGenerator();
		request.put("name", name+rand);
		request.put("job", job+rand);
		System.out.println(request.toJSONString());
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(request.toJSONString());
		response=httpRequest.request(Method.PUT,"/users/2");
				

		checkStatusCode(200);
		checkResponseBodyWithDetails(name+rand);
		checkResponseBodyWithDetails(job+rand);
	}
	
	
	@Test(priority=4,dataProvider = "PostData", dataProviderClass = testData.TestDataProvider.class)
	public void PatchReq(String name,String job) {
		

		Map<String, Object> map=new HashMap<String, Object>();
		JSONObject request=new JSONObject(map);
		 String rand=randomNumberGenerator();
		request.put("name", name+rand);
		request.put("job", job+rand);
		System.out.println(request.toJSONString());
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(request.toJSONString());
		response=httpRequest.request(Method.PATCH,"/users/2");
				

		checkStatusCode(200);
		checkResponseBodyWithDetails(name+rand);
		checkResponseBodyWithDetails(job+rand);
	}
	
	
	@Test(priority=5)
	public void DeleteReq() {
		
		response=httpRequest.request(Method.DELETE,"/users/2");
		checkStatusCode(204);
		
		
	}
	
}
