package postApp;
import java.io.*; 
import java.util.*;  
import java.net.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
  
public class DistanceBetweenAddresses {
	
	
	public static ArrayList<String> origins = new ArrayList<String>();
	public static ArrayList<String> destinations = new ArrayList<String>();
	public static ArrayList<Long> distances[]; 
	
	
	
    public DistanceBetweenAddresses() throws Exception  { 
    	
    	//gets the JSON string
    	String jsonString = jsonGetRequest(generateURL());
    	//extracts the information from the JSON string
    	parseJson(jsonString);
    
    	for(int i =0;i<distances.length;i++) {
    		System.out.println(distances[i].toString());
    	}
    	
    }
    
    

	private static String generateURL() {
    	//url address
    	String url = "https://maps.googleapis.com/maps/api/distancematrix/json?";
    	
    	//adds users's address (there is only one).
    	url+="origins=";
    	url+=String.format("%s+%s+%s+%s+%s", Initialize.user.getStreetNumber().replace(' ','+'),Initialize.user.getStreetName().replace(' ','+'),
    										  Initialize.user.getCity().replace(' ','+'),Initialize.user.getProvince().replace(' ','+'),
    										  Initialize.user.getCountry().replace(' ','+'));
    	//add the names of the available universities
    	url+="&destinations=";
    	url+=Initialize.universityList[0].replace(' ','+');
    	for(int i =1;i<Initialize.universityList.length;i++) {
    		url+="|"+Initialize.universityList[i].replace(' ','+');
    	}
    	//optional parameters (most are default anways though)
    	url+="&avoid=tolls";
    	url+="&units=metric";
    	url+="&mode=driving";
    	//add key
    	url+="&key=";
    	url+=Initialize.googleAPIKey;
    	System.out.println(url);
    	return url;
    	
    }
    
    	
	private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
	}
	
	public static String jsonGetRequest(String urlQueryString) {
		String json = null;
		try {
			URL url = new URL(urlQueryString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();
			InputStream inStream = connection.getInputStream();
			json = streamToString(inStream); // input stream to string
     
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return json;
	}
  
	
	public static void parseJson(String jsonString) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(jsonString);//convert the JSON string to a JSON object
	  
		//find out all the starting addresses (can be used to double check)
		JSONArray jsonOrigins = (JSONArray) jsonObject.get("origin_addresses");
		for(int i =0;i<jsonOrigins.size();i++)
			origins.add((String)jsonOrigins.get(i));
		
		//find out all the destination addresses  (can be used to double check)
		JSONArray jsonDestinations = (JSONArray) jsonObject.get("destination_addresses");
		for(int i =0;i<jsonDestinations.size();i++)
			destinations.add((String)jsonDestinations.get(i));
		
		
		JSONArray jsonRows = (JSONArray) jsonObject.get("rows");
		distances = new ArrayList[jsonRows.size()];
		for(int i =0;i<jsonRows.size();i++)distances[i]=new ArrayList<Long>();
	  
		//loop through starting point (there's most likely only one) 
		for(int i =0;i<jsonRows.size();i++) {
			JSONObject row = (JSONObject) jsonRows.get(i);
			JSONArray jsonElements = (JSONArray) row.get("elements");
			//loop through each university from said starting point
			for(int j =0;j<jsonElements.size();j++) {
				JSONObject element = (JSONObject) jsonElements.get(j);
				JSONObject jsonValue = (JSONObject) element.get("distance");
				distances[i].add((Long) jsonValue.get("value"));
			}    		      
		}
	  
	}
	
	//this method narrows down the number of schools to consider recommending
	private ArrayList<String> recommendedSchoolsByDistance(int percent) {
    	//loops through the distances data (since there's only one address
		//the outer for loop technically does not need to exist).
		for(int i =0;i<distances.length;i++) {
			
			//finds the farthest school
			long max =0;
    		for(int j =0;j<distances[i].size();j++)
    			max= Math.max(max, distances[i].get(j));
    	
			max+=10000; //adds an additional 10 km to the max distance.
			max=(max*percent)/100; //the percent is equal to how willing the user
			//is to live far from home. 100 would mean they are willing to go anywhere
			
			//narrows down the recommended universities to those whose distance is shorter than max
			ArrayList<String> tmp = new ArrayList<String>();
			
			for(int j =0;j<distances[i].size();j++)
				if(distances[i].get(j)<max)	
					tmp.add(destinations.get(i));
		
			return tmp;
    		
    	}
    	//this won't run but makes sure there isn't an error.
    	ArrayList<String> tmp = new ArrayList<String>();
    	return tmp;
		
	}
      
}