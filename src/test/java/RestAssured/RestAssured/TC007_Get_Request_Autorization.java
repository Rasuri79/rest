package RestAssured.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_Get_Request_Autorization {

	@Test
	public void getweatherdetails() {

	//Specify base uri
	RestAssured.baseURI = "https://demoqa.com/Account/v1/Authorized";
	
	PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
	authScheme.setUserName("raj");
	authScheme.setPassword("raj@134");
	RestAssured.authentication = authScheme;
	
	
	//Request Object
	RequestSpecification httpRequest = RestAssured.given();
	//Response object
	
	Response response = httpRequest.request(Method.GET,"/");
	//print response in console
	String responseBody = response.getBody().asString();
	System.out.println("Response body is"+responseBody);
	
	
	//status code validation
	int statuscode = response.getStatusCode();
	System.out.println(statuscode);
	Assert.assertEquals(statuscode,200);
	//status line validation
	String statusline =response.getStatusLine();
	System.out.println(statusline);
	//HTTP/1.1 401 Unauthorized
	Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
}
}