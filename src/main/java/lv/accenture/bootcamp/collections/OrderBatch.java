package lv.accenture.bootcamp.collections;

import java.util.*;

public class OrderBatch {

    protected List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> sortByCustomer() {
        // Implement sorting here

        return this.orders;
    }

    public List<Order> sortByItemId() {
        // Implement sorting here

        return this.orders;
    }

    public List<Order> filter(String containingString) {

        // Implement filtering here
        // Hint : use .iterator() approach

        return this.orders;
    }

    public List<Order> getCustomerOrders(String customerName) {
        List<Order> result = new ArrayList<>();

        // Implement extraction here

        return result;
    }

    public Map<String, Integer> getMostPopularItems(int limit) {
        // TODO : don't forget change return statement with real results
        return Collections.emptyMap();
    }

}
