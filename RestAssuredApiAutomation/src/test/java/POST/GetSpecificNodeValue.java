package POST;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetSpecificNodeValue 
{
	@Test
	public void getSpecificNode()
	{
		RequestSpecification request=RestAssured.given();
		JSONObject object=new JSONObject();
		object.put("email","eve.holt@reqres.in");
		object.put("password","cityslicka");
		request.body(object.toJSONString());
		Response response=request.post("https://reqres.in/api/login");
		
		//get Response body
		ResponseBody resbody=response.getBody();
		System.out.println("Response body is :"+resbody);
		
		//get Response body in string format
		
		String resBodyStr=response.asString();
		System.out.println("Response body in string format is :"+resBodyStr);
		
		//get status code
		
		int statusCode=response.getStatusCode();
		System.out.println("status code is :"+statusCode);
		Assert.assertEquals(200, statusCode);
		
		//get all headers
		
		Headers allheader=response.headers();
		for(Header header:allheader)
		{
			System.out.println("key is :"+header.getName()+"------------"+"value is:"+header.getValue());
			
		}
		
		
		//get specific header
		
		String headerType=response.header("Content-type");
		System.out.println("value of content-type header is :"+headerType);
		
		//get specificNode
		
		JsonPath jsonpathevaluator=response.jsonPath();
		System.out.println(jsonpathevaluator.get("token"));
		
	}

}
