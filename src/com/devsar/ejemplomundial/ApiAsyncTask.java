package com.devsar.ejemplomundial;

import java.net.URL;
import android.os.AsyncTask;

public class ApiAsyncTask extends AsyncTask<URL, Integer, BaseHttpResult>{
	OnRequestCompleted listener;
	public static String url = "http://worldcup.sfg.io/matches";
	public ApiAsyncTask(OnRequestCompleted listener) {
		 this.listener = listener;
	}
	 
	protected BaseHttpResult doInBackground(URL... urls) {
        return HttpUtils.makeHttpGetRequest(url);
    }

    protected void onProgressUpdate(Integer... progress) {
    }

    protected void onPostExecute(BaseHttpResult result) {
    	if(result != null){
        	if(listener != null){
        		listener.onRequestCompleted(result);
        	}
        }
    }
    
    
    


}
