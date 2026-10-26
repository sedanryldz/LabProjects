
package labproject6;

import java.util.ArrayList;


public class Main {

    
    public static void main(String[] args) {
        
        ArrayList<Ride> rides = new ArrayList<>();
        rides.add(new Ride("Ali", "Bahçelievler", "Anayurt", 0, 0, 0));
        rides.add(new Ride("Ali", "Bahçelievler", "Anayurt", 10, 15, 25));
        rides.add(new EconomyRide("Ali","Bahçelievler" , "Anayurt", 10, 15, 25, 2));
        rides.add(new PremiumRide("Ali", "Bahçelievler", "Anayurt", 10, 15, 25, 100, 1.5));
        rides.add(new SharedRide("Ali", "Bahçelievler", "Anayurt", 10, 15, 25, 2, 2.5));
        rides.add(new SharedRide("Ali", "Bahçelievler", "Anayurt", 10, 1, 2, 2, 2.5));
        
        for(int i=0; i<rides.size(); i++){
            System.out.println(rides.get(i));
        }
    }
    
}
