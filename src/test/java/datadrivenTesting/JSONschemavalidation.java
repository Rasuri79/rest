package datadrivenTesting;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JSONschemavalidation {
	
	
	//json -- jsonschema converter
	//https://jsonformatter.org/json-to-jsonschema?utm_content=anc-true
	
	@Test
	void jsonschemavalidation() {
		
		
		given()
		
		.when()
		 .get("http://localhost:3000/Store")
		 .then()
		 .statusCode(200)
		 .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("StoreJsonSchema.json") );
		
		
	}
	
	

}
