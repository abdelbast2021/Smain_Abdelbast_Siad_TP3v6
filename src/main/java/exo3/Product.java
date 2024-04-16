package exo3;

import java.util.Objects;

// Product.java
public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Ajoutez les getters et setters si nécessaire

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Product product = (Product) obj;
        return id.equals(product.id) && name.equals(product.name) && price == product.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
