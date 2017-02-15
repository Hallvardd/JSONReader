package test;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class IDIAPIConnect {



	public String jMap = "{\"course\":{\"code\":\"4100\",\"term\",\"spring\"},\"person\":[{\"name\":\"Hallvard\"},{\"age\":\"23\"}]}";


	public HashMap toMap(BufferedReader br) throws IOException{
		HashMap<String,Object> h = null;
		char c = ' ';
		while((c = (char)br.read()) != '}'){
			System.out.print(c);
			if (c == '{'){
				toMap(br);
			}
			
		}
		
		return h;
	}


	public static void main(String[] args) throws IOException {
		String jMap = "{\"course\":{\"code\":\"4100\",\"term\",\"spring\"},\"person\":[{\"name\":\"Hallvard\"},{\"age\":\"23\"}]}";
		IDIAPIConnect f = new IDIAPIConnect();
		f.toMap(new BufferedReader(new StringReader(jMap)));
	}
}
