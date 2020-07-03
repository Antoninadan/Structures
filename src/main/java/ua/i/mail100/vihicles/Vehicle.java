package ua.i.mail100.vihicles;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected List<Fuel> permittedFuel = new ArrayList<>();
    protected Integer wheelsNumber;

    public Vehicle(Integer wheelsNumber, Fuel ...fuels) {
        this.wheelsNumber = wheelsNumber;
        for(Fuel each:fuels) {
            this.permittedFuel.add(each);
        }
    }

    void refuel (Fuel fuel) {
    if (!permittedFuel.contains(fuel)) {
        throw new }
    }

    abstract void accelerate();
    abstract void brake();
}
