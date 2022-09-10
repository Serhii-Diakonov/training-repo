package com.knubisoft.base.list;

import java.util.*;
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
        List<String> res = new ArrayList<>();
        for (int i : indexes) {
            if (i < 0 || i > indexes.length) throw new IllegalArgumentException();
            res.add(elements.get(i));
        }
        return res;
    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        if (indexes == null || elements == null) throw new IllegalArgumentException();
        for (int i : indexes) {
            if (i < 0 || i >= elements.size()) throw new IllegalArgumentException();
            elements.add(elements.get(i));
        }
        return elements;
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes, LinkedList<String> values) {
        if (indexes == null || elements == null || values == null || indexes.length != values.size())
            throw new IllegalArgumentException();
        int j = 0;
        for (int i : indexes) {
            if (i < 0 || i >= elements.size()) throw new IllegalArgumentException();
            elements.set(i, values.get(j++));
        }
        return elements;
    }

    @Override
    public int getListSize(List<String> list) {
        if (list == null) return 0;
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
        return mergeIntLists(first, second, third).stream().max(Integer::compareTo).get();
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        return mergeIntLists(first, second, third).stream().min(Integer::compareTo).get();
    }

    private List<Integer> mergeIntLists(List<Integer>... lists) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> l : lists) {
            if (l == null || l.isEmpty()) throw new RuntimeException("List cannot be null or empty");
            result.addAll(l);
        }
        return result;
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        List<Integer> list = mergeIntLists(first, second, third);
        int max1 = list.stream().max(Integer::compareTo).get();
        list.remove((Object) max1);
        return max1 * list.stream().max(Integer::compareTo).get();
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
        if (list == null) throw new NoSuchElementException();
        List<Integer> finList = new ArrayList<>();
        for (List<Integer> l : list)
            if (l != null)
                finList.addAll(l.stream().filter(Objects::nonNull).collect(Collectors.toList()));
        return finList;
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
        return myOwnShuffle(originalStrings);
//        return shuffleUsingCollections(originalStrings);
    }

    private List<String> myOwnShuffle(List<String> originalStrings) {
        Random rand = new Random();
        List<String> newList = new ArrayList<>(originalStrings.size());
        for (String s : originalStrings) {
            newList.add(null);
        }
        int index;
        for (String s : originalStrings) {
            while (newList.get((index = rand.nextInt(originalStrings.size()))) != null) {
            }
            newList.set(index, s);
        }
        return newList;
    }

    private List<String> shuffleUsingCollections(List<String> originalStrings) {
        Collections.shuffle(originalStrings);
        return originalStrings;
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
