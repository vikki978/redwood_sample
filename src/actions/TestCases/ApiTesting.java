package actions.TestCases;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

class ApiTesting{
    public void run(HashMap<String, Object> params){
        
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		 given().when().get("/Hyderabad")
		  .then().assertThat().body("City", equalTo("Hyderabad"));
        
    }
}