package datadrivenTesting;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.matcher.RestAssuredMatchers;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class XmlSchemaValidation {

	
	@Test
	void XMLschemavalidation() {
		
		
		given()
		
		.when()
		 .get("http://restapi.adequateshop.com/api/Traveler")
		 .then()
		 .statusCode(200)
		 .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlschema.xsd"));
		
		
	}
	
	
}
