package datadrivenTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ParsingXML {
	
	//@Test(priority=1)
	void testXML() {
		
		/*
		 * Approach1 
		 * given()
		 * 
		 * .when() 
		 * .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		 * 
		 * .then() .statusCode(200)
		 * .header("Content-Type","application/xml; charset=utf-8")
		 * .body("TravelerinformationResponse.page", equalTo("1"))
		 * .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",
		 * equalTo("Developer"));
		 */
		
		
		//Appraoch 2
		
		Response res =given()
		
		  .when() 
		  .get("http://restapi.adequateshop.com/api/Traveler?page=1");
	      Assert.assertEquals(res.statusCode(),200);
		  Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
		  String pageNo =res.xmlPath().get("TravelerinformationResponse.page").toString();
		  // to convert data into string use tostring()
		  Assert.assertEquals(pageNo,"1");
		  String name =res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		  Assert.assertEquals(name,"Developer");
	}
	
	@Test(priority=2)
	void testXMLResponse() {
		
		Response res =given()
				
				  .when() 
				  .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlObj= new XmlPath(res.asString());
		//to convert object into string use asString();
		// to convert data into string use tostring()
		List<String> travellers = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(),10);
		List<String> travellers_name = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean status = false;
		for(String name:travellers_name) {
			
			System.out.println(name);
			if(name.equals("Developer")) {
				status=true;
				break;
			}
			
		}
		
		Assert.assertEquals(status,true);
		
	}
	

}
