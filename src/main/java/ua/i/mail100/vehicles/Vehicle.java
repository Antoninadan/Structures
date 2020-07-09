package ua.i.mail100.vehicles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

public abstract class Vehicle {
    protected List<Fuel> permittedFuel;
    protected List<Fuelable> pFuelables;
    protected int wheelsNumber;

    public Vehicle(int wheelsNumber, Fuel... fuels) {
        permittedFuel = new ArrayList<>();//composition

        this.wheelsNumber = wheelsNumber;

        /*for (Fuel each : fuels) {
            this.permittedFuel.add(each);
        }*/

        permittedFuel.addAll(Arrays.asList(fuels));
    }

    abstract void refuel(Fuel fuel);

    abstract void accelerate();

    abstract void brake();
}

interface Fuelable {
    void refuel();

    private void go() {

    }

    default void print() {

    }
}

class Gasoline implements Fuelable {
    @Override
    public void refuel() {
        System.out.println("Refuel gasoline");
    }



}

class Electricity implements Fuelable {
    @Override
    public void refuel() {
        System.out.println("Refuel electricity");
    }
}

/*
* public a(
*   b(5)
* )
*
* private b(int r)
* */
