package com.knubisoft.tasks.algorithm.search;

import java.util.Arrays;

public class SearchImpl implements Search {
    @Override
    public int binarySearch(long[] array, long v) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        return binSearch(array, v, 0);
    }

    private int binSearch(long[] array, long v, int indexOffset) {
        if (array.length == 1 && array[0] != v) {
            return -1;
        } else {
            int midIndex = array.length / 2;
            long midValue = array[midIndex];
            if (midValue < v) {
                return binSearch(Arrays.copyOfRange(array, midIndex, array.length), v, indexOffset + midIndex);
            } else if (midValue > v) {
                return binSearch(Arrays.copyOfRange(array, 0, midIndex), v, indexOffset);
            } else {
                return midIndex + indexOffset;
            }
        }
    }
}
