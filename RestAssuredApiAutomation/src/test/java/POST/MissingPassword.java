package POST;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class MissingPassword 
{
	@Test
	public void missingPassword()
	{
		RequestSpecification request=RestAssured.given();
		JSONObject object=new JSONObject();
		object.put("email", "sydney@fife");
		request.header("Content-Type", "application/json");
		request.body(object.toJSONString());
		Response response=request.post("https://reqres.in/api/register");
		
		//get Response body
		
		ResponseBody responseBody=response.getBody();
		System.out.println("Response body is :"+responseBody);
		
		//Response in string format
		String responseString=responseBody.asString();
		System.out.println("Response in string format is :"+responseString);
		
		//get Status code
		
		int statusCode=response.getStatusCode();
		System.out.println("status code is :"+statusCode);
		Assert.assertEquals(400, statusCode);
	}

}
