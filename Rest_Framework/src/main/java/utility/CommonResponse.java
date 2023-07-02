package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonResponse {
	
	public static JsonPath jsonPath;
	
	public static String getReponse(String responseBody,String responseObject)
	{
		jsonPath=new JsonPath(responseBody);
		String obj_value=jsonPath.get(responseObject);
		return obj_value;
	}
	public static int getReponsecode(Response response)
	{
		int status_code=response.getStatusCode();
		return status_code;
	}
	

}
