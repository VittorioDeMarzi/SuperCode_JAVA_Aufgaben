import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shop {
    private List<Order> orderList;

    public Shop() {
        this.orderList = new ArrayList<>();
    }

    public Order addOrder(Order order) {
        this.orderList.add(order);
        return order;
    }

    public Order removeOrder(Order order) {
        this.orderList.remove(order);
        return order;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    // o1, o2, o3,     o4, ...
    // <c1> <c1> <c1>  <c2>
    public Customer customerWithMostOrder() {
        return orderList
                .stream()
                .collect(Collectors.groupingBy(Order::getCustomer))
                .entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue().size()))
                .map(entry -> entry.getKey())
                .orElse(null);
    }

    public Customer customerWithHighestLifetimeValue() {
        return orderList.stream()
                .collect(Collectors.toMap(Order::getCustomer, Order::totalOrderValue, Float::sum))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Customer firstCustomerSince() {
        return orderList.stream()
                .collect(Collectors.toMap(Order::getCustomer, o -> o.getCustomer().getCustomerSince(), (customer1,customer2) -> customer1))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Product mostWantedProduct() {
        return orderList.stream()
                .flatMap(order -> order.getProducts().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Product lessWantedProduct() {
        return orderList.stream()
                .flatMap(order -> order.getProducts().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public double averageValueOneOrder(Order order) {
        return order.averageValueOneOrder();
    }

    public List<Customer> customerWithOrdersOverAValue(double value) {
        return orderList.stream()
                .collect(Collectors.toMap(Order::getCustomer, Order::totalOrderValue, (o1,o2) -> o1))
                .entrySet().stream()
                .filter(o -> o.getValue() > value)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Customer> topNKundenOneProduct(Product product, int i) {
        return orderList.stream()
                .filter(o -> o.getProducts().containsKey(product))
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.summingInt(o -> (int) o.getProducts().entrySet().stream()
                                .filter(p -> p.equals(product)).count())))
                .keySet().stream()
                .limit(i). toList();
    }


    /* Muss noch mplementiert werden*/
//    public Category categoryMostSold() {
//        orderList.stream()
//                .flatMap(order -> order.getProducts().entrySet().stream())
//                .collect(Collectors.groupingBy(
//                        Product::getCategory,
//                        Collectors.summingInt()
//                ))
//    }
}
