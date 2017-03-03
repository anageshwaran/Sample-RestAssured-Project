package com.ip.restassured;

import static org.junit.Assert.*;
import java.util.List;
import com.ip.restassured.Utilities.CommonUtil;
import com.jayway.restassured.response.Response;

public class Country {
	public Response response;

	public String setParam(String country) {
		String param = String.format("%s",country);
		return param;
	}

	public void getRequestTest(String requestUrl) {
		String getRequestUrl = requestUrl + (String.format("/%s", this.setParam("name/norway")));
		response = CommonUtil.getRequest(getRequestUrl);
		System.out.println(response);	
	}

	public void VerifyGetResponse(Response getResponse, String actualCapital) {
		List <String>  capitalPaths = getResponse.path("capital");
		for (String capitalPath : capitalPaths)
		{
			assertEquals(capitalPath, actualCapital);
		}
	}

}