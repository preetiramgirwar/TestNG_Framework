package Test_Classes;
import org.testng.annotations.Test;

import Common_API_Methods.API_Method2;
import RequestRepository.Get_Request_Repository;

public class Get_TC1 {
@Test
	public static void extractor() {
	
		int statusCode=API_Method2.ResponseStatusCode(Get_Request_Repository.BaseURI(), Get_Request_Repository.Get_Resource());
		 System.out.println(statusCode);
		 
		 String ResponseBody = API_Method2.ResponseBody(Get_Request_Repository.BaseURI(), Get_Request_Repository.Get_Resource());
		 System.out.println(ResponseBody);
		 
			
	}
}
