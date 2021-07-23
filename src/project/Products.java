package project;

public abstract class Products  {

    private int id;
    private String name;
    private String description;
    private int price;
    private String typeProduct;
  

    public Products(int id, String name, String description, int price, String typeProduct) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.typeProduct = typeProduct;
       
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

   

    public String Report_Products() {
        String report = "id: "+this.id+","+" name: "+this.name+"," +" description: "+this.description+"," +" price: "+this.price;
        return report;
    }

    public abstract double Total_price();

  
}
