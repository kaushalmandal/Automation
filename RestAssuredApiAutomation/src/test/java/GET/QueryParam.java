package GET;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParam {
	@Test
	public void queryParam() {
		RequestSpecification request = RestAssured.given();
		request.queryParam("q", "Dhanbad");
		request.header("x-rapidapi-key", "46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51");
		request.header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com");
		request.header("useQueryString", "true");
		Response response = request.get("https://weatherapi-com.p.rapidapi.com/current.json");

		// get response body

		ResponseBody body = response.getBody();
		String bodyAsString = body.asString();
		System.out.println("body in string format :" + bodyAsString);

		// getStatus code

		int statuscode = response.getStatusCode();
		System.out.println("Status code is :" + statuscode);
		Assert.assertEquals(statuscode, 200);

		// get all header

		Headers allheader = response.getHeaders();
		for (Header header : allheader) {
			System.out.println("key :" + header.getName() + "----------" + "value :" + header.getValue());

		}

	}

}
