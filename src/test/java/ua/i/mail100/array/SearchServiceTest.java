package ua.i.mail100.array;

import org.junit.jupiter.api.Test;
import ua.i.mail100.array.SearchService;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    @Test
    void linear() {
        int[] one = {1, 0, 70, 80, 400, 0, 0};
        assertEquals(1, SearchService.linear(one, 0));

        int[] two = {1, 0, 70, 80, 400, 0, 0};
        assertEquals(-1, SearchService.linear(two, 5));
    }
}