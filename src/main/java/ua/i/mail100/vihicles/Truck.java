package ua.i.mail100.vihicles;

public class Truck extends Vehicle{

    public Truck(Integer wheelsNumber, Fuel... fuels) {
        super(wheelsNumber, fuels);

    }

    @Override
    void accelerate() {
        System.out.println("Truck accelerate");
    }

    @Override
    void brake() {
        System.out.println("Truck brake");
    }

    void refuel(Fuel fuel){
        System.out.println("Truck refuel");
    }
}
