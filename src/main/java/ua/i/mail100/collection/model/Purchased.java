package ua.i.mail100.collection.model;

import java.util.Map;

public interface Purchased {
    int getTotalPrice(Map<Good, Integer> goods);
}
