package InventorySystem;

public class SpecificProduct extends Product{
    //Attributes
    private String category;
    private String brand;
    //Constructors
    public  SpecificProduct(){};

    public SpecificProduct(String category, String brand) {
        this.category = category;
        this.brand = brand;
    }

    public SpecificProduct(int id, String name, double price, String category, String brand) {
        super(id, name, price);
        this.category = category;
        this.brand = brand;
    }

    //Methods

    //Setters and getters

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    //ToString

    @Override
    public String toString() {
        return "SpecificProduct{" +
                "category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
