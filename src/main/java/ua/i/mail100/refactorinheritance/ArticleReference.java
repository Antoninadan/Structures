package ua.i.mail100.refactorinheritance;

import java.util.List;

public class ArticleReference extends Reference {
    private int startPage;
    private int endPage;

    public ArticleReference(List<Author> authors, String name,
                            Boolean isUpdated, int year, int volume, int startPage, int endPage) {
        super(authors, name, isUpdated, year, volume);
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
