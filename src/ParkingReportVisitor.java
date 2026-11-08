public class ParkingReportVisitor implements VehicleVisitor {
    @Override
    public void visitCar(Car car) {
        System.out.println("CAR | Plate: " + car.getPlateNumber() + " | Hours: " + car.getHours());
    }

    @Override
    public void visitMotorcycle(Motorcycle motorcycle) {
        System.out.println("MOTORCYCLE | Plate: " + motorcycle.getPlateNumber() + " | Hours: " + motorcycle.getHours());
    }
}
