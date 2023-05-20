package datadrivenTesting;

/* given()
 * content-type,set cookies,add auth,add param,set headers info 
 * */
/* when()
 * get,post,put,delete
 */
/* then()
 * validate status code,extract response,extract headerrs cookies & response body
 */
//Should import below static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class PostRequestUsingExtJsonfile {
	@Test
	void postExtjsonFile() throws FileNotFoundException {

		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f); // read text from files
		JSONTokener jt = new JSONTokener(fr); // takes source string and extracts characters and token from it
		JSONObject data = new JSONObject(jt);

		given()

		 .contentType("application/json")
		 .body(data.toString()) // when using json object data should be send as string

			.when()
			 .post("http://localhost:3000/students")

			   .then()
				.statusCode(201)
				.body("name", equalTo("Scott"))
				.body("location", equalTo("France"))
				.body("phone", equalTo("8179640892"))

				.body("courses[0]", equalTo("c++"))
				.body("courses[1]", equalTo("c#"))

				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();

	}
	
	//deleting student record
	@Test(priority=2)
	void testDelete() {
		
		 given()
   	  
   	  .when() 
   	    .delete("http://localhost:3000/students/5") 
   	    
   	  .then()
   	   .statusCode(200)
   	   .log().all();
		
	}
	
}
