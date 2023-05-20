package RestAssured.RestAssured;

import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class TC001_Get_Request {

	@Test
	public void getweatherdetails() {
		
		//Specify base uri
		//RestAssured.baseURI = "https://hotels4.p.rapidapi.com/v2/";
		RestAssured.baseURI = "https://gorest.co.in/public/v2/";
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		//Response object
		//Response response = httpRequest.request(Method.GET,"/get-meta-data");
		Response response = httpRequest.request(Method.GET,"/posts");
		//print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is"+responseBody);
		//status code validation
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		//Assert.assertEquals(statuscode,200);
		//status line validation
		String statusline =response.getStatusLine();
		System.out.println(statusline);
		//HTTP/1.1 401 Unauthorized
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
		
		
	}
	
}
