package gitHubTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseapiclass.Baseclass;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import resource.pojoclasses.createPojoClass;
import utility.Authentication;
import utility.CommonResponse;
import utility.CreateURL;
import utility.PayLoadConvertor;

public class CreateRepository {
	public static String endpoint=CreateURL.getbaseuri("/user/repos");
	public static String bearer_token=Authentication.getBerarerToken();
	public static Response response;
	public static ObjectMapper objectmapper;
	
	@Test(enabled=false)
	public void createRepository() throws IOException
	{
		String request_payload=PayLoadConvertor.generate_Paload("CreateRepo.json");
		System.out.println(request_payload);
		response=Baseclass.postRequest(endpoint, request_payload, bearer_token);
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		//Assert.assertEquals(CommonResponse.getReponse(request_payload, "name"), CommonResponse.getReponse(responseBody, "name"));
		Assert.assertEquals(CommonResponse.getReponsecode(response), 201);
	}
	@Test
	public void CreateRepoDynamic() throws IOException
	{
		//String request_payload=PayLoadConvertor.generate_Paload("CreateRepo.json");
		//System.out.println(request_payload);
		//i do not have to give it since we will give it dynamically at runtime
		//create object for pojoclass
		createPojoClass createpojo=new createPojoClass();
		createpojo.setName("Testrepo");
		createpojo.setDecsription("This is my test repo");
		//i have to map this at class level
		objectmapper=new ObjectMapper();
		String data=objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(createpojo);
		response=Baseclass.postRequest(endpoint, data, bearer_token);
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(CommonResponse.getReponse(data, "name"), CommonResponse.getReponse(responseBody, "name"));
		Assert.assertEquals(CommonResponse.getReponsecode(response), 201);
	}

}
