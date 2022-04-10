package src.classes;

public abstract class Item {
    public Item(double d, String s){
        this.price = d;
        this.name = s;
    }
    // Every item will have a price.
    private double price;
    
    /**
     * Gets price
     */
    public double GetPrice(){
        return price;
    }
    
    /**
     * Sets price
     */
    public void SetPrice(double d){
        this.price = d;
    }

    // Every item will have a name.
    private String name; 

    /**
     * Gets name
     */
    public String GetName(){
        return this.name;
    }

    public void SetName(String s){
        this.name = s;
    }
}