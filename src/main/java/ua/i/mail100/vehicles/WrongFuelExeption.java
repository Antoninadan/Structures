package ua.i.mail100.vehicles;

public class WrongFuelExeption extends Exception {
    @Override
    public String getMessage(){
        return "Wrong fuel type";
    }
}
