package framework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.NoSuchElementException;





public class RepositoryUtil {

	
	public static void main(String[] args) throws IOException, ParseException {
		
		String firstname=getting_data_from_Json("firstname");
		System.out.println(firstname);

			
		}
		
		public static String getting_data_from_Json(String firstname) {
			JSONParser jsonParser = new JSONParser();
			
			FileReader reader;
			Object obj;
			String json = null;
			try {
				reader = new FileReader(".\\ConfigFile\\Objectrepo.json");
				obj = jsonParser.parse(reader);
				JSONObject jsb=(JSONObject) obj;
				 json=(String)jsb.get(firstname);
			} catch (IOException | ParseException e) {
			}
			return json;
			
						
			
		}
					
		
		
		
	/*	JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader(".\\ConfigFile\\Objectrepo.json");
			Object obj = jsonParser.parse(reader);//Read JSON file
			JSONArray usersList = (JSONArray) obj;
			System.out.println("Users List-> "+usersList); //This prints the entire json file
			
			for(int i=0;i<usersList.size();i++) 
			{
			JSONObject users = (JSONObject) usersList.get(i);
			System.out.println("Users -> "+users);//This prints every block - one json object
			JSONObject user = (JSONObject) users.get("users");
			System.out.println("User -> "+user); //This prints each data in the block
			String username = (String) user.get("username");
			String password = (String) user.get("password");
			System.out.println("The username in JSON is: "+username);
			  System.out.println("The password in JSON is: "+password);
			}
			
			
			
		} catch ( IOException | ParseException e) {
			
		}

		*/
		
		
}		
		
		
		
	
	
	
	
	
	

