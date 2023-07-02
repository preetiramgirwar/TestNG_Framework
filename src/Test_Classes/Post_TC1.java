package Test_Classes;
import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.API_Methods;
import Common_API_Methods.Common_Utility_Method;
import RequestRepository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
@Test
	public static void extractor() throws IOException {
		for (int i =0 ; i <5 ; i++) {
			int statusCode = API_Methods.ResponseStatusCode(Post_Req_Repository.baseURI(),Post_Req_Repository.Post_Resource(),
					Post_Req_Repository.Post_TC1());
		   	
		    if(statusCode==201)
		    {
		        System.out.println(statusCode);
		        
			    String ResponseBody = API_Methods.ResponseBody(Post_Req_Repository.baseURI(), Post_Req_Repository.Post_Resource(), 
			    		Post_Req_Repository.Post_TC1());
				System.out.println( "Response Body: \n"+ResponseBody);
				
				String RequestBody = Post_Req_Repository.Post_TC1();
			    Common_Utility_Method.EvidenceCreator("Post TC1", RequestBody, ResponseBody, statusCode);
				
			    validator(RequestBody, ResponseBody);
			    break;
		    }
		    else
		    {
		    	System.out.println("Incorrect StatusCode");
		    }
	      }
		}
	
     public static void validator (String RequestBody , String ResponseBody) {
    	 JsonPath JspRequest = new JsonPath(RequestBody);
         String Req_name = JspRequest.getString("name");
         String Req_job = JspRequest.getString("job");
         String Req_salary = JspRequest.getString("salary");
         String Req_city = JspRequest.getString("city");
         LocalDateTime currentdate = LocalDateTime.now();
         String expecteddate = currentdate.toString().substring(0,10);
         
         JsonPath JspResponse = new JsonPath(ResponseBody);
         String Res_name = JspResponse.getString("name");
         String Res_job = JspResponse.getString("job"); 
         String Res_salary = JspResponse.getString("salary"); 
         String Res_city = JspResponse.getString("city"); 
         String Res_id = JspResponse.getString("id");
         String Res_createdAt  = JspResponse.getString("createdAt ");
         Res_createdAt  = Res_createdAt.substring(0,10);
                  
         Assert.assertEquals(Res_name, Req_name);
         Assert.assertEquals(Res_job,Req_job);
         Assert.assertEquals(Res_salary,Req_salary);
         Assert.assertEquals(Res_city,Req_city);
         Assert.assertNotEquals(Res_id,0);
         Assert.assertNotEquals(Res_id,null);
         Assert.assertEquals(Res_createdAt, expecteddate);
     }
   }
	
	
