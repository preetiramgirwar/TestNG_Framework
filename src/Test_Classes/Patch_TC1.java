package Test_Classes;
import Common_API_Methods.API_Method1;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import io.restassured.path.json.JsonPath;
import RequestRepository.Patch_Request_Repository;

public class Patch_TC1 {
@Test
	public static void extractor() {
	
		int statusCode=API_Method1.ResponseStatusCode(Patch_Request_Repository.BaseURI(), Patch_Request_Repository.Patch_Resource(), Patch_Request_Repository.Patch_Request_TC1());
		 System.out.println(statusCode);		 
		 		 
		 String RequestBodi = API_Method1.RequestBody(Patch_Request_Repository.BaseURI(), Patch_Request_Repository.Patch_Resource(), Patch_Request_Repository.Patch_Request_TC1());
		 System.out.println(RequestBodi);
		 
		 String ResponseBody = API_Method1.ResponseBody(Patch_Request_Repository.BaseURI(), Patch_Request_Repository.Patch_Resource(), Patch_Request_Repository.Patch_Request_TC1());
		 System.out.println(ResponseBody);
		 
		 	JsonPath JspRequest= new JsonPath(RequestBodi);
			String Req_name=JspRequest.getString("name");
			String Req_job=JspRequest.getString("job");
		 
			JsonPath JspResponse= new JsonPath(ResponseBody);
			String Res_name=JspResponse.getString("name");
			String Res_job=JspResponse.getString("job");
			LocalDateTime currentdate = LocalDateTime.now();
			String expecteddate = currentdate.toString().substring(0,11);
			String Res_updatedAt=JspResponse.getString("updatedAt");
			Res_updatedAt = Res_updatedAt.substring(0,11);
			
			Assert.assertEquals(Res_name, Req_name);
			Assert.assertEquals(Res_job, Req_job);
			Assert.assertEquals(Res_updatedAt, expecteddate);
	}
}
