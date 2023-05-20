package chaining;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

public class DeleteUser {
	
	@Test
	void testDeleteUser(ITestContext context) {
		String bearerToken = (String) context.getSuite().getAttribute("Token");
		
		int id = (int) context.getSuite().getAttribute("user_id") ;
		given()
		 .header("Authorization","Bearer "+bearerToken)
		 .pathParam("id",id)
		 
		 .when()
		 .delete("https://gorest.co.in/public/v2/users/{id}")
		 
		.then()
		.statusCode(204)
		.log().all();
		
		
		
	}
	
	

}
