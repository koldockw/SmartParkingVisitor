# Smart Parking System - Visitor Pattern

Individual Assignment #6, Software Design Patterns.

## Idea
A parking lot contains cars and motorcycles. The Visitor pattern lets us add different operations to these vehicles without changing the vehicle classes.

## Pattern roles
- **Element interface:** `Vehicle`, with `accept(VehicleVisitor visitor)`.
- **Concrete elements:** `Car`, `Motorcycle`.
- **Visitor interface:** `VehicleVisitor`, with `visitCar` and `visitMotorcycle`.
- **Concrete visitors:** `ParkingFeeVisitor` (calculates fees), `ParkingReportVisitor` (prints a report).
- **Object structure:** `List<Vehicle>` in `Main`.

## Run
From the project directory:

```bash
javac src/*.java
java -cp src Main
```

## Double dispatch
`vehicle.accept(visitor)` uses the actual vehicle implementation to call `visitor.visitCar(this)` or `visitor.visitMotorcycle(this)`. Thus the executed operation depends on both the element type and the visitor type. No `instanceof` checks are required.

## Five Clean Code principles
1. **Meaningful names:** `ParkingFeeVisitor`, `ParkingReportVisitor`, `visitCar` clearly describe their roles.
2. **Single Responsibility:** Vehicle classes hold vehicle data; each visitor performs one separate operation.
3. **Open/Closed Principle for new operations:** Add another `VehicleVisitor` implementation without editing existing vehicle classes.
4. **Encapsulation:** Fields are `private final`; visitors access data through public getters, not internal fields.
5. **Avoid type checking:** No `instanceof` or type-switch chains; double dispatch selects the correct method.

## Limitations
Adding a new vehicle type requires adding a new method to `VehicleVisitor` and implementing it in all existing visitors. The pattern is best when the element types are relatively stable and new operations are added often.

## Defense questions
**Why Visitor?** We want separate operations on the same set of vehicle types without modifying their classes.

**What is double dispatch?** `accept` dispatches on the vehicle type; `visitCar`/`visitMotorcycle` dispatches on the visitor implementation.

**Why not `instanceof`?** It creates manual type-checking chains that are harder to extend and maintain.

**How to add a third operation?** Create a new class implementing `VehicleVisitor`, implement both visit methods, and pass it to each vehicle's `accept`.

**What is the disadvantage?** Adding a new element type forces updates to the visitor interface and every concrete visitor.
