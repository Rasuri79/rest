package datadrivenTesting;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.matcher.RestAssuredMatchers;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Authentications {
	
	@Test(priority=1)
	void testBasicAuthentication() {
		
		
		given()
		 .auth().basic("postman","password") // all authentication should always in given()
		
		.when()
		 .get("https://postman-echo.com/basic-auth")
		 
		 .then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	}
	
	@Test(priority=2)
	void testDigestAuthentication() {
		
		
		given()
		 .auth().digest("postman","password") // all authentication should always in given()
		
		.when()
		 .get("https://postman-echo.com/basic-auth")
		 
		 .then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	}
	@Test(priority=3)
	void testPreemptiveAuthentication() {
		
		
		given()
		 .auth().preemptive().basic("postman","password") // all authentication should always in given()
		
		.when()
		 .get("https://postman-echo.com/basic-auth")
		 
		 .then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	}
	
	@Test(priority=4)
	void testBearerAuthentication() {
		String bearer = "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";
		
		given()
		 .headers("Authorization","Bearer "+bearer) // all authentication should always in given()
		
		.when()
		 .get("https://api.github.com/user/repos")
		 
		 .then()
		  .statusCode(200)
		
		  .log().all();
	}
	//@Test(priority=5)
	void testOAuth1Authentication() {
	
		
		given()
		 .auth().oauth("consumerkey","consumerSecret","AccessToken","TokenSecret")
		
		.when()
		 .get("https://api.github.com/user/repos")
		 
		 .then()
		  .statusCode(200)
		
		  .log().all();
	}
	@Test(priority=6)
	void testOAuth2Authentication() {
		String bearer = "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";
		
		given()
		 .auth().oauth2(bearer)
		
		.when()
		 .get("https://api.github.com/user/repos")
		 
		 .then()
		  .statusCode(200)
		
		  .log().all();
	}

	
	
	@Test(priority=7)
	void testAPIKEYauthentication() {
		
		/*
		 * given() .queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")//appid is
		 * APIKEY
		 * 
		 * .when() .get(
		 * "https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		 * 
		 * .then() .statusCode(200)
		 * 
		 * .log().all();
		 */
		
		
		given()
		.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")
		.pathParam("mypath","data/2.5/forecast/daily" )
		.queryParam("q","Delhi")
		.queryParam("units","metric")
		.queryParam("cnt","7")
		.when()
		.get("https://api.openweathermap.org/{mypath}")
		.then()
		.statusCode(200)
		 
		 .log().all();
		
		
	}
	
	
}
