package com.knubisoft.tasks.algorithm.sorting;

import java.util.*;

public class SortImpl implements Sort {

    @Override
    public Map<Integer, List<Integer>> sortKeysAndValues(Map<Integer, List<Integer>> input) {
        SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        input.forEach((index, ints) -> {
            ints.sort(Integer::compareTo);
        });
        return sortedMap;
    }

}
