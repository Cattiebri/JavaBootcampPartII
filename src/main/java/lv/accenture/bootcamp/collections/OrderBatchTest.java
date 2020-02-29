package lv.accenture.bootcamp.collections;

import java.util.List;
import java.util.Map;

public class OrderBatchTest {

    public static void main(String[] args) {
        OrderBatch orderBatch = new OrderBatch();
        orderBatch.addOrder(new Order("Xiaomi Redmi Note 8 Pro", "Vasya Pupkin", 1));
        orderBatch.addOrder(new Order("Blackview A80 Pro Quad 64GB", "Pupka Vasykin", 1));
        orderBatch.addOrder(new Order("Meizu C9 2GB 16GB", "SIA Accenture", 5));
        orderBatch.addOrder(new Order("Nokia 3310", "Mr. Plyushkin", 2));
        orderBatch.addOrder(new Order("Global Version Xiaomi Mi A3", "Janis Berzinsh", 2));
        orderBatch.addOrder(new Order("Xiaomi Redmi Note 8 Pro", "Peteris Ozolinsh", 1));
        orderBatch.addOrder(new Order("Global Meizu C9 2GB 16GB", "Kumar Ranjeet", 1));
        orderBatch.addOrder(new Order("Xiaomi Redmi Note 8 Pro", "Masha Pupkina", 1));
        orderBatch.addOrder(new Order("Honor 9x Smart-Phone 64gb", "SIA Accenture", 3));

        List<Order> sortedByItemId = orderBatch.sortByItemId();
        System.err.println("sortedBy ItemId = " + sortedByItemId);

        List<Order> sortedByCustomer = orderBatch.sortByCustomer();
        System.out.println("sortedBy Customer = " + sortedByCustomer);

        List<Order> customerOrders = orderBatch.getCustomerOrders("SIA Accenture");
        System.out.println("customer Orders (1) = " + customerOrders);

        orderBatch.filter("Meizu C9");

        customerOrders = orderBatch.getCustomerOrders("SIA Accenture");
        System.out.println("customerOrders (2) = " + customerOrders);

        Map<String, Integer> mostPopularItems = orderBatch.getMostPopularItems(3);
        System.out.println("mostPopularItems = " + mostPopularItems);
    }

}
