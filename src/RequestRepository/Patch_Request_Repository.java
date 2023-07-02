package RequestRepository;

public class Patch_Request_Repository {

	public static String BaseURI() {
		String baseURI="https://reqres.in/";
		return baseURI;
	}
	
	public static String Patch_Resource() {
		String patch_Resource="api/users/2";
		return patch_Resource;
	}
	
	public static String Patch_Request_TC1() {
		String RequestBody="{\r\n"
				+ "    \"name\": \"Bhoomi\",\r\n"
				+ "    \"job\": \"HR Manager\"\r\n"
				+ "}";
		return RequestBody;
	}

}