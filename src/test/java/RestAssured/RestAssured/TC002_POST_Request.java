package RestAssured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	@Test
	public void getUserPostDetails() {
		
		//Specify base uri
				//RestAssured.baseURI = "https://hotels4.p.rapidapi.com/v2/";
				RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		        // RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
				//Request Object
				RequestSpecification httpRequest = RestAssured.given();
				
				//Request payload sending along with post request
			
				JSONObject requestParams = new JSONObject();
				
				requestParams.put("userId","TQ123");
				requestParams.put("isbn","9734783258629");
				                          
				// requestParams.put("id","674589");
				// requestParams.put("name","Mohan");
				//requestParams.put("email","kali@gmail.com");
				//requestParams.put("gender","male");
				//requestParams.put("status","active");
				httpRequest.header("Content-Type","application/json");
				
				//attach above data to request
				httpRequest.body(requestParams.toJSONString());
				//Response object
				//Response response = httpRequest.request(Method.GET,"/get-meta-data");
				//Response response = httpRequest.request(Method.POST,"/BookStoreV1BooksPost");
				//Response response = httpRequest.request(Method.POST,"/public/v2/users");
				Response response = httpRequest.post("/BookStoreV1BooksPost"); 
				//print response in console
				String responseBody = response.getBody().asString();
				System.out.println("Response body is"+responseBody);
				//status code validation
				int statuscode = response.getStatusCode();
				System.out.println(statuscode);
				//Assert.assertEquals(statuscode,200);
				//status line validation
				//String statusline =response.getStatusLine();
				//System.out.println(statusline);
				//HTTP/1.1 401 Unauthorized
				//Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
				
	}

}
