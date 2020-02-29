package lv.accenture.bootcamp.collections;

import java.util.Objects;

public class Order {

    private String itemId; // Name of the item
    private String customer; // Name of the customer
    private int count; // Count of the requested items

    public Order(String itemId, String customer, int count) {
        this.itemId = itemId;
        this.customer = customer;
        this.count = count;
    }

    // TODO : don't forget create getters here!


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return count == order.count &&
                Objects.equals(itemId, order.itemId) &&
                Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, customer, count);
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemId='" + itemId + '\'' +
                ", customer='" + customer + '\'' +
                ", count=" + count +
                "}\n";
    }
}
