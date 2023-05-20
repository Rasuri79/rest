package chaining;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class GetUser {
	
	@Test
	void testGetUser(ITestContext context) {
		int id =  (int) context.getSuite().getAttribute("user_id") ;
		String bearerToken = (String) context.getSuite().getAttribute("Token");
		given()
		 .header("Authorization","Bearer "+bearerToken)
		 .pathParam("id",id)
		.when()
		 .get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		 .statusCode(200)
		 .log().all();
	}
	

}
