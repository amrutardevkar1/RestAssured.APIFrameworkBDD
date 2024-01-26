package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import paylodBody.MultiTestDataPayload;
import utils.Utility;


public class MultiTestDataAddPlace<multiTestdataBody> extends Utility{
	
	private RequestSpecification res;
	private Response response;
	private MultiTestDataPayload body = new MultiTestDataPayload();
	private JsonPath js; 
	private String place_id;
	
	
	@Given("User creates request wity baseUri and attach payload with {string}, {string}, {string}")
	public void user_creates_request_wity_base_uri_and_attach_payload_with(String name, String address, String language) throws FileNotFoundException {
	   
		res= given().spec(RequestSpecs()).filter(RequestLoggingFilter.logRequestTo(log))
				.filter(ResponseLoggingFilter.logResponseTo(log))
				.body(body.multiTestdataBody(name, address, language));
		
	}

	@When("User hits addPlce resource with PUT http request")
	public void user_hits_add_plce_resource_with_put_http_request() {
	   response= res.when().post("/maps/api/place/add/json");
	}

	@Then("User gets response status code as {int}")
	public void user_gets_response_status_code_as(Integer int1) {
	    Assert.assertEquals(response.getStatusCode(), 200);
	}

		
	@Then("User gets {string} in response body equals to {string}")
	public void user_gets_in_response_body_equals_to(String status, String expected) {
		js = new JsonPath(response.asString());
		place_id=js.get("place_id");
		Assert.assertEquals(js.get(status), expected);
	}
	@Then("Verify place created with {string}")
	public void verify_place_created_with(String name) {
		 RequestSpecification  re = given().spec(req).filter(RequestLoggingFilter.logRequestTo(log))
		    		.filter(ResponseLoggingFilter.logResponseTo(log))
		    		.queryParam("place_id",place_id);
		    
		    Response response = re.when().get("/maps/api/place/get/json");
		    JsonPath js = new JsonPath(response.asString());
		    Assert.assertEquals(js.get("name"),name);
		    
	}














}
