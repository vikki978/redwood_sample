package actions.TestCases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import java.util.*;

class RestApi{
    public void run(HashMap<String, Object> params){
        
        RestAssured.baseURI = "http://127.0.0.1:2489/";

		// Simple Get
		given().when().get("/employees").then().assertThat().header("Content-Type",
				equalTo("application/json; charset=utf-8"));

		// Post Request
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body("{\"name\": \"Lion\",\"salary\": \"2000\"}")
				.when().post("/employees").then().assertThat().statusCode(201);

		// Simple Get
		given().when().get("/employees").then().assertThat().body("name", hasItem("Lion"));

		//Response after new entry
		Response response = given().when().get("/employees");
		System.out.println("Response\n"+response.body().asString());
		JsonPath jsonPathEvaluator = response.jsonPath();
		ArrayList<Integer> arrayList = (ArrayList<Integer>) jsonPathEvaluator.get("id");
		int size = arrayList.size();
		int last = arrayList.get(size - 1);

		// Delete Request
		given().when().delete("/employees/" + last).then().assertThat().statusCode(200);

		// Put Request
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.body("{\"name\": \"David\",\"salary\": \"5001\"}").when().put("/employees/2").then().assertThat()
				.statusCode(200);
		
		//After Deletion
		response = given().when().get("/employees");
		System.out.println("Response after Deletion\n"+response.body().asString());
    }
}