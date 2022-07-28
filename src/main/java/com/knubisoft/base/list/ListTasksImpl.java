package com.knubisoft.base.list;

import java.util.*;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

public class ListTasksImpl implements ListTasks {
    @Override
    public List<String> addElements(String... elements) {
        List<String> list = new ArrayList<>();
        for (String s : elements) {
            list.add(s);
        }
        return list;

        /*
         * Solution with Arrays util class
         **/
        //return Arrays.asList(elements);
    }

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) {
        if (indexes == null || elements == null) throw new IllegalArgumentException();
        for (int i : indexes) {
            if (i < 0) throw new IllegalArgumentException();
            else elements.add(elements.get(i));
        }
        return elements;
    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        /*if (indexes == null || elements == null) throw new IllegalArgumentException();
        for (int i : indexes) {
            if (i < 0 || i >= elements.size()) throw new IllegalArgumentException();
            else elements.add(elements.get(i));
        }*/
        return elements;
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {
        return null;
    }

    @Override
    public int getListSize(List<String> list) {
        if(list == null) return 0;
        return list.size();
    }

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {
        List<Long> longList = new ArrayList<>();
        for (Integer i : first) {
            longList.add(i.longValue());
        }
        longList.addAll(second);
        for (String s : third) {
            try {
                if (s == null) throw new NullPointerException();
                longList.add(Long.valueOf(s));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException();
            }
        }
        return longList;
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        return -1;
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        return -1;
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        int max1, max2, max3;
        return -1;
    }

    @Override
    public List<String> removeNulls(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) list.remove(list.get(i));
        }
        return list;

        /*
        * Second solution
        *
        list.removeIf(Objects::isNull);
        return list;
        * */
    }

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {
        return null;
    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {
        if (originalIds == null) throw new NoSuchElementException();
        List<Integer> newList = new ArrayList<>();
        for (Integer i : originalIds) {
            if (i != null) newList.add(i);
        }
        return newList;

        /*
        * Solution with Stream API
        *
        if(originalIds == null) throw new NoSuchElementException();
        return originalIds.stream().filter(Objects::nonNull).collect(Collectors.toList());
        * */
    }

    @Override
    public List<String> shuffle(List<String> originalStrings) {
        return null;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {
        if (list == null) throw new NoSuchElementException();
        else if (list.isEmpty()) return "";
        return list.get(list.size() - 1);
    }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {
        if (originalCollection == null || additionalCollection == null) throw new IllegalArgumentException();
        List<String> commonList = new ArrayList<>();
        for (String s : originalCollection) {
            if (additionalCollection.contains(s))
                commonList.add(s);
        }
        return commonList;

        /*
        * Solution with Stream API
        *
        if(originalCollection == null || additionalCollection == null) throw new IllegalArgumentException();
        return originalCollection.stream().filter(additionalCollection::contains).collect(Collectors.toList());
        * */
    }
}
