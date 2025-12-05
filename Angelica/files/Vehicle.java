//Abstract Class of the system
abstract class Vehicle {
   private String plateNumber;
   private String ownerName;
   protected long timeIn;


   //constructor
   public Vehicle(String plateNumber, String ownerName) {
       this.plateNumber = plateNumber;
       this.ownerName = ownerName;
       this.timeIn = System.currentTimeMillis();
   }


   // Encapsulation getter of Plate Number
   public String getPlateNumber() {
       return plateNumber;
   }


   //Encapsulation getter of Owner Name
   public String getOwnerName() {
       return ownerName;
   }


   //abstract method
   public abstract double computeFee(long timeOut);
}
