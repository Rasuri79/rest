package pojo;

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

//pojo -- serialize --- JsonObject  --- deserailize --- pojo
public class SerializationDeserialization {

	
	@Test(priority=1)
	void convertPojo2Json() throws JsonProcessingException {
		//Serialization
		
		// created java object using pojo class
		StudentPojo studentpojo = new StudentPojo(); //pojo
		studentpojo.setName("Scott");
		studentpojo.setLocation("France");
		studentpojo.setPhone("8179640892");
		String courseArr[] = { "c++", "c#" };
		studentpojo.setCourses(courseArr);
		
		//convert java object  -- json object  (serialization)
		
		ObjectMapper objMap = new ObjectMapper(); 
		//always should import  object mapper from com.fasterxml.jackson.databind.ObjectMapper;
		
		String jsondata = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(studentpojo);
		// above statement convert java object to string
		System.out.println(jsondata);
		
	}
	
	//json ----- pojo
	
	//Deserialization
	
	@Test(priority=2)
	void convertJsontoPojo() throws JsonMappingException, JsonProcessingException {
		
		String jsondata= "{\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"8179640892\",\r\n"
				+ "  \"courses\" : [ \"c++\", \"c#\" ]\r\n"
				+ "}";
		
		//convert jsondata to pojo object
		
		ObjectMapper objMap = new ObjectMapper();
		
		StudentPojo stu = objMap.readValue(jsondata,StudentPojo.class);
		
		System.out.println(stu.getName());
		System.out.println(stu.getLocation());
		System.out.println(stu.getPhone());
		System.out.println(stu.getCourses()[0]);
		System.out.println(stu.getCourses()[1]);
		
	}
	
	
}
