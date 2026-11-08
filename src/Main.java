import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = Arrays.asList(
            new Car("123ABC", 3),
            new Motorcycle("456XYZ", 2),
            new Car("789DEF", 1)
        );

        VehicleVisitor reportVisitor = new ParkingReportVisitor();
        ParkingFeeVisitor feeVisitor = new ParkingFeeVisitor();

        System.out.println("=== PARKING REPORT ===");
        for (Vehicle vehicle : vehicles) vehicle.accept(reportVisitor);

        System.out.println("\n=== PARKING FEES ===");
        for (Vehicle vehicle : vehicles) vehicle.accept(feeVisitor);
        System.out.println("TOTAL: " + feeVisitor.getTotalFee() + " KZT");
    }
}
