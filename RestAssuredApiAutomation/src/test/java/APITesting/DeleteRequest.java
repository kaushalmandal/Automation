package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	@Test
	public void deleteRequest() {
		RequestSpecification req = RestAssured.given();
		Response response = req.delete("https://reqres.in/api/users/2");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);

	}

}
