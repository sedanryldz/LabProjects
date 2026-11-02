
package labproject7;


public class Main {

    
    public static void main(String[] args) {
        
        Customer c1 = new Customer("Ayşe Yılmaz", "05551112233", "Gül Sok. No:5", "Talas", "Kayseri");
        Customer c2 = new Customer("Mehmet Demir", "05449998877", "Atatürk Cad. No:12", "Melikgazi", "Kayseri");
        
        Coupon validCoupon = new Coupon("DISCOUNT20", 20, 150.0); 
        Coupon highMinCoupon = new Coupon("BIG50", 50, 500.0);
        
        try {
            Order order1 = new Order(c1);
            System.out.println("Created Order #" + order1.getOrderNumber() + " for " + c1.getName());

            order1.addItem(new MenuItem("Burger", 120.0, 1));
            order1.addItem(new MenuItem("Fries", 40.0, 1));
            order1.addItem(new MenuItem("Burger", 120.0, 1));

            order1.updateQuantity("Fries", 2); 
            order1.checkout(validCoupon);
        } catch (Exception e) {
            System.out.println("Unexpected Error in Order 1: " + e.getMessage());
        }
        
        try {
            Order order2 = new Order(c2);
            System.out.println("Created Order #" + order2.getOrderNumber() + " for " + c2.getName());

            order2.addItem(new MenuItem("Pizza", 200.0, 1));
            order2.addItem(new MenuItem("Soda", 30.0, 2));

            order2.checkout(highMinCoupon);
        } catch (Exception e) {
            System.out.println("Unexpected Error in Order 2: " + e.getMessage());
        }
        
        System.out.println("--- TESTING EXCEPTIONS ---");

        try {
            System.out.println("\nTrying to create MenuItem with quantity 0...");
            MenuItem invalidItem = new MenuItem("Pizza", 150.0, 0);
        } catch (InvalidQuantityException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        try {
            System.out.println("\nTrying to remove non-existing item from order...");
            Order testOrder = new Order(c1);
            testOrder.addItem(new MenuItem("Salad", 50.0, 1));
            testOrder.removeItem("Sushi"); // Olmayan ürün
        } catch (ItemNotFoundException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        } catch (InvalidQuantityException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("\nTrying to checkout with subtotal below MIN_ORDER (100 TL)...");
            Order lowOrder = new Order(c2);
            lowOrder.addItem(new MenuItem("Coffee", 40.0, 1)); 
            lowOrder.checkout(null);
        } catch (MinimumOrderException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        } catch (InvalidQuantityException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- FINAL STATIC STATISTICS ---");
        System.out.println("Total Completed Orders : " + Order.getCompletedOrders());
        System.out.println("Total Revenue Generated: " + Order.getTotalRevenue() + " TL");
    }
    
}
