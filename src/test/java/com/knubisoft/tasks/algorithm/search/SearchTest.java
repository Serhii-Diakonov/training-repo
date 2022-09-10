package com.knubisoft.tasks.algorithm.search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchTest {

    private final Search search = new SearchImpl();

    @Test
    void searchSuccessful() {
        long[] array = {3, 1, 5, 10, 0, 122, -55, 12, 52, 12, 0, -4, -112, 999999, Long.MIN_VALUE, Long.MAX_VALUE, 1};
        long[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
        assertEquals(Arrays.binarySearch(sortedArray, 122),
                search.binarySearch(sortedArray, 122));
        assertEquals(Arrays.binarySearch(sortedArray, Long.MIN_VALUE),
                search.binarySearch(sortedArray, Long.MIN_VALUE));
        assertEquals(Arrays.binarySearch(sortedArray, Long.MAX_VALUE),
                search.binarySearch(sortedArray, Long.MAX_VALUE));
        assertEquals(Arrays.binarySearch(sortedArray, -55),
                search.binarySearch(sortedArray, -55));
        assertEquals(Arrays.binarySearch(sortedArray, 999999),
                search.binarySearch(sortedArray, 999999));
        assertEquals(4, search.binarySearch(sortedArray, 0));
        assertEquals(-1, search.binarySearch(sortedArray, -999999));
        assertEquals(-1, search.binarySearch(new long[1], -9));
        assertEquals(-1, search.binarySearch(new long[5], -9));
    }

    @Test
    void searchFailed() {
        assertThrows(IllegalArgumentException.class, () -> search.binarySearch(null, 12));
        assertThrows(IllegalArgumentException.class, () -> search.binarySearch(new long[0], 12));
    }
}
