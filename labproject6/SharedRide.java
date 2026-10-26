
package labproject6;


public class SharedRide extends EconomyRide{
    double passengerCount;

    public SharedRide(String passengerName, String pickup, String destination, double distanceKm, double pricePerKm, int durationMin, double pricePerMinute,double passengerCount) {
        super(passengerName, pickup, destination, distanceKm, pricePerKm, durationMin, pricePerMinute);
        
        if(passengerCount < 1 && passengerCount > 4){
            System.out.println("Warning: Should be in between 1-4");
            this.passengerCount = 1;
        }else{
            this.passengerCount = passengerCount;
        }
        
    }

    public double getPassengerCount() {
        return passengerCount;
    }

    

    @Override
    protected double calculateFare() {
        
        double result =(super.calculateFare() / this.passengerCount)*1.1;
        
        if(result < 50){
            return 50;
        }else{
            return result;
        }
        
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "Passenger Count: " + getPassengerCount() + " "; 
    }
    
}
