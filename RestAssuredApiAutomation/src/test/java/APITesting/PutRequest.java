package APITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	@Test
	public void putRequest() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/Json");
		JSONObject json = new JSONObject();
		json.put("name", "kaushal");
		json.put("job", "QA");
		request.body(json.toJSONString());
		Response response = request.put("https://reqres.in/api/users/2");
		int code = response.getStatusCode();
		System.out.println("response code is " + code);
		Assert.assertEquals(200, code);

	}

}
