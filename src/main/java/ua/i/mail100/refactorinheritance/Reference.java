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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getUpdated() {
        return isUpdated;
    }

    public void setUpdated(Boolean updated) {
        isUpdated = updated;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
