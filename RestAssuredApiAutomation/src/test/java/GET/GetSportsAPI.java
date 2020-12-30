package GET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetSportsAPI {
	@Test
	public void getSportsAPI() {
		RequestSpecification request = RestAssured.given();
		Response response = request.get("https://weatherapi-com.p.rapidapi.com/sports.json");
		request.queryParam("q", "London");
		request.header("x-rapidapi-key", "46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51")
				.header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com").header("useQueryString", "true");
		ResponseBody body = response.getBody();
		String bodyAsString = body.asString();
		System.out.println("response body is :" + bodyAsString);

		// get status code

		int statuscode = response.getStatusCode();
		System.out.println("status code is :" + statuscode);

		// get all headers

		Headers allheader = response.getHeaders();
		for (Header header : allheader) {
			System.out.println("key :" + header.getName() + "-----------" + "value :" + header.getValue());
		}

	}

}
