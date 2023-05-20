package RestAssured.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_REQUEST {

	@Test
	public void getweatherdetails() {
		
		//Specify base uri
		//RestAssured.baseURI = "https://hotels4.p.rapidapi.com/v2/";
		RestAssured.baseURI = "https://gorest.co.in/public/v2";
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		//Response object
		//Response response = httpRequest.request(Method.GET,"/get-meta-data");
		Response response = httpRequest.request(Method.GET,"/users");
		//print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is"+responseBody);
		//VALIDATING HEADERS
		String content_type = response.header("Content-Type");//capture details of content header
		System.out.println("Content-Type is "+content_type);
		Assert.assertEquals(content_type, "application/json; charset=utf-8");
		String content_encoding = response.header("Content-Encoding");//capture details of content Encoding
		System.out.println("Content-Encoding is "+content_encoding);
		Assert.assertEquals(content_encoding, "gzip");
}
}
