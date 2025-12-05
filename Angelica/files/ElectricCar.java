//3rd SubClass Electric Car
public class ElectricCar extends Vehicle{
   private int batteryPercentage;


   //constructor
   public ElectricCar(String plateNumber, String ownerName, int batteryPercentage){
       super(plateNumber, ownerName);
       this.batteryPercentage = batteryPercentage;
   }


   //Encapsulation getter of battery percentage
   public int getBatteryPercentage(){
       return batteryPercentage;
   }


   //Polymorphism from the abstract class
   @Override
   public double computeFee(long timeOut){
       long duration = (timeOut - timeIn) / 20;
       //Electric cars get a 20% discount on parking fee
       return duration * 2 * 0.8;
   }
}
