
package project;


public class WProducts extends Products {
    private int weight;

    public WProducts(int id, String name, String description, int price,int weight,String typeProduct) {
        super(id, name, description, price, typeProduct);
        this.weight=weight;
    }

    

    
    
     public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
@Override
    public String Report_Products(){
        String report="{ "+super.Report_Products()+","+"weight: "+this.weight+" }";
        return report;
    }

    @Override
    public double Total_price() {
       return this.weight*this.getPrice();
    }
   
    
  
   
    
}
