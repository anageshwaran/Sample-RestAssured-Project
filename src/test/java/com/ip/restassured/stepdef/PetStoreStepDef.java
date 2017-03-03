package com.ip.restassured.stepdef;

import com.ip.restassured.PetStore;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PetStoreStepDef extends PetStore {

	private  String baseUrl;

	@Given("^The petstore url (.*)$")
	public  void the_petstore_base_url(String base_url) {
		this.baseUrl = base_url;	
		System.out.println(" setting url = " + baseUrl);
	}

	@Given("^Add a new pet to the store (.*)$")
	public void add_a_new_pet_to_the_store(String requestUrl) {
		String url = baseUrl + requestUrl;
		System.out.println(" re-using url = " + url);
		postRequestTest(url);
	}

	@Then("^Verify the pet added to the store$") 
	public void verify_the_pet_added_to_the_store() {
		VerifyPostResponse(response, "postRequest");
	}

	@When("^Update the name of the pet in the store (.*)$") 
	public void update_the_name_of_the_pet_in_the_store(String requestUrl) {
		String url = baseUrl + requestUrl;
		putRequestTest(url);
	}

	@Then("^Verify the pet name updated successfully$")
	public void verify_the_pet_name_updated_successfully() {
		VerifyPostResponse(response, "putRequest");
	}

}
