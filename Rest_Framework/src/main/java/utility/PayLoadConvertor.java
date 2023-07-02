package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayLoadConvertor {
	public static  String generate_Paload(String filename) throws IOException 
	{
		String filepath="C://Users//ramku//Documents//RestAssured//Rest_Framework//src//main//java//resources//"+filename;
		//convert json format in to string format
		return new String(Files.readAllBytes(Paths.get(filepath)));
		
		//since we have made this method a static i can use this method in any of the class within the project
	}

}
