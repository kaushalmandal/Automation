package POST;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class FaceBlurPost 
{
	@Test
	public void faceBlur()
	{
		RequestSpecification request=RestAssured.given();
		request.queryParam("x-rapidapi-key","46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51");
		request.queryParam("x-rapidapi-host","face-blur1.p.rapidapi.com");
		request.queryParam("useQueryString", true);
		Response response=request.post("https://face-blur1.p.rapidapi.com/");
		
		//get Response body
		
		ResponseBody responseBody=response.getBody();
		System.out.println("Response body is :"+responseBody);
		
		//get Status code
		
		int statuscode=response.getStatusCode();
		System.out.println("status code is :"+statuscode);
		Assert.assertEquals(401, statuscode);
		
	}

}
