package APITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	@Test
	public void postRequest() {
		RequestSpecification req = RestAssured.given();
		req.head("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("name", "morpheus");
		json.put("job", "leader");
		req.body(json.toJSONString());
		Response response = req.post("https://reqres.in//api/users");
		int code = response.getStatusCode();
		Assert.assertEquals(200, code);
	}

}
