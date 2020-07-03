package ua.i.mail100.vihicles;

public class WrongFuelExeption extends Exception {
    @Override
    public String getMessage(){
        return "Wrong fuel type";
    }
}
