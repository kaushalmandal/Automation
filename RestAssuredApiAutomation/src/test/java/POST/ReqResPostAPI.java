package POST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ReqResPostAPI 
{
	@Test
	public void reqResPost()
	{
		RequestSpecification req=RestAssured.given();
		JSONObject data=new JSONObject();
		data.put("name","kaushal");
		data.put("job","QA");
		req.header("Content-Type","application/json");
		req.body(data.toJSONString());
		Response response=req.post("https://reqres.in/api/users");
		
		//get Response body
		
		ResponseBody responseBody=response.getBody();
		System.out.println("Response body is :"+responseBody);
		String resBody=responseBody.asString();
		System.out.println("Response in string format is:"+resBody);
		
		//get status code
		
		int statuscode=response.getStatusCode();
		System.out.println("Status code is :"+statuscode);
		
		
		
		
	}

}
