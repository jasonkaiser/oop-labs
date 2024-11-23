package org.example;


import java.util.ArrayList;
import java.util.List;

public class DiscountEngine {
    public static void main(String[] args) {

            // Percentage Discount
            DiscountStrategy percentageDiscount = (double price, int quantity) -> (price * quantity) / 100;
            System.out.println(percentageDiscount.applyDiscount(200.0, 20));

            // Fixed Discount
            DiscountStrategy fixedDiscount = (double price, int quantity) -> price - quantity;

            // Bulk Discount
            DiscountStrategy bulkDiscount = (double price, int quantity) -> {
             if(quantity > 100){
                 return price * 0.5; // 50% discount
             }
                return price;
            };

            // Products
            List<Product> products = new ArrayList<>();
            Product test_product0 = new Product("Nerf Gun", 200.0, 40);
            Product test_product1 = new Product("Hot Wheels", 120.0, 60);
            Product test_product2 = new Product("Air-soft Gun", 1200.0, 100);

            products.add(test_product0);
            products.add(test_product1);
            products.add(test_product2);


            addDiscountToProducts(products, 50);

    }

    public static void addDiscountToProducts(List<Product> productList, int discount){
        for(Product product : productList){

            DiscountStrategy percentageDiscount = (double price, int quantity) -> (price * quantity) / 100;
            System.out.println("Product: " + product.getName());
            System.out.println("Discounted price: " + percentageDiscount.applyDiscount(product.getPrice(), discount));
            
        }
    }
}

interface DiscountStrategy {

    public double applyDiscount(double price, int quantity);

}

class Product{

    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity){

        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}