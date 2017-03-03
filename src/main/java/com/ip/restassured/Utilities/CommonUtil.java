package com.ip.restassured.Utilities;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;


public class CommonUtil {
	private static String jsonAsString;
	private static Response response;

	public static Response getRequest(String getRequestUrl) {
		System.out.println(getRequestUrl);
		response = given()
				.header("Content-Type", "application/json")
				.when()
				.get(getRequestUrl )
				.then()
				.statusCode(200)
				.contentType(ContentType.JSON).  // check that the content type return from the API is JSON
				extract().response(); // extract the response
		jsonAsString = response.asString();
		System.out.println(jsonAsString);
		return response;
	}


	public static Response postRequest (String bodyParam, String postRequestUrl) {
		System.out.println(postRequestUrl);
		System.out.println(bodyParam);
		response =  given()
				.header("Content-Type", "application/json")
				.body (bodyParam)
				.when ()	   
				.post (postRequestUrl)
				.then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.extract().response(); // extract the response
		jsonAsString = response.asString();
		System.out.println(jsonAsString);
		return response;
	}


	public static Response deleteRequest (String deleteRequestUrl) {
		System.out.println(deleteRequestUrl);
		response =when()
				.delete(deleteRequestUrl)
				.then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.extract().response(); // extract the response
		jsonAsString = response.asString();
		System.out.println(jsonAsString);
		return response;
	}


	public static Response putRequest (String bodyParam, String putRequestUrl) {
		System.out.println("check putRequestUrl = " + putRequestUrl);
		response =  
				given()
				.header("Content-Type", "application/json")
				.body (bodyParam)
				.when()
				.put(putRequestUrl)
				.then()
				.statusCode(200)
				.contentType(ContentType.JSON).  // check that the content type return from the API is JSON
				extract().response(); // extract the response
		jsonAsString = response.asString();
		System.out.println(jsonAsString);
		return response;
	}


	/*	Other examples of Post Request*/

	//	public void postRequest () {
	//		response =  given()
	//				.header("Content-Type", "application/json")
	//				.body ("{\"test_name\": \"test\"}")
	//				.when ()
	//				.post ("http://localhost:8080/create").
	//				then().
	//				contentType(ContentType.JSON).
	//				extract().response(); // extract the response
	//		jsonAsString = response.asString();
	//		System.out.println(jsonAsString);
	//	}


}