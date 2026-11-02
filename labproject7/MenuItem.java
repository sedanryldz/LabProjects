
package labproject7;


public class MenuItem {
    private String name;
    private double price;
    private int quantity;
    
    public MenuItem(String name, double price, int quantity) throws InvalidQuantityException {
        if (price <= 0) {
            throw new InvalidQuantityException("Price must be positive!");
        }
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be positive (greater than 0)!");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidQuantityException{
        if (price <= 0) {
            throw new InvalidQuantityException("Price must be positive!");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws InvalidQuantityException{
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be positive (greater than 0)!");
        }
        this.quantity = quantity;
        
    }
    
    public double getTotalPrice() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return name + " (x" + quantity + ") - " + getTotalPrice() + " TL";
    }
    
    
    
}
