package chaining;



import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {
	
	@Test
	void testcreateUser(ITestContext context) {
	
	Faker faker = new Faker();
	
	JSONObject data =new JSONObject();
  
	data.put("name",faker.name().firstName());
	data.put("gender","Male");

	data.put("email",faker.internet().safeEmailAddress());
	data.put("status","inactive");
	
	String bearerToken = "d48c96e4c19e73b97e1650c80a7e56ed9eb52b746c0e3574338ff352a064cd2f";
	
	int id =given()
	 .header("Authorization","Bearer "+bearerToken)
	 .contentType("application/json")
	 .body(data.toString())
	 .when()
	  .post("https://gorest.co.in/public/v2/users")
	  .jsonPath().getInt("id");
	System.out.println("Generated id is "+id);
	 	//context.setAttribute("user_id",id); available only in test level
      //context.setAttribute("Token", bearerToken);
      context.getSuite().setAttribute("user_id",id);  //available in suite level
      context.getSuite().setAttribute("Token", bearerToken);
}
}
