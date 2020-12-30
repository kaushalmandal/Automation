package GET;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseBodyContainingSomeString {
	@Test
	public void validateResponseBodyContainSomeString() {
		RequestSpecification request = RestAssured.given();
		request.queryParam("q", "Dhanbad");
		request.header("x-rapidapi-key", "46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51");
		request.header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com");
		request.header("useQueryString", true);
		Response response = request.get("https://weatherapi-com.p.rapidapi.com/current.json");

		// getResponseBody

		ResponseBody body = response.getBody();
		String responseStringbody = body.asString();
		System.out.println("response body is :" + responseStringbody);

		Assert.assertEquals(responseStringbody.contains("Dhanbad"), true);

		// getStatusCode

		int statuscode = response.getStatusCode();
		System.out.println("status code is :" + statuscode);
		Assert.assertEquals(statuscode, 200);

		// get all header

		Headers allheader = response.getHeaders();
		for (Header header : allheader) {
			System.out.println("key :" + header.getName() + "------------" + "value :" + header.getValue());
		}

	}

}
