import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestNgTestCase {
	
	
	@BeforeMethod
	public void setUp()
	{
	   System.out.println("inside setup");
       RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	}
	@Test
	public void test1()
	{
		given().when().get("/Hyderabad")
		  .then().assertThat().statusCode(200);
    }
    @Test
	public void test2()
	{
		given().when().get("/Hyderabad")
		  .then().assertThat().statusLine("HTTP/1.1 200 OK");
	}
    @Test
	public void test3()
	{
		given().when().get("/Hyderabad")
		  .then().assertThat().header("Content-Type", equalTo("application/json"));
	}
    @Test
	public void test4()
	{
		given().when().get("/Hyderabad")
		  .then().assertThat().body("City", equalTo("Hyderabad"));
	}
	@AfterMethod
	public void tearDown()
	{
		System.out.println("inside teardown");
	}

}
