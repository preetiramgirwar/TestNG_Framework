package Common_API_Methods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class API_Method2 {

	public static int ResponseStatusCode( String BaseURI, String Resource) {
		
		RestAssured.baseURI=BaseURI;
		
		int statusCode=given().header("Content-Type","application/json").
				when().get(Resource).then().extract().statusCode();
		return statusCode;
	}
	
	public static String ResponseBody( String baseURI, String Resource) {
		
		RestAssured.baseURI=baseURI;
		
		String ResponseBody=given().header("Content-Type","application/json").
				when().get(Resource).then().extract().response().asPrettyString();
		return ResponseBody;
	}
}