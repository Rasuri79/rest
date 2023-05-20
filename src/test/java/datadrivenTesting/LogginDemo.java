package datadrivenTesting;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class LogginDemo {
	
	//@Test
	void testLogDemo() {
		
		given()
		.when()
		 .get("http://reqres.in/api/users?page=2")
		.then()
		 .log().body();//print only body not header

	}
	//@Test
	void getLogDemo() {
		
		given()
		.when()
		 .get("http://reqres.in/api/users?page=2")
		.then()
		 .log().headers();//print only  headers not body

	}
	@Test
	void testLogCookieDemo() {
		
		given()
		.when()
		 .get("http://www.google.com/")
		.then()
		 .log().cookies();//print only cookies of response

	}

}
