import java.util.*;
class ShoppingCart {
    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Double> orderedCart = new LinkedHashMap<>();
    private NavigableMap<Double, String> sortedCart = new TreeMap<>();
    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        orderedCart.put(product, price);
        sortedCart.put(price, product);
    }
    public void displayCart() {
        System.out.println("Items in the order they were added --> ");
        for (Map.Entry<String, Double> entry : orderedCart.entrySet()) {
            System.out.println(entry.getKey() + " --> $" + entry.getValue());
        }
        System.out.println("\nItems sorted by price --> ");
        for (Map.Entry<Double, String> entry : sortedCart.entrySet()) {
            System.out.println(entry.getValue() + " --> $" + entry.getKey());
        }
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1200.00);
        cart.addProduct("Phone", 800.00);
        cart.addProduct("Headphones", 200.00);
        cart.addProduct("Mouse", 50.00);
        cart.displayCart();
    }
}
