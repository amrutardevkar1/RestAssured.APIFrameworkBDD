package stepDefinations;
import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import paylodBody.AddPlacePayload;
import utils.Utility;
import io.restassured.builder.*;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddPlaceStepDefination extends Utility {
	
	public AddPlacePayload payload = new AddPlacePayload();
	private RequestSpecification res;
	private Response response;
	private JsonPath js;
	public static String place_id;
	

	@Given("User created BaseURI and attach payload")
	public void user_created_base_uri_and_attach_payload() throws FileNotFoundException {
	  
		
	   res = given().spec(RequestSpecs()).filter(RequestLoggingFilter.logRequestTo(log))
				.filter(ResponseLoggingFilter.logResponseTo(log)).body(payload.AddPlacePayloadBody());
	   }
	
	@When("User hits AddPlace resource with POST httprequest")
	public void user_hits_add_place_resource_with_post_httprequest() {
	   response = res.when().post("/maps/api/place/add/json");
		
		
	}
	@Then("User gets response with status code {int}")
	public void user_gets_response_with_status_code(Integer int1) {
	    int actualStatusCode =response.getStatusCode();
	    Assert.assertEquals(actualStatusCode, 200);
	}
	@Then("User gets response with {string} equals to {string}")
	public void user_gets_response_with_equals_to(String status, String expectedstatus) {
	    js = new JsonPath(response.asString());
	   String ActualStatus=  js.get(status).toString();
		Assert.assertEquals(ActualStatus, expectedstatus);
		place_id= js.get("place_id").toString();
		
	}




}
