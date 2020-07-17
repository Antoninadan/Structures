package ua.i.mail100.refactorinheritance;

import java.util.List;

public class BookReference extends Reference {
    private int countOfpages;

    public BookReference(List<Author> authors, String name, Boolean isUpdated, int year, int volume, int countOfpages) {
        super(authors, name, isUpdated, year, volume);
        this.countOfpages = countOfpages;
    }

    @Override
    public void processing(Reference reference) {
        System.out.println("do with book reference");
    }
}
