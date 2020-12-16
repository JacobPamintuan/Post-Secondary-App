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
	private static String key = "AIzaSyB_yQfDw3ers-hQDc43gsaK-ssvfCwzVho";
	
	
	
    public DistanceBetweenAddresses() throws Exception  { 
    	
    	String jsonString = jsonGetRequest(generateURL());
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
//    	url+=String.format("%s+%s+%s+%s+%s", Initialize.user.getStreetNumber().replace(' ','+'),Initialize.user.getStreetName().replace(' ','+'),
//    										  Initialize.user.getCity().replace(' ','+'),Initialize.user.getProvince().replace(' ','+'),
//    										  Initialize.user.getCountry().replace(' ','+'));
    	//add the names of the available universities
    	url+="&destinations=";
    	url+=Initialize.universityList.get(0).replace(' ','+');
    	for(int i =1;i<Initialize.universityList.size()-1;i++) {
    		url+="|"+Initialize.universityList.get(i).replace(' ','+');
    	}
    	//optional parameters (most are default anways though)
    	url+="&avoid=tolls";
    	url+="&units=metric";
    	url+="&mode=driving";
    	//add key
    	url+="&key=";
    	url+=key;
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
      
}