class Car extends Vehicle {
    // constructor
    public Car(String plateNumber, String ownerName) {
        super(plateNumber, ownerName);
    }

    // Polymorphism from the Vehicle Class
    @Override
    public double computeFee(long timeOut) {
        long duration = (timeOut - timeIn) / 20;
        return duration * 2;
    }
}
