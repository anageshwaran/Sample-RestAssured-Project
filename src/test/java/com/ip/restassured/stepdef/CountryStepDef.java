package com.ip.restassured.stepdef;

import com.ip.restassured.Country;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CountryStepDef extends Country {
	private  String baseUrl;

	@Given("^The country base url (.*)$")
	public  void the_country_base_url(String base_url) {
		this.baseUrl = base_url;	
		System.out.println(" setting url = " + baseUrl);
	}


	@Given("^Search for the country (.*)$")
	public void search_for_the_country(String requestUrl) {
		String url = baseUrl + requestUrl;
		System.out.println(" re-using url = " + url);
		getRequestTest(url);
	}

	@Then("^Verify the capital of the country$")
	public void verify_the_capital_of_the_country() {
		VerifyGetResponse(response, "Oslo");
	}
}