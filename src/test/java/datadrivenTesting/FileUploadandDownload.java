package datadrivenTesting;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
public class FileUploadandDownload {
	@Test(priority=1)
	void singleFileUpload() {
		 File myfile =new File("D:\\Manual testing\\RestApi\\Day17.txt");
		given()
		 .multiPart("file",myfile)
		 .contentType("multipart/form-data")
		 .when()
		  .post("http://localhost:8080/uploadFile")
		 .then()
		   .statusCode(200)
		   .body("fileName",equalTo("Day17.txt"))
		   .log().all();
		
	}
	
	//@Test
	void MultipleFileUpload() {
		 File myfile1 =new File("D:\\Manual testing\\RestApi\\Day17.txt");
		 File myfile2 =new File("D:\\Manual testing\\RestApi\\Notes.txt");
		given()
		 .multiPart("files",myfile1)
		 .multiPart("files",myfile2)
		 .contentType("multipart/form-data")
		 .when()
		  .post("http://localhost:8080/uploadMultipleFiles")
		 .then()
		   .statusCode(200)
		   .body("[0].fileName",equalTo("Day17.txt"))
		   .body("[1].fileName",equalTo("Notes.txt"))
		   .log().all();
		
	}
	
	@Test(priority=2)
	void downloadfile() {
		
		given()
		
		.when()
		 .get("http://localhost:8080/downloadFile/Day17.txt")
		.then()
		.statusCode(200)
		.log().body();
		
	}
	
	}

