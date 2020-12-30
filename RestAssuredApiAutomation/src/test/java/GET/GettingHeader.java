package GET;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GettingHeader {
	@Test
	public void getAllHeadersValue()
	{
		RequestSpecification request=RestAssured.given();
		request.queryParam("q","Dhanbad");
		request.header("x-rapidapi-key","46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51");
		request.header("x-rapidapi-host","weatherapi-com.p.rapidapi.com");
		request.header("useQueryString","true");
		Response response=request.get("https://weatherapi-com.p.rapidapi.com/timezone.json");
		System.out.println("Response is :"+response.asPrettyString());
		
		//get status code
		
		int statuscode=response.getStatusCode();
		System.out.println("Status code is :"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//get All headers
		
		Headers allheader=response.getHeaders();
		for(Header header:allheader)
		{
			System.out.println("key is "+header.getName()+"------------"+"value is"+header.getValue());
		}
		
		String contenttype=response.header("application-json");
		System.out.println("contenttype is :"+contenttype);
		
		
		String server=response.header("Server");
		System.out.println("server value is :"+server);
		
	}

}
