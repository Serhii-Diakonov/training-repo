package com.knubisoft.base.arrays;

import java.util.*;

public class ArraysTasksImpl implements ArraysTasks {
    @Override
    public int[] reverse(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - i - 1];
        }
        return reversed;
    }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] output = new int[array1.length + array2.length];
        int[] buf = array1;
        for (int i = 0, j = 0; i < output.length; i++, j++) {
            if (i == array1.length) {
                buf = array2;
                j = 0;
            }
            output[i] = buf[j];
        }
        return output;
        /*
        * Second implementation with arraycopy method
        *
        int[] output = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, output, 0, array1.length);
        System.arraycopy(array2, 0, output, array1.length, array2.length);
        return output;
        */
    }

    @Override
    public int[] findMax3InArray(int[] array) {
        if (array.length < 3)
            return array;
        else {
            Arrays.sort(array);
            int[] sorted = reverse(array);
            return new int[]{sorted[0], sorted[1], sorted[2]};
        }
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {
        int longestCounter = 0, counter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) counter++;
            else {
                if (longestCounter < ++counter) longestCounter = counter;
                counter = 0;
            }
        }
        if (counter != 0) longestCounter = ++counter;
        return longestCounter;
    }

    @Override
    public int sumOfAllUniqueElements(int[] array) {
        /*
        * Short solution with Stream API
        *
        if (containsDuplicate(array))
            return Arrays.stream(Arrays.stream(array).distinct().toArray()).sum();
        return Arrays.stream(array).sum();
        * */

        int sum = 0, i = 0, lastVal = 0;
        if (array != null && array.length > 0) {
            int[] distinct = new int[array.length];
            for (int a : array) {
                for (int d : distinct) {
                    if (d == a) break;
                    else if (lastVal == d && i < distinct.length) {
                        lastVal = distinct[i];
                        distinct[i++] = a;
                        break;
                    }
                }
            }
            for (int d : distinct) {
                sum += d;
            }
        }
        return sum;
    }

    @Override
    public int[] moveZeroes(int[] array) {
        /*
        * Solution with Stream API
        *
        int [] withoutZeros = Arrays.stream(array).filter(x -> x != 0).toArray();
        int [] zeros = Arrays.stream(array).filter(x -> x == 0).toArray();
        return mergeArrays(withoutZeros, zeros);
        *
        * */

        int shift = 0, notZeroValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                shift++;
            } else {
                array[i - shift] = array[i];
                notZeroValue++;
            }
        }
        for (int i = notZeroValue; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }

    @Override
    public int findFinalValue(int[] nums, int original) {
        if (nums != null && nums.length != 0) {
            boolean found = true;
            while (found) {
                for (int n : nums) {
                    if (n == original) {
                        original *= 2;
                        found = true;
                        break;
                    } else found = false;
                }
            }
        }
        return original;

        /*
        *
        * Second solution. It's short and uses methods of Arrays util class
        *
        if (nums != null && nums.length != 0) {
            Arrays.sort(nums);
            while (Arrays.binarySearch(nums, original) >= 0 && Arrays.binarySearch(nums, original) < nums.length) {
                original *= 2;
            }
        }
        return original;
        */
    }

    @Override
    public String longestCommonPrefix(String[] words) {
        if (words.length == 0) return "";
        String commonPrefix = words[0];
        for (int i = 1; i < words.length; i++) {
            while (!words[i].startsWith(commonPrefix)) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
        }
        return commonPrefix;
    }

    @Override
    public int missingNumber(int[] array) {
        OptionalInt min = Arrays.stream(array).min();
        OptionalInt max = Arrays.stream(array).max();
        Arrays.sort(array);
        if (min.isPresent() && max.isPresent()) {
            int minVal = min.getAsInt();
            int maxVal = max.getAsInt();
            if (minVal != 0) return 0;
            else if (minVal + 1 == maxVal)
                return maxVal + 1;
            else {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] != minVal + i)
                        return minVal + i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean containsDuplicate(int[] array) {
        /*
        *   Short solution with Stream API
        return !Arrays.equals(array, Arrays.stream(array).distinct().toArray());
        *
        * */

        int[] distinct = new int[array.length];
        int i = 0;
        for (int a : array) {
            for (int d : distinct) {
                if (a == d) return true;
                else if (i < distinct.length - 1) {
                    distinct[i++] = a;
                    break;
                }
            }
        }
        return false;
    }
}
