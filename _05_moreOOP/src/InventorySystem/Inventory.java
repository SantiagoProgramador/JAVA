package InventorySystem;

import java.util.ArrayList;

public class Inventory {
    //Attributes
    private ArrayList<Product> Products = new ArrayList<>();
    //Constructors
    public Inventory(){
        this.Products = new ArrayList<>();
    }
    //Methods
    public void addProduct(Product product){
        this.Products.add(product);
    }
    public boolean removeProduct(int id){
        return this.Products.removeIf(product -> product.getId() == id);
    }

    public void showProducts(){
        for (Product product : this.Products){
            System.out.println("Available products: "+ product.getId() + " " + product.getName() + " Price: " + product.getPrice());
        }
    }

    public Product filtrateProductsbyName(String name){
        for (Product product : this.Products){
            if (product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;
    }

    //Setters and getters

    public ArrayList<Product> getProducts() {
        return Products;
    }

    //ToString
}
