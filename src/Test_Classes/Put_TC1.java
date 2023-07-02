package Test_Classes;
import Common_API_Methods.API_Method;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import io.restassured.path.json.JsonPath;
import RequestRepository.Put_Request_Repository;

public class Put_TC1 {
@Test
	public static void extractor() {
    	
		for (int i = 1; i <= 5; i++) {	
			
        	 int statusCode=API_Method.ResponseStatusCode(Put_Request_Repository.BaseURI(), Put_Request_Repository.Put_Resource(),Put_Request_Repository.Put_Req_TC1());
	       		
			if ( statusCode == 200 ) {
				System.out.println("Status Code: "+ statusCode);
				String ResponseBody = API_Method.ResponseBody(Put_Request_Repository.BaseURI(),Put_Request_Repository.Put_Resource(), Put_Request_Repository.Put_Req_TC1());
				String RequestBody = API_Method.ResponseBody(Put_Request_Repository.BaseURI(),Put_Request_Repository.Put_Resource(),Put_Request_Repository.Put_Req_TC1());
   		    System.out.println("ResponseBody \n" + ResponseBody);
   		    validator(RequestBody,ResponseBody);   		    	
       		break;
       		 
           } else {
               System.out.println(i+ "Incorrect status code received :" + statusCode);
           }
        }
    }
	
	public static void validator (String Response, String Request) {
		JsonPath JspRequest = new JsonPath(Request);
		String Req_name = JspRequest.getString("name");
		String Req_job = JspRequest.getString("job");
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0,11);
		
		JsonPath JspResponse= new JsonPath(Response);
		String Res_name=JspResponse.getString("name");
		String Res_job=JspResponse.getString("job");
		String Res_updatedAt=JspResponse.getString("updatedAt");
		Res_updatedAt=Res_updatedAt.substring(0,11);
		
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_job, Req_job);
		Assert.assertEquals(Res_updatedAt, expecteddate);
		
	}
}
