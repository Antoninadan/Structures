package ua.i.mail100.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class CategoryNode {
    private Category category;
    private CategoryNode parent;

    public CategoryNode(Category category, CategoryNode parent) {
        this.category = category;
        this.parent = parent;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<Category> linkedList = getParentCategoryList();

        for (int i = linkedList.size() - 1; i > 0; i--) {
            builder.append(linkedList.get(i)).append("/");
        }

        IntStream
                .of(1, linkedList.size())
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach(i -> {
                    builder.append(linkedList.get(i)).append("/");
                });

        IntStream
                .of(1, linkedList.size())
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(linkedList::get)
                .forEach(i -> {
                    builder.append(i).append("/");
                });

        builder.append(linkedList.get(0));

        return builder.toString();
    }


    public List<Category> getParentCategoryList() {
        List<Category> linkedList = new LinkedList<>();
        CategoryNode current = this;
        linkedList.add(category);

        while (current.parent != null) {
            current = current.parent;
            linkedList.add(current.category);
        }
        return linkedList;
    }



    public boolean isChild(CategoryNode parentNode) {
        CategoryNode current = this;

        while (current.parent != null) {
            if (parentNode == current.parent) return true;
            current = current.parent;
        }
        return false;
    }

}
