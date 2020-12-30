package GET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCovidAPI {
	@Test
	public void getCovidAPI() {
		RestAssured.baseURI = "https://covid-19-tracking.p.rapidapi.com/v1";
		RequestSpecification request = RestAssured.given();
		request.header("x-rapidapi-key", "46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51");
		Response response = request.get("/india");
		System.out.println("response is :" + response.asString());
		int responsecode = response.getStatusCode();
		System.out.println("response code is :" + responsecode);
		
		//get all headers
		
		Headers allheader=response.getHeaders();
		for(Header header:allheader)
		{
			System.out.println("keys is "+header.getName()+"--------"+"value is"+header.getValue());
		}
		
		String contenttype=response.header("Content-type");
		System.out.println("content type is :"+contenttype);

	}

}
