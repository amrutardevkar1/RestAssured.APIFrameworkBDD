package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import org.junit.Assert;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import utils.Utility;

public class GetPlaceStepDefination extends Utility {
	private RequestSpecification res;
	private Response response;
	private JsonPath js;
	AddPlaceStepDefination apd = new AddPlaceStepDefination();

	@Given("User configure baseURI with place_ID")
	public void user_configure_base_uri_with_place_id() throws FileNotFoundException {
		res= given().spec(RequestSpecs()).filter(RequestLoggingFilter.logRequestTo(log))
				.filter(ResponseLoggingFilter.logResponseTo(log))
				.queryParam("place_id",AddPlaceStepDefination.place_id );
	    
	}
	@When("User hits GetPlace API with GET httprequest")
	public void user_hits_get_place_api_with_get_httprequest() {
	  
		response = res.when().get("/maps/api/place/get/json");
	}
	@Then("User gets status code as {int}")
	public void user_gets_status_code_as(Integer int1) {
	    Assert.assertEquals(response.getStatusCode(), 200);
	    
	}
	@Then("User gets address in response body as {string}")
	public void user_gets_address_in_response_body_as(String address) {
	   js = new JsonPath(response.asString());
	   Assert.assertEquals(js.get("address"), address);
	}




}
