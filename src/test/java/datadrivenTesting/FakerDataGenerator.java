package datadrivenTesting;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class FakerDataGenerator {

	
	@Test
	void testdummyData() {
		
		//https://github.com/DiUS/java-faker
		
		Faker faker = new Faker();
		
		String firstname = faker.name().firstName();
		String lastname =faker.name().lastName();
		String fullname =faker.name().fullName();
		String email =faker.internet().safeEmailAddress();
		String username =faker.name().username();
		String password = faker.internet().password();
		String cellnumber = faker.phoneNumber().cellPhone();
		System.out.println("firstname is "+firstname);
		System.out.println("lastname is "+lastname);
		System.out.println("fullname is "+fullname);
		System.out.println("email is "+email);
		System.out.println("username is "+username);
		System.out.println("password is "+password);
		System.out.println("cellnumber is "+cellnumber);
		
		
		
		
	}
}
