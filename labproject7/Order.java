
package labproject7;

import java.util.ArrayList;


public class Order {
    private Customer customer;
    private ArrayList<MenuItem> items;
    private int orderNumber;
    private boolean isCompleted;
    
    private static int nextOrderNumber = 1001;
    public static final double MIN_ORDER = 100.0;
    public static final double DELIVERY_FEE = 20.0;
    private static int completedOrders = 0;
    private static double totalRevenue = 0.0;
    
    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
        this.orderNumber = nextOrderNumber++;
        this.isCompleted = false;
    }
    
    public static int getCompletedOrders() {
        return completedOrders;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    
    public void addItem(MenuItem item) throws InvalidQuantityException {
        for (MenuItem existingItem : items) {
            if (existingItem.getName().equalsIgnoreCase(item.getName())) {
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        items.add(item);
    }
    
    public void removeItem(String name) throws ItemNotFoundException {
        MenuItem target = null;
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                target = item;
                break;
            }
        }
        if (target != null) {
            items.remove(target);
        } else {
            throw new ItemNotFoundException("Item '" + name + "' not found in order!");
        }
    }
    
    public void updateQuantity(String name, int quantity) throws ItemNotFoundException, InvalidQuantityException {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.setQuantity(quantity);
                return;
            }
        }
        throw new ItemNotFoundException("Item '" + name + "' not found in order!");
    }
    
    public double getSubtotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
    
    public ArrayList<MenuItem> getItems() {
        ArrayList<MenuItem> copyList = new ArrayList<>();
        for (MenuItem item : items) {
            try {
                copyList.add(new MenuItem(item.getName(), item.getPrice(), item.getQuantity()));
            } catch (InvalidQuantityException ignored) {}
        }
        return copyList;
    }
    
    public double applyCoupon(Coupon coupon) {
        double subtotal = getSubtotal();
        if (coupon != null && subtotal >= coupon.getMinSubtotal()) {
            return subtotal * (coupon.getDiscountRate() / 100.0);
        }
        return 0.0;
    }
    
    public void checkout(Coupon coupon) throws MinimumOrderException {
        if (isCompleted) {
            System.out.println("Order #" + orderNumber + " is already completed!");
            return;
        }

        double subtotal = getSubtotal();
        if (subtotal < MIN_ORDER) {
            throw new MinimumOrderException("Order total (" + subtotal + " TL) is below the minimum order limit of " + MIN_ORDER + " TL!");
        }

        double discount = applyCoupon(coupon);
        double total = (subtotal - discount) + DELIVERY_FEE;

        
        isCompleted = true;
        completedOrders++;
        totalRevenue += total;

        
        System.out.println("\n========== RECEIPT ==========");
        System.out.println("Order Number : #" + orderNumber);
        System.out.println("Customer     : " + customer.getName() + " (" + customer.getPhone() + ")");
        System.out.println("Address      : " + customer.getAddress());
        System.out.println("-----------------------------");
        System.out.println("Items:");
        for (MenuItem item : items) {
            System.out.println("  - " + item);
        }
        System.out.println("-----------------------------");
        System.out.println("Subtotal     : " + subtotal + " TL");
        System.out.println("Discount     : -" + discount + " TL");
        System.out.println("Delivery Fee : " + DELIVERY_FEE + " TL");
        System.out.println("TOTAL        : " + total + " TL");
        System.out.println("=============================\n");
    }
}
