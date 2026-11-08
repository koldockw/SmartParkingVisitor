public class Car implements Vehicle {
    private final String plateNumber;
    private final int hours;

    public Car(String plateNumber, int hours) {
        if (hours <= 0) throw new IllegalArgumentException("Hours must be positive");
        this.plateNumber = plateNumber;
        this.hours = hours;
    }

    public String getPlateNumber() { return plateNumber; }
    public int getHours() { return hours; }

    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visitCar(this);
    }
}
