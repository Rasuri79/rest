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
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpRequest {

	int id ;
	
	@Test(priority=1)
	void getUser() {

		        given()

				.when()
				.get("https://reqres.in/api/users?page=2")

				.then()
				.statusCode(200)
				.body("page", equalTo(2))
				.log().all();

	}

	@Test(priority=2)
	void createUser() {
		
		HashMap data = new HashMap();
		data.put("name","John");
		data.put("job","Employee");
		
	  given()
	        .contentType("application/json")
	        .body(data)
	 
	   .when()
	       .post("https://reqres.in/api/users")
	       .jsonPath().getInt("id");
	     //  .jsonPath().getString("name");
	     
	   
	  // .then()
	    //  .statusCode(201)
	    //  .log().all();
	  
	}
	@Test(priority=2,dependsOnMethods= {"createUser"})// updateUser will execte after create user by using 
	                                                      //dependsOnMethods= {"createUser"}
	void UpdateUser() {
		
		HashMap data = new HashMap();
		data.put("name","Rajkumar");
		data.put("job","SoftwareEngineer");
		
	  given()
	        .contentType("application/json")
	        .body(data)
	 
	   .when()
	       .post("https://reqres.in/api/users/"+id)//id we are getting dynamically from create user test case
	     
	   
	   .then()
	      .statusCode(201)
	      .log().all();
	  
	}
	  @Test(priority=4)
      void deleteUser() {
    	  
    	  given()
    	  
    	  .when() 
    	    .delete("https://reqres.in/api/users/"+id) 
    	    
    	  .then()
    	   .statusCode(204)
    	   .log().all();
    	  
      }
}
