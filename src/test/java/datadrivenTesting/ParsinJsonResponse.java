package datadrivenTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsinJsonResponse {
	// @Test(priority=1)
	void testParseJson() {

		// Aproach1

		/*
		 * given() .contentType("ContentType.JSON")
		 * 
		 * .when() .get("http://localhost:3000/Store")
		 * 
		 * .then() .statusCode(200)
		 * .header("Content-Type","application/json; charset=utf-8")
		 * .body("book[2].title",equalTo("the little soldiers"));
		 */

		// Aproach2

		Response res = given().contentType("ContentType.JSON")

				.when().get("http://localhost:3000/Store");

		Assert.assertEquals(res.statusCode(), 200);// validation1
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		String bookName = res.jsonPath().get("book[2].title").toString();
		Assert.assertEquals(bookName, "the little soldiers");

	}

	@Test(priority = 2)
	void testJsonResponseBodyData() {
		Response res = given()
				.contentType("ContentType.JSON")

				.when().get("http://localhost:3000/Store");

		/*
		 * Assert.assertEquals(res.statusCode(),200);//validation1
		 * Assert.assertEquals(res.header("Content-Type")
		 * ,"application/json; charset=utf-8"); String
		 * bookName=res.jsonPath().get("book[2].title").toString();
		 * Assert.assertEquals(bookName,"the little soldiers");
		 */

		JSONObject jo = new JSONObject(res.asString());// converting response to json object type -jo is json object
   // search for title of the book
		boolean status = false;
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {

			String booktitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();

			if (booktitle.equals("the little soldiers")) {
				status = true;
				break;
			                 }

		                  }
		Assert.assertEquals(status, true);
      
		//validate total price of books
		 double totalprice=0;
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {

			String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();

			totalprice=totalprice+Double.parseDouble(price); //Integer.parseInt to convert string  into integer 
			                                             }
           // System.out.println(totalprice);
		  Assert.assertEquals(totalprice,3901);
		  
	}
		               
	}


