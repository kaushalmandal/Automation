package POST;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VehicleCategoryRegistration 
{
	@Test
	public void postAPI()
	{
		RequestSpecification request=RestAssured.given();
		request.queryParam("x-rapidapi-key","46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51");
		request.queryParam("x-rapidapi-host","vehicle-category-recognition.p.rapidapi.com");
		request.queryParam("useQueryString", true);
		Response response=request.post("https://vehicle-category-recognition.p.rapidapi.com/");
		System.out.println("response body is");
		System.out.println(response.getBody());
		System.out.println("get status code");
		int statusCode=response.getStatusCode();
		System.out.println("status code is :"+statusCode);
		Assert.assertEquals(401,statusCode);
	}

}
