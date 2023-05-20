package RestAssured.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_ExtractValuesofEachNodeinJson {

	@Test
	public void getweatherdetails() {
		
		//Specify base uri
		//RestAssured.baseURI = "https://hotels4.p.rapidapi.com/v2/";
		RestAssured.baseURI = "https://gorest.co.in/public/v2/";
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		//Response object
		//Response response = httpRequest.request(Method.GET,"/get-meta-data");
		Response response = httpRequest.request(Method.GET,"/users?id=1026721");
		//print response in console
		//String responseBody = response.getBody().asString();
		//System.out.println("Response body is"+responseBody);
		
	    JsonPath jsonpath =response.jsonPath();
	    System.out.println("id is "+jsonpath.get("id"));
	    System.out.println("Name is "+jsonpath.get("name"));
	    System.out.println("Email is "+jsonpath.get("email"));
	    System.out.println("Gender is "+jsonpath.get("gender"));
	    System.out.println("Status is "+jsonpath.get("status"));
	
		Assert.assertEquals(jsonpath.get("name"),"Usha Gandhi VM");
		
		
	}
}
