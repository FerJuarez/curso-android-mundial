package com.devsar.ejemplomundial;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

public class HttpUtils {
	private static int STATUS_CODE_OK_POST = 200;
	private static int STATUS_CODE_OK_GET = 201;
	private static int STATUS_CODE_ERROR_AUTH = 401;
	private static int STATUS_CODE_ERROR = 500;
	
	
	public static boolean isStatusCodeOK(HttpResponse response){
		return (statusCode(response) == STATUS_CODE_OK_POST || statusCode(response) == STATUS_CODE_OK_GET );
	}
	
	private static int statusCode(HttpResponse response){
		return response.getStatusLine().getStatusCode();
	}

	
	
public static BaseHttpResult makeHttpGetRequest(String path){
		
		HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet();
		try {
			
	        request.setHeader("Content-type", "application/json");
	        request.setURI(new URI(path));
	        HttpResponse response = client.execute(request);
	        
	        List<Match> matchs = null;
			
	        if(isStatusCodeOK(response)){
	        	String jsonString = EntityUtils.toString(response.getEntity());
				JSONArray jsonResult = new JSONArray(jsonString);
				try {
					return new BaseHttpResult(true, "Success message", Match.dehydrateMatchs(jsonResult)); 
				} catch (Exception e) {
					// TODO: handle exception
					return new BaseHttpResult(true, "Error message", new ArrayList<Match>()); 
				}
				
		        
	        } else {
	            return new BaseHttpResult(false, "Error message", matchs); 
	    	    
	        }
	 
        } catch (Exception e) {
            return null;
        }
}


}
