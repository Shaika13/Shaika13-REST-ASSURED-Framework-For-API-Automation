package tests.Practice;
import org.testng.Assert;
import org.testng.annotations.Test;

import configurations.config;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_REQUEST {

	
	@Test(priority=0)
	public void Test01() {
		
		//RestAssured.baseURI=config.baseUrI1;
		//RequestSpecification req=RestAssured.given();
		
		
		//Response response=req.request(Method.GET,"/Hyderabad");
		
		Response res=RestAssured.get(config.baseUrI1+"/users?page=2");
		System.out.println("Response status code is: " +res.getStatusCode());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		
		Assert.assertEquals(res.getStatusCode(),200);
		System.out.println("1st Test passed");
		
	
	}
	
	@Test(priority=1)
	public void Test02() {
		
		RestAssured.given().get(config.baseUrI1+"/users/2").then().statusCode(200);
		System.out.println("2nd Test passed");
	}
	
}
