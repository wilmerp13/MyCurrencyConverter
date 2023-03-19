package application;

import java.util.ArrayList;

public class Converter {
//	- Convertir de la moneda de tu país a Dólar
//    - Convertir de la moneda de tu país  a Euros
//    - Convertir de la moneda de tu país  a Libras Esterlinas
//    - Convertir de la moneda de tu país  a Yen Japonés
//    - Convertir de la moneda de tu país  a Won sul-coreano

    private ArrayList<Moneda> monedas = new ArrayList<>();

    public Converter() {

        Moneda moneda0 = new Moneda("USD", 1,0);
        Moneda moneda1 = new Moneda("HNL", 24.5,1);
        Moneda moneda2 = new Moneda("JPY", 0.0088,2);
        Moneda moneda3 = new Moneda("GBP", 1.3973,3);
        Moneda moneda4 = new Moneda("EUR", 1.1982,4);
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

	public void greetUser(){
        System.out.println("Welcome to the currency exchange calculator.");
    }
    

    public String convertAndPrint(int initCoin, double amount, int finalCoin) {
        double dollarAmount = 0;
        double goalCoinAmount = 0;
        double convertionRateToDollar= monedas.get(finalCoin).getValuePerDollar();
        double convertionRateFromDollar= monedas.get(initCoin).getValueFromDollar();
        String goalName= monedas.get(finalCoin).getName();
        String initName= monedas.get(initCoin).getName();
        
        System.out.printf("You want to convert %.2f of %s to %s currency\n.",amount,
                            initName,goalName);
        
        if (initCoin == 0) {
            dollarAmount = amount;
            goalCoinAmount = dollarAmount * convertionRateToDollar;
            System.out.println("The amount in " + goalName + " is " + goalCoinAmount);
            return Double.toString(goalCoinAmount);

        } else if (initCoin != 0) {
            dollarAmount = amount * convertionRateFromDollar;
            goalCoinAmount = dollarAmount * convertionRateToDollar;
            System.out.println("The amount in " + goalName + " is " + goalCoinAmount);
            return Double.toString(goalCoinAmount);
        } else {
            return "Not applicable";
        }

    }//End convertAndPrint

public void printCoinOptions() {
        int pos = 1; //For internal processing we will use the usual from 0 arraycounter 
        //but to display the options to the user we will start from 1.
        for (Moneda moneda : monedas) {
            System.out.println(pos + "." + moneda.getName());
            pos++;
        }
    }

}// End class

