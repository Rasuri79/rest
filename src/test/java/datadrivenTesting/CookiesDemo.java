package datadrivenTesting;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {

	// @Test(priority=1)
	void testCookies() {

		given()

				.when().get("http://www.google.com/")
				
				.then()
				.cookie("AEC", "ARSKqsKG41axhZ-M0i6G2e4dM0QCkNBhHoJ-2j5sDlm7-etCtmbTpUfDmoA")// SHOULD FAIL has cookies
																								// will keep changing
																								// for every hit

				.log().all();

	}

	@Test(priority = 2)
	void getCookiesInfo() {

		Response res = given() // declare res variable here

				.when()
				.get("http://www.google.com/");

		// get single cookie info
		//String cookie_value = res.getCookie("AEC");
		//System.out.println(cookie_value);
		
		//get cookies info
		Map<String, String> cookies_values = res.getCookies();
		//System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k+"     "+cookie_value);
			
		}
		
		

	}
}
