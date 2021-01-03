package POST;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class LoginPostApi {
	@Test
	public void loginPostAPI() {
		RequestSpecification request = RestAssured.given();
		JSONObject object = new JSONObject();
		object.put("email", "eve.holt@reqres.in");
		object.put("password", "cityslicka");
		request.header("Content-Type","application/json");
		request.body(object.toJSONString());
		Response response=request.post("https://reqres.in/api/login");
		
		//get Response body
		
		ResponseBody resBody=response.getBody();
		System.out.println("Response body is :"+resBody);
		
		//getting response in string format is
		
		String resBodyString=resBody.asString();
		System.out.println("Response in string format is :"+resBodyString);
		
		//get status code
		
		int statusCode=response.getStatusCode();
		System.out.println("status code is :"+statusCode);
		Assert.assertEquals(200, statusCode);
		
		//get all header
		
		Headers allheader=response.headers();
		for(Header header:allheader)
		{
			System.out.println("key is :"+header.getName()+"---------"+"value is"+header.getValue() );
		}
		
		//get specific header
		
		String specHeader=response.getHeader("Content-Type");
		System.out.println("content type header value of content-type  is :"+specHeader);

	}

}
