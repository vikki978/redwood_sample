package actions.TestCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.*;

import java.util.*;

class ApiTesting{
    public void run(HashMap<String, Object> params){
        
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
        assertTrue(responseBody.contains("Hyderabad"));
        
    }
}