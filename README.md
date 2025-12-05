SMARTPARK: Parking Management System

A Java-based parking automation program using OOP principles

📌 Overview

The SmartPark System is a comprehensive parking management application developed in Java. Its primary purpose is to automate the process of managing vehicles in a parking facility, calculating parking fees, and tracking daily income. The application handles vehicle registration upon entry, calculates the total fee based on the duration of stay and vehicle type upon exit, and provides real time reports on active vehicles and its revenue. 


🧠 Object-Oriented Concepts Used
🔹 Abstraction

Implemented implemented through the Vehicle abstract class, which defines shared attributes such as the plate number, owner name, and time-in. It also declares the abstract method computeFee(), requiring all subclasses to provide their own specific fee computation logic. This ensures that every vehicle type follows the same structure while allowing each one to implement its own rules.

🔹 Inheritance

The SmartPark system uses inheritance by creating a hierarchy where Car, Motorcycle, and ElectricCar all extend the abstract Vehicle class. These subclasses automatically inherit the attributes plateNumber, ownerName, and timeIn, allowing the program to avoid duplicating code. Through inheritance, each subclass can also add unique behaviors while still maintaining the base structure provided by Vehicle.


🔹 Polymorphism

Each vehicle type overrides the computeFee() method.
When the system calculates fees, the correct version runs automatically depending on the subclass.Polymorphism is applied in the system through the overriding of the abstract method computeFee() in each subclass. Although all vehicle objects are treated as type Vehicle, the correct version of computeFee() is automatically chosen at runtime depending on whether the object is a Car, Motorcycle, or Electric Car. This allows SmartPark to compute fees using different rules for each type.


🔹 Encapsulation

Encapsulation is demonstrated by restricting direct access to key attributes in each class. Fields such as plate number, and owner name  are declared as private or protected, ensuring that external classes cannot modify them freely. Instead, access is provided only through getter methods, which control how data is retrieved. The ParkingSystem class also encapsulates its slot array and income variables, exposing only the necessary methods to add vehicles, remove vehicles, or display parking information. 


🗂️ Project Structure
Vehicle.java           → Abstract superclass
Car.java               → Subclass for regular cars
ElectricCar.java       → Subclass for electric vehicles
Motorcycle.java        → Subclass for motorcycles
ParkingSystem.java     → Core logic: slots, income, add/remove vehicles
Main.java              → Entry point (menu + user interaction)

 How to Run The Program
             Requirements:
Java JDK installed
All files in the same folder:
Vehicle.java
Car.java
ElectricCar.java
Motorcycle.java
ParkingSystem.java
Main.java (the program's entry point)
Steps:
Step 1 — Compile
Open your terminal or command prompt inside the folder and type:
javac *.java
This compiles all .java files.

Step 2 — Run

Run the main program:
java Main


Step 3 — Use the Menu
The system will show something like:
1. Park Vehicle
2. Exit Vehicle
3. View Slots
4. Active Vehicles
5. View Income
6. Exit Program

You enter the number of your choice and follow the instructions.

 2. PROGRAM STRUCTURE
Here is a simple Grade-10 friendly explanation of how the whole program is built:
1. Vehicle (Superclass)
                        The main parent class.
Stores:
Plate number
Owner name
Time-in
Has:
computeFee() method (which child classes override)
2. Subclasses (Types of Vehicles)
Class	Inherits From	Special Features
Car	Vehicle	Regular car fee and rules
ElectricCar	Vehicle	Has battery percentage
Motorcycle	Vehicle	Motorcycle fee rules
Each class overrides computeFee() to calculate its own parking fee.
3. ParkingSystem
This is the brain of the program.
It handles:
Parking vehicles
Removing vehicles
Showing slots
Tracking income
Counting vehicle types
Making sure limits are not exceeded
It contains:
An array of 40 parking slots
Counters for each type
Methods:
addVehicle()
exitVehicle()
displaySlots()
viewActiveSlots()

showIncome()
4. Main Class
This class:
Creates a ParkingSystem object
Shows a menu
Lets the user choose actions
Acts as the "controller" that makes the whole system run


Simple Structure Diagram
          Vehicle (Parent Class)
         /          |          \
      Car     ElectricCar   Motorcycle
         \        |        /
           (All stored in)
           ParkingSystem
                |
               Main

▶️ How to Run the Program
Requirements

Java JDK installed

All .java files in the same directory

Step 1 — Compile
javac *.java

Step 2 — Run
java Main

Step 3 — Use the Menu

Example menu:

1. Park Vehicle
2. Exit Vehicle
3. View Slots
4. Active Vehicles
5. View Income
6. Exit Program

📝 Sample Output
========== Login Page ==========`
Username: glen
Password: 12345

Login successful!

=== SMARTPARK MENU ===
1. Add Vehicle
2. Exit Vehicle
3. Display Slots
4. View Active Slots
5. Income
6. Exit
Choose: 1
Plate Number: 12
Owner Name: angee
Vehicle Type (1 = Car, 2 = Motorcycle, 3 = Electric Car): 1
Vehicle parked in slot 1

=== SMARTPARK MENU ===
1. Add Vehicle
2. Exit Vehicle
3. Display Slots
4. View Active Slots
5. Income
6. Exit
Choose: 1
Plate Number: 45
Owner Name: hed
Vehicle Type (1 = Car, 2 = Motorcycle, 3 = Electric Car): 1
Vehicle parked in slot 2

=== SMARTPARK MENU ===
1. Add Vehicle
2. Exit Vehicle
3. Display Slots
4. View Active Slots
5. Income
6. Exit
Choose: 2
Enter plate number: 12

--- Exit Details ---
Plate: 12
Fee: ?34.00

=== SMARTPARK MENU ===
1. Add Vehicle
2. Exit Vehicle
3. Display Slots
4. View Active Slots
5. Income
6. Exit
Choose: 3

===== MOTORCYCLE SLOTS =====
1. EMPTY
2. EMPTY
3. EMPTY
4. EMPTY
5. EMPTY
6. EMPTY
7. EMPTY
8. EMPTY
9. EMPTY
10. EMPTY
11. EMPTY
12. EMPTY
13. EMPTY
14. EMPTY
15. EMPTY
16. EMPTY
17. EMPTY
18. EMPTY
19. EMPTY
20. EMPTY

===== REGULAR CAR SLOTS =====
1. 45 - hed
2. EMPTY
3. EMPTY
4. EMPTY
5. EMPTY
6. EMPTY
7. EMPTY
8. EMPTY
9. EMPTY
10. EMPTY

===== ELECTRIC CAR SLOTS =====
1. EMPTY
2. EMPTY
3. EMPTY
4. EMPTY
5. EMPTY
6. EMPTY
7. EMPTY
8. EMPTY
9. EMPTY
10. EMPTY

=== SMARTPARK MENU ===
1. Add Vehicle
2. Exit Vehicle
3. Display Slots
4. View Active Slots
5. Income
6. Exit
Choose: 4

--- Active Vehicles ---
45 - hed

=== SMARTPARK MENU ===
1. Add Vehicle
2. Exit Vehicle
3. Display Slots
4. View Active Slots
5. Income
6. Exit
Choose: 1
Plate Number: 45
Owner Name: glen
Vehicle Type (1 = Car, 2 = Motorcycle, 3 = Electric Car): 1
Vehicle parked in slot 1

=== SMARTPARK MENU ===
1. Add Vehicle
2. Exit Vehicle
3. Display Slots
4. View Active Slots
5. Income
6. Exit
Choose: 5

--- Income Report ---
Today: ?34.00
Week: ?34.00
Month: ?34.00

=== SMARTPARK MENU ===
1. Add Vehicle
2. Exit Vehicle
3. Display Slots
4. View Active Slots
5. Income
6. Exit
Choose: 6
System saved. Goodbye!


👥 Authors
Glen Cedrick D. Carag	24-07521	BSIT	0967 196 0790
Angelica Mae C. Abante	24-07105	BSIT	0949 935 3130
Hedrick Ashley M. Paala	24-08611	BSIT	0967 138 9642

Batangas State University
Bachelor of Science in Information Technology (BSIT)

FUTURE ENHANCEMENT:

Improved User Interface (UI)

Organized user interface can be created using Java Swing or JavaFX. This will replace the text-based display with buttons, panels, and tables, making the system easier to use and more visually appealing. A clearer UI also helps staff avoid mistakes and work faster.

Real-Time Slot Monitoring

The system can show a live view of all parking slots, updating automatically whenever a vehicle enters or exits. Each slot can be shown with colors such as green for available and red for occupied. This makes it easier for staff to see the current status without checking manually.

Advanced Fee Computation

Future versions may include more flexible fee rules. Examples include hourly or daily rates, weekend pricing, flat fees, penalty fees, or additional charges for electric vehicle charging. This allows the system to fit different parking policies and real business needs.

QR Code Check-In and Check-Out

QR codes can be used to speed up entry and exit. When a vehicle enters, the system can generate a QR code that contains the vehicle details. During exit, staff can simply scan the QR code to retrieve the record. This reduces typing, prevents errors, and makes the process quicker.

 Automatic Digital Receipt

The system can generate a receipt automatically after a vehicle exits. The receipt may include the plate number, time in, time out, duration, and total fee. It can be shown on screen, saved as a file, or printed. This feature helps customers keep records and improves the professionalism of the system.

