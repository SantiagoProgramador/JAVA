public class Product {
    //Attributes
    private  int stock;
    private String id;
    private String description;
    
    // Constructors
    public Product(){};
    public Product(int stock, String id, String description) {
        this.stock = stock;
        this.id = id;
        this.description = description;
    }

    //Methods
    public  void addStock(int increment){
        try {
            if (increment <=0) {
                System.out.println("Please type a valid number.");
                return;
            }
            this.stock += increment;
        } catch (Exception e) {
            System.out.println("Please type a valid number.");
        }
            
    }
   
    public  void removeStock(int decrement){
        try {
            if (decrement <=0 || decrement > this.stock) {
                System.out.println("Please type a valid number.");
                return;
            }
            this.stock -= decrement;
        } catch (Exception e) {
            System.out.println("Please type a valid value.");
        }
            
    }
    
    //Setters and getters
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    //ToString
    @Override
    public String toString() {
        return "Product [stock=" + stock + ", id=" + id + ", description=" + description + "]";
    }
}
