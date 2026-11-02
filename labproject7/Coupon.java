
package labproject7;


public class Coupon {
    private String code;
    private int discountRate; 
    private double minSubtotal;
    
    public Coupon(String code, int discountRate, double minSubtotal) {
        this.code = code;
        if (discountRate > 50) {
            this.discountRate = 50; 
        } else if (discountRate < 0) {
            this.discountRate = 0;
        } else {
            this.discountRate = discountRate;
        }
        this.minSubtotal = minSubtotal;
    }

    public String getCode() {
        return code;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public double getMinSubtotal() {
        return minSubtotal;
    }
    
    
}
