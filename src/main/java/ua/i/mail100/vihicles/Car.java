package ua.i.mail100.vihicles;

public class Car extends Vehicle{
    public static enum Type{
        SUV,
        RACING_CAR,
        COMPACT_CAR;
    }

    public Car(Integer wheelsNumber, Type type, Fuel... fuels) {
        super(wheelsNumber, fuels);

    }

    @Override
    void accelerate() {
        System.out.println("Car accelerate");
    }

    @Override
    void brake() {
        System.out.println("Car brake");
    }

    void refuel(Fuel fuel){
        try {
            if (!permittedFuel.contains(fuel)) {
                brake();
                throw new WrongFuelExeption();
            }
            System.out.println("Car refuel");
        } catch (WrongFuelExeption wrongFuelExeption) {
            System.out.println(wrongFuelExeption.getMessage());
        }
    }
}
