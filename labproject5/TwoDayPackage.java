package labproject5;

public class TwoDayPackage extends Package {
    
    private final double flatFee = 1.25;
    
    public TwoDayPackage(String sender_name, String sender_address, String sender_city, String sender_state, String sender_zipcode, String recipient_name, String recipient_address, String recipient_city, String recipient_state, String recipient_zipcode, double package_weight, double costPerOunce) {
        super(sender_name, sender_address, sender_city, sender_state, sender_zipcode, recipient_name, recipient_address, recipient_city, recipient_state, recipient_zipcode, package_weight, costPerOunce);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + flatFee; 
    }

    @Override
    public void showing() {
        System.out.printf("[Two Day Package]\nSender: %5s, %5s, %5s, %5s, %5s\nRecipient: %5s, %5s, %5s, %5s, %5s\nWeight: %5.2f$  | Cost Per Ounce: %5.2f$\nFlat Fee: %5.2f$\nTotal Shipping: %5.2f$\n",this.sender_name,this.sender_address,this.sender_city,this.sender_state,this.sender_zipcode,this.recipient_name,this.recipient_address,this.recipient_city,this.recipient_state,this.recipient_zipcode,this.package_weight,this.costPerOunce,flatFee,calculateCost());
        System.out.println();
        
    }

}
