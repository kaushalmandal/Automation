package GET;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ReadJSONResponseBody 
{
	@Test
	
	public void readJSONResponseBody()
	{
		RequestSpecification request=RestAssured.given();
		request.queryParam("page",0);
		request.queryParam("per_page",25);
		request.header("x-rapidapi-key","46d1217c5emshffcbdd88f08c29fp1abcb5jsn8a0b82f2fe51");
		request.header("x-rapidapi-host","free-nba.p.rapidapi.com");
		request.header("useQueryString",true);
		Response response=request.get("https://free-nba.p.rapidapi.com/players");
		
		//get Response body
		ResponseBody responsebody=response.getBody();
		System.out.println("response body in json format:"+responsebody.asPrettyString());
		
		//get status code
		
		int statuscode=response.getStatusCode();
		System.out.println("status code is :"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//validate exact node content
		JsonPath jsonpathEvaluator=response.jsonPath();
		String name=jsonpathEvaluator.get("first_name");
		System.out.println("name is :"+name);
	}

}
