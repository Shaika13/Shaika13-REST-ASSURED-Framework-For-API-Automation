package tests;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import configurations.config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Base {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public Logger logger;
	
	
	
	@BeforeClass
	public void setup() {
		
		logger=Logger.getLogger("RESTAssuredAutomation");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		RestAssured.baseURI=config.baseUrI1;
		httpRequest= RestAssured.given();

	}
	
	
	public void checkResponseBody() {
		
	String responseBody=response.getBody().asString();
	logger.info("Response Body is: "+responseBody);
	Assert.assertTrue(responseBody!=null);	
	
	}
	
	public void checkResponseBodyWithDetails(String detail) {
		
		String responseBody=response.getBody().asString();
		Assert.assertEquals(responseBody.contains(detail), true);	
		
	}
	
	
	public void checkStatusCode(int code) {
		
		int statusCode=response.getStatusCode();
		String sc=Integer.toString(statusCode);
		logger.info("Status code is: "+sc);
		Assert.assertEquals(statusCode, code);
		
		
	}
	
	public void checkResponseTime() {
		
		long responseTime= response.getTime();
		logger.info("Response Time is: "+responseTime);
		Assert.assertTrue(responseTime<2000);
		
	}
	
	public void checkStatusLine(String status) {
		
		String statusLine=response.getStatusLine();
		logger.info("Status Line is: "+statusLine);
		Assert.assertEquals(statusLine, status);
		
	}

	
	public void checkContentType(String content) {
		
		String contentType=response.header("Content-Type");
		Assert.assertEquals(contentType, content);
	}
	
	public void checkServerType(String server) {
		
		String serverType=response.header("Server");
		logger.info("Server Type is: "+serverType);
		Assert.assertEquals(serverType, server);
			
	}
	
	public void checkContentEncoding(String encoding) {
		
		String contentEncoding=response.header("Content-Encoding");
		logger.info("Content Encoding is: "+contentEncoding);
		Assert.assertEquals(contentEncoding, encoding);
	}
	
	
	public void checkContentLength() {
		
		String contentLength=response.header("Content-Length");
		logger.info("Content Length is: "+contentLength);
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
		
	}
	
	
	public void checkCookies(String cookiename) {
		
		String cookie=response.getCookie(cookiename);
		System.out.println(cookie);
		
	}

	public String randomNumberGenerator() {
		
		
		int min = 5;
	    int max = 500;
	    //Generate random int value from 50 to 100 
	    System.out.println("Random value in int from "+min+" to "+max+ ":");
	    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	    System.out.println(random_int);
	    String num=Integer.toString(random_int);
	    return num;
	
	}
	
	@AfterClass
	public void teardown() {
		
		logger.info("Finished all the tests.");
	}
}
