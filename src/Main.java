import catalogo.Customer;
import catalogo.Order;
import catalogo.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Order o1 = new Order();
        Customer cust1 = new Customer();
        cust1.setName("Utente 1");
        cust1.setTier(2);
        Product p1 = new Product();
        p1.setName("Prodotto1");
        p1.setPrice(10.00);
        p1.setCategory("Books");
        o1.setCustomer(cust1);

        o1.setCustomer(cust1);
        o1.getProducts().add(p1);
        o1.setOrderDate(LocalDate.of(2021,2,1));

        System.out.println("-------------------------------- EX1 --------------------------------");

        Predicate<Product> isMoreThanHundred = product -> product.getPrice() > 100;
        Predicate<Product> isBook = product -> product.getCategory().equals("Books");
        List<Product> l = o1.getProducts().stream().filter(isBook.and(isMoreThanHundred)).toList();

        System.out.println(l);

        System.out.println("--------------------------------- EX2 ---------------------------------");
        List<Order> listaOrdini = new ArrayList<>();

        listaOrdini.add(o1);

//        Predicate<Product> isBaby = product -> product.getCategory().equals("Baby");
        List<Order> listaFiltrata = listaOrdini.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).toList();

        System.out.println(listaFiltrata);

        System.out.println("-------------------------------- EX3 ------------------------------------");

        List<Product> l2 = o1.getProducts().stream().filter(product -> product.getCategory().equals("Boys")).map(product -> {product.setPrice(product.getPrice()*0.9); return product;}).toList();

        System.out.println(l2);

        System.out.println("--------------------------------- EX4 --------------------------------------");

        Predicate<Order> tier2 = order -> order.getCustomer().getTier() == 2;

        LocalDate after = LocalDate.of(2021,1,31);
        LocalDate before = LocalDate.of(2021, 4, 2);

        Predicate<Order> feb21Apr21 = order -> order.getOrderDate().isAfter(after) && order.getOrderDate().isBefore(before);

        List<Product> l3 = listaOrdini.stream().filter(tier2.and(feb21Apr21)).flatMap(order -> order.getProducts().stream()).toList();

        System.out.println(listaOrdini);
    }
}