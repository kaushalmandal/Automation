package GET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ExtractParticularNode 
{
	@Test
	public void extractParticularNode()
	{
		RequestSpecification request=RestAssured.given();
		request.header("x-rapidapi-key","46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51");
		request.header("x-rapidapi-host","iata-and-icao-codes.p.rapidapi.com");
		request.header("useQueryString",true);
		Response response=request.get("https://iata-and-icao-codes.p.rapidapi.com/airlines");
		ResponseBody body=response.getBody();
		System.out.println("Response is :"+body.asPrettyString());
		
		//get status code
		int statuscode=response.getStatusCode();
		System.out.println("status code is :"+statuscode);
		
		JsonPath jsonpathevaluator=response.jsonPath();
		String[]arr=jsonpathevaluator.get("name");
		System.out.println("array are :"+arr);
	}

}
