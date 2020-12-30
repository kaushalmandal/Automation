package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherGetRequest {
	@Test
	public void getWeatherRequest() {
		RequestSpecification request = RestAssured.given();
		request.header("x-rapidapi-key", "46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51");
		request.header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com");
		request.header("useQueryString", "true");
		request.param("q", "London");
		request.param("days", "3");
		Response response = request.get("https://weatherapi-com.p.rapidapi.com/forecast.json");
		String responsebody = response.getBody().asString();
		System.out.println("response body is :" + responsebody);
		int statuscode = response.getStatusCode();
		long time=response.getTime();
		Headers allheader=response.headers();
		for(Header head:allheader)
		{
			System.out.println("key:"+head.getName()+"------------"+"value:"+head.getValue());
		}
		System.out.println("time is :"+time);
		System.out.println("status code is :"+statuscode);
		Assert.assertEquals(statuscode, 200);
	}

}
