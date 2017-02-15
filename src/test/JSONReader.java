package test;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

import org.json.JSONException;
import org.json.JSONML;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


public class JSONReader{  

		public String getJSON(String url, int timeout) {
		    HttpURLConnection c = null;
		    try {
		        URL u = new URL(url);
		        c = (HttpURLConnection) u.openConnection();
		        c.setRequestMethod("GET");
		        c.setRequestProperty("Content-length", "0");
		        c.setUseCaches(false);
		        c.setAllowUserInteraction(false);
		        c.setConnectTimeout(timeout);
		        c.setReadTimeout(timeout);
		        c.connect();
		        int status = c.getResponseCode();
		        switch (status) {
		            case 200:
		            case 201:
		                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
		                StringBuilder sb = new StringBuilder();
		                String line;
		                
		                while ((line = br.readLine()) != null ) {
		                    sb.append(line);
		                }
		                br.close();
		                return sb.toString();
		        }
		
		    } catch (MalformedURLException ex) {
		        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		    } catch (IOException ex) {
		        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		    } finally {
		       if (c != null) {
		          try {
		              c.disconnect();
		          } catch (Exception ex) {
		             Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		          }
		       }
		    }
		    return null;
		}
		
		public Map jsonToMap(String t){
			Map<String, Object> retMap = new Gson().fromJson(t, new TypeToken<HashMap<String, Object>>() {}.getType());
			return retMap;
	    }
		
		public static void main(String[] args) {
			JSONReader a = new JSONReader();
			Scanner uIn = new Scanner(System.in);
			String input = uIn.next();
			uIn.close();
			String subjectInfo = (a.getJSON("http://www.ime.ntnu.no/api/course/en/" + input, 1000));
			Map map = a.jsonToMap(subjectInfo);
			Map course = (Map) (map.get("course"));
			System.out.println(course.get("name"));
			

		}
}