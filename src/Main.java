import catalogo.Order;
import catalogo.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.out.println("-------------------------------- EX1 --------------------------------");
        Order o = new Order();
        Predicate<Product> isMoreThanHundred = product -> product.getPrice() > 100;
        Predicate<Product> isBook = product -> product.getCategory().equals("Books");
        List<Product> l = o.getProducts().stream().filter(isBook.and(isMoreThanHundred)).toList();

        System.out.println("--------------------------------- EX2 ---------------------------------");
        List<Order> listaOrdini = new ArrayList<>();

//        Predicate<Product> isBaby = product -> product.getCategory().equals("Baby");
        List<Order> listaFiltrata = listaOrdini.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).toList();
    }
}