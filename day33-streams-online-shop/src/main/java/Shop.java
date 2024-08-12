import java.lang.reflect.Array;
import java.util.*;
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

    public Product productWithMostCustomers() {
        return orderList.stream()
                .flatMap(o -> o.getProducts().entrySet().stream()
                        .map(e -> new AbstractMap.SimpleImmutableEntry<>(
                                e.getKey(), o.getCustomer()
                                )))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(
                        Map.Entry::getValue, Collectors.toSet()
                )))
                .entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().size()))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Example: produts.csv
    // Content
    // name,description,price,articleNr,category
    // Rolex,Rolex uhr,18000.0,R393,SCHMUCK
    // Pinzette,pinzette zum haare zupfen,5.29,P478,KOSMETIK
    // Monitor,monitor um ein bild zu sehen,120.0,M478,TECH
    // MILCH,was trinkt die kuh? wasser,1.69,MILCH1,ESSEN
    public static List<Product> parseProductListCsv(String csv) {
        String[] lines = csv.split("\n");

        return Arrays.stream(lines)
                .skip(1)
                .map(line -> {
                    String[] data = line.split(",");
                    if (data.length<5) throw new IllegalArgumentException("CSV row " + line + "has missing data");
                    return new Product(data[0], data[1], Float.parseFloat(data[2]), data[3], Category.valueOf(data[4]));
                }).collect(Collectors.toList());
    }


    public Category topCategoryByRevenue() {
        //        o1,                            o2, ...                o3
        // kazim - [pinzette=3,      rolex=1]         kazim - [pinzette=1]     anna - [pinzette=8,            monitor=2]
        //          price, category    price, category            price, category         price, category     price, category
        Optional<Category> foundCategory = orderList
                .stream()
                .flatMap(order -> order.getProducts().entrySet().stream())
                .map(orderProductEntry -> new AbstractMap.SimpleEntry<Category, Double>(
                        orderProductEntry.getKey().getCategory(), // product dieser bestellung
                        orderProductEntry.getKey().getPrice() * orderProductEntry.getValue().doubleValue() // umsatz durch product dieser bestellung
                ))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingDouble(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        if(foundCategory.isEmpty()) throw new IllegalStateException("No top Category found");
        else return foundCategory.get();
    }
}
