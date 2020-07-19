package ua.i.mail100.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryNodeTest {
    CategoryNode categoryNodeOne;
    CategoryNode categoryNodeTwo;
    CategoryNode categoryNodeThree;
    CategoryNode categoryNodeFour;
    CategoryNode categoryNodeFive;
    CategoryNode categoryNodeSix;
    CategoryNode categoryNodeSeven;

    @BeforeEach
    void setUp() {
        categoryNodeOne = new CategoryNode(Category.PHONES_AND_OTHER, null);
        categoryNodeTwo = new CategoryNode(Category.PHONES, categoryNodeOne);
        categoryNodeThree = new CategoryNode(Category.CHARGE, categoryNodeTwo);
        categoryNodeFour = new CategoryNode(Category.RADIO, null);
        categoryNodeFive = new CategoryNode(Category.TV, null);
        categoryNodeSix = new CategoryNode(Category.REMOTE_CONTROLS, categoryNodeFive);
        categoryNodeSeven = new CategoryNode(Category.BATTERY, null);

    }

    @Test
    void toStringTest() {
        String expectedOne = "PHONES_AND_OTHER/PHONES/CHARGE";
        assertEquals(expectedOne, categoryNodeThree.toString());

        String expectedTwo = "TV";
        assertEquals(expectedTwo, categoryNodeFive.toString());
    }

    @Test
    void getParentCategoryList2() {
        categoryNodeThree.getParentCategoryList2();
    }

    @Test
    void isChild() {
        assertTrue(CategoryNode.isChild(categoryNodeThree, categoryNodeTwo));
        assertTrue(CategoryNode.isChild(categoryNodeThree, categoryNodeOne));
        assertFalse(CategoryNode.isChild(categoryNodeThree, categoryNodeThree));
        assertFalse(CategoryNode.isChild(categoryNodeThree, categoryNodeSeven));
    }

    @Test
    void isChild2() {
        assertTrue(categoryNodeThree.isChild2(categoryNodeTwo));
        assertTrue(categoryNodeThree.isChild2(categoryNodeOne));
        assertFalse(categoryNodeThree.isChild2(categoryNodeThree));
        assertFalse(categoryNodeThree.isChild2(categoryNodeSeven));
    }
}