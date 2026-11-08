public class ParkingFeeVisitor implements VehicleVisitor {
    private int totalFee = 0;

    @Override
    public void visitCar(Car car) {
        int fee = car.getHours() * 500;
        totalFee += fee;
        System.out.println("Car " + car.getPlateNumber() + ": " + fee + " KZT");
    }

    @Override
    public void visitMotorcycle(Motorcycle motorcycle) {
        int fee = motorcycle.getHours() * 200;
        totalFee += fee;
        System.out.println("Motorcycle " + motorcycle.getPlateNumber() + ": " + fee + " KZT");
    }

    public int getTotalFee() { return totalFee; }
}
