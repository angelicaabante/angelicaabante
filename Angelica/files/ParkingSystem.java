class ParkingSystem {
   private Vehicle[] slots = new Vehicle[40];
   private double dailyIncome = 0;


   private int carCount = 0;
   private int electricCarCount = 0;
   private int motorCount = 0;


   private final int CAR_LIMIT = 10;
   private final int MOTOR_LIMIT = 20;
   private final int ELECTRIC_CAR_LIMIT = 10;


   //add vehicle method
   public void addVehicle(Vehicle v) {
       try {
           if (v == null) {
               throw new NullPointerException("Vehicle section should not be null");
           }
           if (v instanceof Car && carCount >= CAR_LIMIT) {
               System.out.println("Car slots FULL!");
               return;
           }
           if (v instanceof ElectricCar && electricCarCount >= ELECTRIC_CAR_LIMIT) {
               System.out.println("Electric car slots are FULL!");
               return;
           }
           if (v instanceof Motorcycle && motorCount >= MOTOR_LIMIT) {
               System.out.println("Motorcycle slots FULL!");
               return;
           }


           for (int i = 0; i < slots.length; i++) {
               if (slots[i] == null) {
                   slots[i] = v;


                   if (v instanceof Car) {
                       carCount++;
                   } else if (v instanceof ElectricCar) {
                       electricCarCount++;
                   } else {
                       motorCount++;
                   }


                   System.out.println("Vehicle parked in slot " + (i + 1));
                   return;
               }
           }
           System.out.println("No available slots!");
       } catch (NullPointerException e) {
           System.out.println("Error occurred: " + e.getMessage());
       } catch (Exception e) {
           System.out.println("An unexpected error occurred while adding your vehicle: " + e.getMessage());
       }
   }


   //exit vehicle method
   public void exitVehicle(String plate) {
       try {
           for (int i = 0; i < slots.length; i++) {
               if (slots[i] != null && slots[i].getPlateNumber().equalsIgnoreCase(plate)) {
                   long timeOut = System.currentTimeMillis();
                   double fee = slots[i].computeFee(timeOut);
                   dailyIncome += fee;


                   System.out.println("\n--- Exit Details ---");
                   System.out.println("Plate: " + slots[i].getPlateNumber());
                   System.out.println("Fee: ₱" + String.format("%.2f", fee));


                   if (slots[i] instanceof Car) carCount--;
                   else motorCount--;


                   slots[i] = null;
                   return;
               }
           }
           throw new IllegalStateException("Vehicle with plate number '" + plate + "' not found");
       }
       catch(IllegalArgumentException e){
           System.out.println("Error: " + e.getMessage());
       }
       catch(Exception e){
           System.out.println("An unexpected error occurred while exiting vehicle: " + e.getMessage());
       }
   }


   //method for displaying the slots
   public void displaySlots() {
       try {
           System.out.println("\n===== MOTORCYCLE SLOTS =====");
           int motorIndex = 1;
           for (int i = 0; i < slots.length; i++) {
               if (slots[i] instanceof Motorcycle) {
                   System.out.println(motorIndex + ". " + slots[i].getPlateNumber() +
                           " - " + slots[i].getOwnerName());
                   motorIndex++;
               }
           }
           while (motorIndex <= MOTOR_LIMIT) {
               System.out.println(motorIndex + ". EMPTY");
               motorIndex++;
           }


           System.out.println("\n===== REGULAR CAR SLOTS =====");
           int carIndex = 1;
           for (int i = 0; i < slots.length; i++) {
               if (slots[i] instanceof Car) {
                   System.out.println(carIndex + ". " + slots[i].getPlateNumber() +
                           " - " + slots[i].getOwnerName());
                   carIndex++;
               }
           }
           while (carIndex <= CAR_LIMIT) {
               System.out.println(carIndex + ". EMPTY");
               carIndex++;
           }


           System.out.println("\n===== ELECTRIC CAR SLOTS =====");
           int ecarIndex = 1;
           for(int i = 0; i < slots.length; i++){
               if(slots[i] instanceof ElectricCar){
                   ElectricCar ec = (ElectricCar) slots[i];
                   System.out.println(ecarIndex + ". " + ec.getPlateNumber() + " - " + ec.getOwnerName() + "(Battery " + ec.getBatteryPercentage() + "%");
                   ecarIndex++;
               }
           }
           while (ecarIndex <= ELECTRIC_CAR_LIMIT){
               System.out.println(ecarIndex + ". EMPTY");
               ecarIndex++;
           }


       }
       catch(Exception e){
           System.out.println("Error displaying slots: " + e.getMessage());
       }
   }


   //view active slots
   public void viewActiveSlots() {
       try {
           System.out.println("\n--- Active Vehicles ---");
           boolean hasVehicles = false;
           for (Vehicle v : slots) {
               if (v != null) {
                   String type = "";
                   if (v instanceof Car) {
                       type = " (Regular Car)";
                   } else if (v instanceof ElectricCar) {
                       type = " (Electrical Car)";
                   } else {
                       type = " (Motorcycle)";
                   }
                   System.out.println(v.getPlateNumber() + " - " + v.getOwnerName());
                   hasVehicles = true;
               }
           }


           if (!hasVehicles) {
               System.out.println("No vehicles currently parked.");
           }
       }
       catch(Exception e){
           System.out.println("Error viewing active slots: " + e.getMessage());
       }
   }


   //showing the income of the parking slot
   public void showIncome() {
       try {
           System.out.println("\n--- Income Report ---");
           System.out.println("Today: ₱" + String.format("%.2f", dailyIncome));
           System.out.println("Week: ₱" + String.format("%.2f", dailyIncome));
           System.out.println("Month: ₱" + String.format("%.2f", dailyIncome));
       }
       catch(Exception e){
           System.out.println("Error showing income: " + e.getMessage());
       }
   }
}
