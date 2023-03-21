package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONObject;

public class Converter {
//	- Convertir de la moneda de tu país a Dólar
//    - Convertir de la moneda de tu país  a Euros
//    - Convertir de la moneda de tu país  a Libras Esterlinas
//    - Convertir de la moneda de tu país  a Yen Japonés
//    - Convertir de la moneda de tu país  a Won sul-coreano
	
	   private double rateLempira;
	   private double rateJpy;     
	   private double rateEuro;    
	   private double rateGBP;  
	   private double rateKRW;

	private ArrayList<Moneda> monedas = new ArrayList<>();

	public void rateApi(){
    	
    	try 
    	{
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
 		    rateLempira = jsonObject.getJSONObject("rates").getDouble("HNL");
 		    rateJpy     = jsonObject.getJSONObject("rates").getDouble("JPY");
 		    rateEuro    = jsonObject.getJSONObject("rates").getDouble("EUR");
 		    rateGBP    = jsonObject.getJSONObject("rates").getDouble("GBP");
 		    rateKRW   = jsonObject.getJSONObject("rates").getDouble("KRW");
 		   
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

	public Converter() {
		rateApi();

		Moneda moneda0 = new Moneda("USD", 1, 0);
		Moneda moneda1 = new Moneda("HNL", rateLempira, 1);
		Moneda moneda2 = new Moneda("JPY", rateJpy, 2);
		Moneda moneda3 = new Moneda("GBP", rateGBP, 3);
		Moneda moneda4 = new Moneda("EUR", rateEuro, 4);
		monedas.add(moneda0);
		monedas.add(moneda1);
		monedas.add(moneda2);
		monedas.add(moneda3);
		monedas.add(moneda4);
		

	}

	public ArrayList<Moneda> getMonedas() {
		return monedas;
	}

	public void setMonedas(ArrayList<Moneda> monedas) {
		this.monedas = monedas;
	}

	public void greetUser() {
		System.out.println("Welcome to the currency exchange calculator.");
	}

	public String convertAndPrint(int initCoin, double amount, int finalCoin) {
		double dollarAmount = 0;
		double goalCoinAmount = 0;
		double convertionRateToDollar = monedas.get(finalCoin).getValuePerDollar();
		double convertionRateFromDollar = monedas.get(initCoin).getValueFromDollar();
		String goalName = monedas.get(finalCoin).getName();
		String initName = monedas.get(initCoin).getName();
		DecimalFormat df = new DecimalFormat("#,###.##");

		System.out.printf("You want to convert %.2f of %s to %s currency\n.", amount, initName, goalName);

		if (initCoin == 0) {
			dollarAmount = amount;
			goalCoinAmount = dollarAmount * convertionRateToDollar;
			System.out.println("The amount in " + goalName + " is " + goalCoinAmount);
			return df.format(goalCoinAmount);

		} else if (initCoin != 0) {
			dollarAmount = amount * convertionRateFromDollar;
			goalCoinAmount = dollarAmount * convertionRateToDollar;
			System.out.println("The amount in " + goalName + " is " + goalCoinAmount);
			return df.format(goalCoinAmount);
		} else {
			return "Not applicable";
		}

	}// End convertAndPrint

	public void printCoinOptions() {
		int pos = 1; // For internal processing we will use the usual from 0 arraycounter
		// but to display the options to the user we will start from 1.
		for (Moneda moneda : monedas) {
			System.out.println(pos + "." + moneda.getName());
			pos++;
		}
	}

}// End class
