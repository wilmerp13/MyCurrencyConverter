
/*package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ApiInput {

	public static void main(String[] args) throws IOException {

    	try{
    		   String apikey = "8KdblsFQwTLFbksETCyKp0d29kPHpmVW";
    		    String symbols = "HNL,JPY,EUR,GBP,KRW";
    		    String base = "USD";
    		    String url = "https://api.apilayer.com/exchangerates_data/latest?symbols=" + symbols + "&base=" + base;

    		    URL obj = new URL(url);
    		    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    		    con.setRequestMethod("GET");
    		    con.setRequestProperty("apikey", apikey);

    		    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    		    String inputLine;
    		    StringBuffer response = new StringBuffer();
    		    while ((inputLine = in.readLine()) != null) {
    		      response.append(inputLine);
    		    }
    		    in.close();
    		    
    		    //StringBuffer to JSON.
    		    String jsonString = response.toString();
    		    JSONObject jsonObject = new JSONObject(jsonString);
    		    System.out.println(jsonObject);
    		  
    		    //Getting values through keys on JSON objects.
    		    double rateLempira = jsonObject.getJSONObject("rates").getDouble("HNL");
    		    double rateJpy     = jsonObject.getJSONObject("rates").getDouble("JPY");
    		    double rateEuro    = jsonObject.getJSONObject("rates").getDouble("EUR");
    		    double rateGBP    = jsonObject.getJSONObject("rates").getDouble("GBP");
    		    double rateKRW   = jsonObject.getJSONObject("rates").getDouble("KRW");
    		   
    		    //Printing double values in the console
    		    System.out.println(rateLempira);
    		    System.out.println(rateJpy);
    		    System.out.println(rateEuro);
    		    System.out.println(rateGBP);
    		    System.out.println(rateKRW);
    		    
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("here catch");
    		
    	}
	}

}
*/