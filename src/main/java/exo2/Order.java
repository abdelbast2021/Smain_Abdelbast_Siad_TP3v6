package exo2;

import java.util.Objects;

// Order.java
public class Order {
    private long orderId;
    private String orderDetails;

    public Order(long orderId, String orderDetails) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
    }

    // Ajoutez les getters et setters si nécessaire

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Order order = (Order) obj;
        return orderId == order.orderId && orderDetails.equals(order.orderDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDetails);
    }
}
