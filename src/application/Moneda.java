package application;

public class Moneda {

    private String name;
    private int id;
    public int getId() {
		return id;
	}

	private double valuePerDollar;
    private double valueFromDollar;
    
    public Moneda(String name,double valuePerDollar,int id){
        this.name = name;
        this.valuePerDollar=valuePerDollar;
        this.valueFromDollar=1/valuePerDollar;
        this.id=id;
        
    }

    public String getName() {
        return name;
    }

    public double getValuePerDollar() {
        return valuePerDollar;
    }

    public double getValueFromDollar() {
        return valueFromDollar;
    }
    
    @Override
    public String toString() {
 	return this.name;
 	   
    }
    
    

}// End class