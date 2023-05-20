package datadrivenTesting;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class PathandQueryParameters {

	   //http://reqres.in/api/users?page=2&id=5
	
	     
	@Test
	void testQueryandPathParameter() {
		
		given()
		 .pathParam("myPath","users") //path parameters
		 .queryParam("page",2)  //query parameters
		 .queryParam("id",5)  //query parameters
		.when()
		 .get("http://reqres.in/api/{myPath}")
		.then()
		.statusCode(200)
		.log().all();
		
		
		
	}
	
	
}
