import java.util.Scanner;
import java.util.InputMismatchException;


//the main class
public class SmartPark {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       ParkingSystem ps = new ParkingSystem();


       try {
           System.out.println("========== Login Page ==========`");
           System.out.print("Username: ");
           String u = sc.nextLine();
           System.out.print("Password: ");
           String p = sc.nextLine();

           if (!u.equals("glen") || !p.equals("12345")) {
               System.out.println("Login failed!");
               sc.close();
               return;
           }


           System.out.println("\nLogin successful!");


           while (true) {
               try {
                   //the SmartPark Menu
                   System.out.println("\n=== SMARTPARK MENU ===");
                   System.out.println("1. Add Vehicle");
                   System.out.println("2. Exit Vehicle");
                   System.out.println("3. Display Slots");
                   System.out.println("4. View Active Slots");
                   System.out.println("5. Income");
                   System.out.println("6. Exit");
                   System.out.print("Choose: ");


                   int choice = sc.nextInt();
                   sc.nextLine();


                   switch (choice) {
                       case 1:
                           try {
                               System.out.print("Plate Number: ");
                               String plate = sc.nextLine();


                               if (plate.trim().isEmpty()) {
                                   throw new IllegalArgumentException("Plate number cannot be empty!");
                               }


                               System.out.print("Owner Name: ");
                               String name = sc.nextLine();


                               if (name.trim().isEmpty()) {
                                   throw new IllegalArgumentException("Owner name cannot be empty!");
                               }


                               System.out.print("Vehicle Type (1 = Car, 2 = Motorcycle, 3 = Electric Car): ");
                               int type = sc.nextInt();
                               sc.nextLine();


                               Vehicle v = null;


                               if (type == 1) {
                                   v = new Car(plate, name);
                               } else if (type == 2) {
                                   v = new Motorcycle(plate, name);
                               } else if (type == 3) {
                                   System.out.print("Battery Percentage (0-100): ");
                                   int battery = sc.nextInt();
                                   sc.nextLine();


                                   if (battery < 0 || battery > 100) {
                                       throw new IllegalArgumentException("Battery percentage must be between 0 and 100!");
                                   }


                                   v = new ElectricCar(plate, name, battery);
                               } else {
                                   throw new IllegalArgumentException("Invalid vehicle type!");
                               }


                               ps.addVehicle(v);
                           } catch (IllegalArgumentException e) {
                               System.out.println("Error: " + e.getMessage());
                           } catch (InputMismatchException e) {
                               System.out.println("Error: Please enter a valid number!");
                               sc.nextLine(); // Clear buffer
                           }
                           break;


                       case 2:
                           System.out.print("Enter plate number: ");
                           String exitPlate = sc.nextLine();
                           ps.exitVehicle(exitPlate);
                           break;


                       case 3:
                           ps.displaySlots();
                           break;


                       case 4:
                           ps.viewActiveSlots();
                           break;


                       case 5:
                           ps.showIncome();
                           break;


                       case 6:
                           System.out.println("System saved. Goodbye!");
                           sc.close();
                           return;


                       default:
                           System.out.println("Invalid choice. Please try again.");
                   }
               } catch (InputMismatchException e) {
                   System.out.println("Error: Please enter a valid number!");
                   sc.nextLine(); // Clear the invalid input
               } catch (Exception e) {
                   System.out.println("An unexpected error occurred: " + e.getMessage());
               }
           }
       } catch (Exception e) {
           System.out.println("Critical error: " + e.getMessage());
       } finally {
           sc.close();
       }
   }
}
