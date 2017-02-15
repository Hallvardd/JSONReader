package test;


import java.util.HashMap;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import org.json.JSONException;
import org.json.JSONML;
import org.json.JSONObject;


public class JSONReader{  
	
	
	
	public String jMap = "{\"course\":{\"code\":\"4100\",\"term\",\"spring\"},\"person\":[{\"name\":\"Hallvard\"},{\"age\":\"23\"}]}";
	
	
	public HashMap toMap(String mapable){
		HashMap<String,Object> h = null;
		BufferedReader br = new BufferedReader(new StringReader(mapable));
	
		
	
		
		return h;
	}
    

	public static void main(String[] args) {
		String jMap = "{\"course\":{\"code\":\"4100\",\"term\",\"spring\"},\"person\":[{\"name\":\"Hallvard\"},{\"age\":\"23\"}]}";
		JSONReader f = new JSONReader();
		f.toMap(jMap);
	}
}