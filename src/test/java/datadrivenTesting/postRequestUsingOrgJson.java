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



import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class postRequestUsingOrgJson {
	

	// Post request body using org.json library
	//prerequisite to org.json dependency in pom.xml
	
	//@Test(priority=1)
	void testPostusingJsonObject() {
		
		JSONObject data =new JSONObject();		
		data.put("name","Scott");
		data.put("location","France");
		data.put("phone","8179640892");
		String courseArr[] = {"c++","c#"};
		data.put("courses",courseArr);
		
		 given()
		  .contentType("application/json")
		  .body(data)   //when using json object data should be send as string
		 
		  .when()
		   .post("http://localhost:3000/students")
		  
		   
		  .then()
		   .statusCode(201)
		   .body("name",equalTo("Scott"))
		   .body("location",equalTo("France"))
		   .body("phone",equalTo("8179640892"))
		   
		   .body("courses[0]",equalTo("c++"))
		   .body("courses[1]",equalTo("c#"))
		  
		   .header("Content-Type","application/json; charset=utf-8") 
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
