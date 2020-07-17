package ua.i.mail100.refactorinheritance;

import java.util.List;

public abstract class Reference {
    private List<Author> authors;
    private String name;
    private Boolean isUpdated;
    private int year;
    private int volume;

    public Reference() {
    }

    public Reference(List<Author> authors, String name, Boolean isUpdated, int year, int volume) {
        this.authors = authors;
        this.name = name;
        this.isUpdated = isUpdated;
        this.year = year;
        this.volume = volume;
    }

    public abstract void processing(Reference reference);

}
