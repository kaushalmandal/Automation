package GET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ReadResponseBody 
{
	@Test
	public void readResponseBody()
	{
		RequestSpecification request=RestAssured.given();
		Response response=request.get("https://weatherapi-com.p.rapidapi.com/forecast.json");
		request.queryParam("q", "London");
		request.queryParam("days", 3);
		request.header("x-rapidapi-key","46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51");
		request.header("x-rapidapi-host","weatherapi-com.p.rapidapi.com");
		request.header("useQueryString",true);
		ResponseBody body=response.getBody();
		System.out.println("Response is :"+body.asPrettyString());
		
	}

}
