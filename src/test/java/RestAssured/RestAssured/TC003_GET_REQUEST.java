package RestAssured.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_REQUEST {

	@Test
	public void getweatherdetails() {

		// Specify base uri
		// RestAssured.baseURI = "https://hotels4.p.rapidapi.com/v2/";
		RestAssured.baseURI = "https://gorest.co.in/public/v2";
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		// Response object
		// Response response = httpRequest.request(Method.GET,"/get-meta-data");
		Response response = httpRequest.request(Method.GET, "/users");
		// print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is" + responseBody);
		// status code validation
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		// Assert.assertEquals(statuscode,200);
		//  Need to verified  
		//Status code status line 
		// ResponseTime
		// Headers
		// Response body

		// status line validation
		String statusline = response.getStatusLine();
		System.out.println(statusline);
		// HTTP/1.1 401 Unauthorized
		// Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
		Headers allheaders = response.headers(); // captures all the headers from response and methode type should be
													// header

		for (Header header : allheaders) {

			System.out.println(header.getName() + "                " + header.getValue());
		}

	}
}
