package datadrivenTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Datadriven_AddnewEmployees {

	@Test
	public void getweatherdetails() {

		// Specify base uri
		RestAssured.baseURI = "https://demoqa.com/Account/v1/";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		// we created which can be send along with post request
		JSONObject requestParams = new JSONObject();

		requestParams.put("userName", "Raj189");
		requestParams.put("password", "R@j14569");
		// add a header stating request state is json
		httpRequest.header("Content-Type", "application/json");
		// add the json to body of the request
		httpRequest.body(requestParams.toJSONString());
		// POST REQUEST
		Response response = httpRequest.request(Method.POST, "/User");

		// capture response body to perform validations
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(responseBody.contains("Raj189"),true);
	    int statuscode = response.statusCode();
		System.out.println(statuscode);
	}
}
