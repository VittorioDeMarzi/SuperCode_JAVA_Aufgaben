import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.time.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class ShopTest {

    private Shop shop;
    private Customer kazim;
    private Customer anna;
    private Customer alex;
    private Product monitor;
    private Product rolex;
    private Product pinzette;
    private Product uhr;
    private Product soundMachine;
    private Product keyboard;
    private Order o1;
    private Order o3;


    @BeforeAll
    void setup() {
        shop = new Shop();

        LocalDateTime kursbeginn = LocalDateTime.of(2024, Month.MAY, 21, 8, 45);
        Instant kursbeginnInstant = kursbeginn.toInstant(ZoneOffset.UTC);

        kazim = new Customer("Kazim", "Sakip", "k.s@gmail.com", Instant.now());
        alex = new Customer("Viktor", "Steiner", "viktors@gmail.com", kursbeginnInstant);
        anna = new Customer("Anna", "Patschen", "annapatschen@gmail.com", Instant.now());

        uhr = new Product("Uhr", "hilft dabei die Zeit zu lesen", 150.0f, "U139030", Category.ACCESSORIES);
        rolex = new Product("Rolex Uhr", "hilft dabei die Zeit zu lesen", 18000.0f, "U144430", Category.FASHION);
        soundMachine = new Product("Sound Machine", "Macht viele geräusche auf Tastenklick", 9.0f, "SM239", Category.ELECTRONICS);
        pinzette = new Product("Pinzette", "Pinzette mit integrierte LED", 2.49f, "P800", Category.BEAUTY);
        monitor = new Product("Monitor Groß", "Monitor mit vielen kleinen Pixeln", 250.0f, "LG239340e", Category.ELECTRONICS);
        keyboard = new Product("Keyboard", "Keyboard mit vielen Tasten", 100.0f, "K239340e", Category.ELECTRONICS);
        Product perfume = new Product("Perfume", "Riecht echt gut hmmmn (100ml)", 100.0f, "P239340e", Category.BEAUTY);


        o1 = new Order(kazim);
        Order o2 = new Order(kazim);
        o3 = new Order(kazim);

        Order o4 = new Order(alex);

        Order o5 = new Order(anna);
        Order o6 = new Order(anna);

        o1.addProduct(uhr, 1);
        o1.addProduct(rolex, 9);
        o1.addProduct(pinzette, 2);
        o1.setHasPaid(true);
        o1.setOrderDate(Instant.now());
        shop.addOrder(o1);

        o2.addProduct(monitor, 1);
        o2.setHasPaid(false);
        o2.setOrderDate(Instant.now());
        shop.addOrder(o2);

        o3.addProduct(soundMachine, 1);
        o3.setHasPaid(true);
        o3.setOrderDate(Instant.now());
        shop.addOrder(o3);

        o4.addProduct(monitor, 13);
        o4.addProduct(keyboard, 12);
        o4.setHasPaid(true);
        o4.setOrderDate(kursbeginnInstant);
        shop.addOrder(o4);

        o5.addProduct(perfume, 1);
        o5.addProduct(rolex, 8);
        o5.setHasPaid(true);
        o5.setOrderDate(Instant.now());
        shop.addOrder(o5);

        o6.addProduct(pinzette, 1);
        o6.setHasPaid(true);
        o6.setOrderDate(Instant.now());
        shop.addOrder(o6);
    }

    @Test
    void totalOrderValue() {
        assertEquals(18154.98f, shop.getOrderList().get(0).totalOrderValue());
    }

    @Test
    void customerWithMostOrders() {
        assertEquals(kazim, shop.customerWithMostOrder());
    }


    @Test
    void customerWithHighestLifetimeValue() {
        assertEquals(anna, shop.customerWithHighestLifetimeValue());
    }


//  Welcher Kunde ist am längsten Dabei ?
    @Test
    void firstCustomerSince() {
        assertEquals(alex, shop.firstCustomerSince());
    }

//  Was ist das beliebteste Produkt ?
    @Test
    void mostWantedProduct() {
        assertEquals(rolex, shop.mostWantedProduct());
    }

//  Was ist das unbeliebteste Produkt ?
    @Test
    void lessWantedProduct() {
        assertEquals(soundMachine, shop.lessWantedProduct());
    }

//  Was ist der durchschnittliche Wert einer Bestellung ?
    @Test
    void averageValueOneOrder() {
        assertEquals(9, shop.averageValueOneOrder(o3));
    }

//  Kunden mit Bestellungen über einen bestimmten Wert
    @Test
    void customerWithOrdersOverAValue() {
        assertEquals(List.of(kazim, anna), shop.customerWithOrdersOverAValue(30000));
    }

//  Top-Kunden pro Produkt → finde die Top-N Kunden für ein bestimmtes Produkt basierend auf der Anzahl der Bestellungen dieses Produkts
    @Test
    void topNKundenOneProduct() {
        assertEquals(kazim, shop.topNKundenOneProduct(rolex, 1));
    }

//  Welche Produktkategorie bringt den meisten Umsatz? (Muss implementiert werden)
//    @Test
//    void categoryMostSold() {
//        assertEquals(Category.ELECTRONICS, shop.categoryMostSold());
//    }

}