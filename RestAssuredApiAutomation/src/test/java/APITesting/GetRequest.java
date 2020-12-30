package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void getWeatherDetails() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httpReq = RestAssured.given();
		Response response = httpReq.request(Method.GET);
		String responsebody = response.getBody().asString();
		System.out.println("Response is :" + responsebody);
		int statuscode = response.getStatusCode();
		System.out.println("status code is :"+statuscode);
		

	}

}
