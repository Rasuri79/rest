package chaining;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	void testUpdateUser(ITestContext context) {
	
	Faker faker = new Faker();
	
	JSONObject data =new JSONObject();
  
	data.put("name",faker.name().firstName());
	data.put("gender","Male");

	data.put("email",faker.internet().safeEmailAddress());
	data.put("status","active");
	
	String bearerToken = (String) context.getSuite().getAttribute("Token");
	
	int id = (int) context.getSuite().getAttribute("user_id") ;
	given()
	 .header("Authorization","Bearer "+bearerToken)
	 .contentType("application/json")
	 .pathParam("id",id)
	 .body(data.toString())
	 .when()
	  .put("https://gorest.co.in/public/v2/users/{id}")
	 
	 
	  .then()
	  .statusCode(200)
	  .log().all();
	 	
     
}
}
