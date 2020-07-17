package ua.i.mail100.collection.model;

import java.util.LinkedList;

public class CategoryNode {
    Category category;
    CategoryNode parent;

    public CategoryNode(Category category, CategoryNode parent) {
        this.category = category;
        this.parent = parent;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<Category> linkedList = tree(this);

        for (int i = linkedList.size() - 1; i >= 0; i--) {
            stringBuilder.append(linkedList.get(i));
            if (i != 0) {
                stringBuilder.append("/");
            }
        }
        return stringBuilder.toString();
    }

    private static LinkedList<Category> tree(CategoryNode node) {
        LinkedList<Category> linkedList = new LinkedList<>();
        CategoryNode current = node;
        linkedList.add(current.category);

        while (current.parent != null) {
            current = current.parent;
            linkedList.add(current.category);
        }
        return linkedList;
    }

    public static boolean isChild(CategoryNode node, CategoryNode parentNode) {
        CategoryNode current = node;

        while (current.parent != null) {
            if(parentNode == current.parent) return true;
            current = current.parent;
        }
        return false;
    }

}
