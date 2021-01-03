package POST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegisterAPI {
	@Test
	public void registerAPI() {
		RequestSpecification request = RestAssured.given();
		JSONObject data = new JSONObject();
		data.put("email", "kaushal.mandal000@gmail.com");
		data.put("password", "kaushal123");
		request.header("Content-Type", "application/json");
		request.body(data.toJSONString());
		Response response = request.post("https://reqres.in/api/register");
		System.out.println("getting response body :" + response.getBody());
		String responseString = response.asString();
		System.out.println("Response in  string format is :" + responseString);

		// get Response
		System.out.println(response);

		// get status code

		int statuscode = response.getStatusCode();
		System.out.println("status code is :" + statuscode);

	}

}
