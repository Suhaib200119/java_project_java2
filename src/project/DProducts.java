
package project;


public class DProducts extends Products {
   private int height ;
   private int width ;

    public DProducts(int id, String name, String description, int price ,int height ,int width , String typeProduct) {
        super(id, name, description, price, typeProduct);
        this.height=height;
        this.width=width;
    }

   

   
    

   public void setHeight(int height) {
        this.height = height;
    }
  
    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

     @Override
    public String Report_Products(){
        String report="{ "+super.Report_Products()+","+"height: "+this.height+","+"width: "+this.width+" }";
        return report;
    }

    @Override
    public double Total_price() {
        return this.height*this.width*this.getPrice();
    }
   
    
}
