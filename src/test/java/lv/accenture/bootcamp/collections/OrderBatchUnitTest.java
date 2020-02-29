package lv.accenture.bootcamp.collections;

import junit.framework.TestCase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OrderBatchUnitTest extends TestCase {

    public void testAddOrder() {
        OrderBatch orderBatch = new OrderBatch();
        assertEquals(0, orderBatch.orders.size());
        orderBatch.addOrder(new Order("Xiaomi Redmi Note 8 Pro", "Vasya Pupkin", 1));
        assertEquals(1, orderBatch.orders.size());

        assertEquals(new Order("Xiaomi Redmi Note 8 Pro", "Vasya Pupkin", 1), orderBatch.orders.get(0));
    }

    public void testWithFile() throws IOException {
        OrderBatch orderBatch = new OrderBatch();
        assertEquals(0, orderBatch.orders.size());
        Path path = Paths.get("./documents/test-orders.txt");
        List<String> orderStrings = Files.readAllLines(path);
        for (String orderString : orderStrings) {
            String[] split = orderString.split(";");
            String itemId = split[0];
            String customerName = split[1];
            int itemCount = Integer.parseInt(split[2]);
            Order order = new Order(itemId, customerName, itemCount);
            orderBatch.addOrder(order);
        }
        assertEquals(3, orderBatch.orders.size());
    }

}
