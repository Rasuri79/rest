package datadrivenTesting;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class HeadersDemo {
	
	//@Test(priority=1)
	void testHeaders() {
		
		given()
		
		.when()
		 .get("http://www.google.com/")
		 
		 
		.then()
		 .header("Content-Type","text/html; charset=ISO-8859-1")
		 .header("Content-Encoding","gzip")
		 .header("Server","gws");
	
	}
	    @Test(priority=2)
		void getHeaders() {
			
			Response res=given()
			
			.when()
			 .get("http://www.google.com/");
			 // get single header info
			 //String headervalue=res.getHeader("Content-Type");
			// System.out.println("the value of content-type is  "+headervalue);
			
			// get all header info  //log().header() also prints all header info 
			 Headers myheaders = res.getHeaders();
			 
			 for(Header hd:myheaders) {
				 
				 System.out.println(hd.getName()+"    "+hd.getValue());
			 }
			 
			
			
			
		}
}
