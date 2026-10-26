
package labproject6;


public class PremiumRide extends Ride{
    private double comfortFee, surgeMultiplier;

    public PremiumRide(String passengerName, String pickup, String destination, double distanceKm, double pricePerKm, int durationMin,double comfortFee, double surgeMultiplier) {
        super(passengerName, pickup, destination, distanceKm, pricePerKm, durationMin);
        this.comfortFee = comfortFee;
        
        if(surgeMultiplier < 1.0 && surgeMultiplier > 3.0){
            System.out.println("Warning: Should be in between 1.0-3.0");
            this.surgeMultiplier = 1.0;
        }else{
            this.surgeMultiplier = surgeMultiplier;
        }
        
        
    }

    public double getComfortFee() {
        return comfortFee;
    }

    public double getSurgeMultiplier() {
        return surgeMultiplier;
    }


    @Override
    protected double calculateFare() {
        return (super.calculateFare() + this.comfortFee)* this.surgeMultiplier; 
    }
    
    
        @Override
    public String toString() {
        return super.toString() + "Comfort Fee: " + getComfortFee() + " " + "Surge Multiplier: " + getSurgeMultiplier() + " "; 
    }

    
    
    
}
