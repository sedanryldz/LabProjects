
package labproject6;


public class Ride {
    private String passengerName,pickup, destination;
    private double distanceKm, pricePerKm;
    private int durationMin;

    public Ride(String passengerName, String pickup, String destination, double distanceKm, double pricePerKm, int durationMin) {
        this.passengerName = passengerName;
        this.pickup = pickup;
        this.destination = destination;
        if(distanceKm > 0){
            this.distanceKm = distanceKm;
        }else{
            System.out.println("Warning: Should be positive!");
            this.distanceKm = 1;
        }
        
        if(pricePerKm > 0){
            this.pricePerKm = pricePerKm;
        }else{
            System.out.println("Warning: Should be positive!");
            this.pricePerKm = 1;
        }
        
        if(durationMin > 0){
            this.durationMin = durationMin;
        }else{
            System.out.println("Warning: Should be positive!");
            this.durationMin = 1;
        }
        
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPickup() {
        return pickup;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

    public int getDurationMin() {
        return durationMin;
    }
    
    protected double calculateFare(){
        return (this.distanceKm * this.pricePerKm);
    }

    @Override
    public String toString() {
        return "Yolcu: " + getPassengerName() + " "
                + "Nereden: " + getPickup() + " "
                + "Nereye: " + getDestination() + " "
                + "Mesafe: " + getDistanceKm() + " "
                + "Süre: " + getDurationMin() + " "
                + "Km: "  + getPricePerKm() + " "
                + "Hesaplanan Ücret: " + calculateFare() + " ";
    }
    
    
}
