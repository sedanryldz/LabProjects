package labproject3;

public class Car {

    private String plateNumber;
    private String model;
    private double mileage = 0;
    private double fuelLevel;
    private double tankCapacity;

    public Car(String plateNumber, String model, double fuelLevel, double tankCapacity) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.fuelLevel = fuelLevel;
        this.tankCapacity = tankCapacity;
    }

    public void Drive(double km) {
        System.out.println("Driving: " + km + "km");
        double result = km/10;
        if(result > this.fuelLevel){
            System.out.println("Not enough fuel for this trip!");
        }else{
            mileage += km;
            fuelLevel -= result;
        }
    }

    public void Refuel(double amount) {
        System.out.println("Refueling(L): " + amount);
        double totalfuel = fuelLevel + amount;
        if(totalfuel > tankCapacity){
            System.out.println("Tank is full, extra fuel discarded!");
            double diff = totalfuel - tankCapacity;
            System.out.println("Discarded fuel amount: " + diff);
            fuelLevel += amount - diff;
        }else{
            fuelLevel += amount;
        }
    }

    public void checkStatus() {
        System.out.printf("%s (%s)\n",model,plateNumber);
        System.out.printf("Current Mileage: %.2f km\n",mileage);
        System.out.printf("Current Fuel Level: %.2f / %.2f L\n",fuelLevel,tankCapacity);
        
        double lowlevel = tankCapacity*0.1;
        if(fuelLevel < lowlevel){
            System.out.println("Low fuel warning!");
        }
        System.out.println("--------------------------------------------------------");
    }
}
