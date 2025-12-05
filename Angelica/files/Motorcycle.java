//2nd SubClass
class Motorcycle extends Vehicle {
    // constructor
    public Motorcycle(String plateNumber, String ownerName) {
        super(plateNumber, ownerName);
    }

    // Polymorphism from the Vehicle class
    @Override
    public double computeFee(long timeOut) {
        long duration = (timeOut - timeIn) / 10;
        return duration * 1;
    }
}
