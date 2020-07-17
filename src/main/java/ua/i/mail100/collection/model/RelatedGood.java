package ua.i.mail100.collection.model;

public class RelatedGood{
    private Good good;
    private Good parent;

    public RelatedGood(Good good, Good parent) {
        this.good = good;
        this.parent = parent;
    }
}
