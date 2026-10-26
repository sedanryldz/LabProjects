
package labproject6;


public class EconomyRide extends Ride{
    private double pricePerMinute;

    public EconomyRide(String passengerName, String pickup, String destination, double distanceKm, double pricePerKm, int durationMin,double pricePerMinute) {
        super(passengerName, pickup, destination, distanceKm, pricePerKm, durationMin);
        this.pricePerMinute = pricePerMinute;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    

    @Override
    protected double calculateFare() {
        double result = super.calculateFare() + (super.getDurationMin()*this.pricePerMinute);
        
        if(result < 50){
            return 50;
        }else{
            return result;
        }
        
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "Dk: " + getPricePerMinute() + " "; 
    }
    
}
