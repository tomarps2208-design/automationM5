package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonPlaceHolder 
{
	@Test
	public  void getAllPost()
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
			given()
        .when()
            .get("https://jsonplaceholder.typicode.com/posts")
        .then()
            .statusCode(200);
	}
	
	@Test
	public void postMethodTest() throws IOException
	{
		//body
		Map<String, Object> body = new HashMap<>();
		body.put("clientId", "19g2hp078gmje0d8auk947fetg");
		body.put("clientSecret", "1kaqcrq46mtjclh6dllm1261r1j8e2ec76fa0eqmf2a00itqquih");
		//nested structure 
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("request", body);
		RestAssured.baseURI = "https://mproapiuat1.maxlifeinsurance.com/uat-mpro-oauth";
		//-------------generate Token API---------------
		 Response response = given()
		 	.baseUri("https://mproapiuat1.maxlifeinsurance.com")
		 	 .header("Content-Type", "application/json")
			 .header("x-api-key", "FGmoKPQYUw42pmJv7zkyE8kqBm8H35XjLa0QDRka")
			 .body(requestBody)
	     .when()
	          .post("/uat-mpro-oauth");
		 	//System.out.println(response.getBody().asString());
	        String token = response.jsonPath().getString("response.token");
	        //System.out.println(token);
	        String respBody = new String(Files.readAllBytes(Paths.get("src/test/resources/requestBody.json")));
	        //-----POSV Skip API------------
	        Response fResponse = given()
	        	.baseUri("https://mproapiuat1.maxlifeinsurance.com")
	        	.header("Content-Type", "application/json")
	        	.header("Authorization", "Bearer " + token)
	        	.header("x-api-key", "FGmoKPQYUw42pmJv7zkyE8kqBm8H35XjLa0QDRka")
	        	.header("api_client_secret", "Y4FAMepV4WIYeOO76whSWpe6e3PFihvFwq94zmk6C07Fq4DI1howwHeN")
	        	.body(respBody)
	        .when()
	        	.post("/updateAutoPosvBackflowDetails");
	        System.out.println("Response Status Code of API : " + fResponse.statusCode());
	        Response message = given()
		        	.baseUri("https://mproapiuat1.maxlifeinsurance.com")
		        	.header("Content-Type", "application/json")
		        	.header("Authorization", "Bearer " + token)
		        	.header("x-api-key", "FGmoKPQYUw42pmJv7zkyE8kqBm8H35XjLa0QDRka")
		        	.header("api_client_secret", "Y4FAMepV4WIYeOO76whSWpe6e3PFihvFwq94zmk6C07Fq4DI1howwHeN")
		        	.body(respBody)
		        .when()
		        	.post("/updateAutoPosvBackflowDetails")
		        	.then()
		        	.extract().response();
	        message.prettyPrint();
	       // List<String> messages = message.jsonPath().getList("response.responseData.responsePayload.message");
	       // for(String msg : messages){
	          //  System.out.println("Message: " + msg);
	//}
	}
}
