package ua.i.mail100.vehicles;

public class Bus extends Vehicle{

    public Bus(Integer wheelsNumber, Fuel... fuels) {
        super(wheelsNumber, fuels);

    }

    @Override
    void accelerate() {
        System.out.println("Bus accelerate");
    }

    @Override
    void brake() {
        System.out.println("Bus brake");
    }

    void refuel(Fuel fuel){
        System.out.println("Bus refuel");
    }
}
