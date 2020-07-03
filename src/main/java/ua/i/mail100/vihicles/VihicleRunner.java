package ua.i.mail100.vihicles;

public class VihicleRunner {
    public static void main(String[] args) {
        Car carOne = new Car(4, Car.Type.RACING_CAR, Fuel.GASOLINE, Fuel.ELECTRICITY);
        Car carTwo = new Car(4, Car.Type.RACING_CAR, Fuel.DIESEL);

        carOne.refuel(Fuel.DIESEL);
        carOne.accelerate();

        Truck truckOne = new Truck(12, Fuel.DIESEL);
        truckOne.accelerate();
        truckOne.brake();

        Bus busOne = new Bus(6, Fuel.DIESEL);
        busOne.accelerate();
        busOne.brake();
    }
}
