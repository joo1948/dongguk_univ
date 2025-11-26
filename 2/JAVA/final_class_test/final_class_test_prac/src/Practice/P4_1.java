import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P4_1 {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Laptop", 1200),
                new Order("Mouse", 20),
                new Order("Invalid1", -10),
                new Order("", 30),
                new Order("Keyboard", 0),
                new Order("Monitor", 300)
        );

        OrderProcessor processor = new OrderProcessor();
        OrderFilter filter = o -> o.getPrice() >= 50;

        List<Order> validOrders = processor.filterOrders(orders, filter);

        validOrders.forEach(System.out::println);
        System.out.println("잘못된 주문 개수: " + (orders.size() - validOrders.size()));
    }
}

class Order {
    private final String name;
    private final int price;

    public Order(String name, int price) {
        if (name == null || name.isBlank()) throw new InvalidOrderException("이름이 비어 있음");
        if (price <= 0) throw new InvalidOrderException("가격이 0 이하");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return name + " (" + price + ")";
    }
}

class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String msg) {
        super(msg);
    }
}

interface OrderFilter {
    boolean validate(Order o) throws Exception;
}

class OrderProcessor {
    public List<Order> filterOrders(List<Order> orders, OrderFilter filter) {
        List<Order> result = new ArrayList<>();
        orders.stream().forEach(o -> {
            try {
                if (filter.validate(o)) result.add(o);
            } catch (Exception e) {
                System.out.println("[ERROR] " + o + " : " + e.getMessage());
            }
        });
        return result;
    }
}
