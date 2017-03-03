package com.ip.restassured;

import static org.junit.Assert.*;
import com.ip.restassured.Utilities.CommonUtil;
import com.jayway.restassured.response.Response;

public class PetStore {

	public Response response;

	/* Use this method to change the bodyParam as needed and update the postRequestTest and PutRequestTest method accordingly*/
	public String setBodyParam(int id, int categoryId, String categoryName) {
		String bodyParam =String.format("{\"id\": %d,\"category\": { \"id\": %d,\"name\": \"%s\"} }" , id, categoryId,categoryName);
		return bodyParam;
	}

	/* Use this method to change the param as needed and update the deleteRequestTest method accordingly*/
	public String setParam(int id) {
		String param = String.format("%d",id);
		return param;
	}

	public void postRequestTest(String postRequestUrl) {
		String bodyParam = this.setBodyParam(0, 0, "postRequest");
		System.out.println(" sending url = " + postRequestUrl);
		response = CommonUtil.postRequest(bodyParam,postRequestUrl);
		System.out.println(response);
	}

	public void VerifyPostResponse(Response postResponse, String categoryName) {
		String  nameValue = postResponse.path("category.name");
		System.out.println(nameValue);
		assertEquals(nameValue, categoryName);
	}

	public void putRequestTest(String putRequestUrl) {
		String bodyParam = this.setBodyParam(0, 0, "putRequest");
		System.out.println(" sending url = " + putRequestUrl);
		response = CommonUtil.putRequest(bodyParam,putRequestUrl);
		System.out.println(response);
	}

	public void VerifyPutResponse(Response putResponse, String categoryName) {
		String  nameValue = putResponse.path("category.name");
		System.out.println(nameValue);
		assertEquals(nameValue, categoryName);
	}

	public void deleteRequestTest(String requestUrl) {
		String deleteRequestUrl = requestUrl + (String.format("%s", this.setParam(0)));
		response = CommonUtil.deleteRequest(deleteRequestUrl);
	}

}