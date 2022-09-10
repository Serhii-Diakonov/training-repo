package com.knubisoft.base.string;

import com.ctc.wstx.util.StringUtil;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringTasksImpl implements StringTasks {

    @Override
    public String reverseString(String original) {
        if (original == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder builder = new StringBuilder(original);
        return builder.reverse().toString();
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        if (original == null || toInsert == null || original.isEmpty() || toInsert.isEmpty()) {
            throw new IllegalArgumentException();
        }
        StringBuilder builder = new StringBuilder(original);
        return builder.insert(original.length() / 2, toInsert.replace("\r", "")).toString();
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        if (original == null || position > original.length() - 1 || position < 0)
            throw new IllegalArgumentException();
        StringBuilder builder = new StringBuilder(original);
        return builder.insert(position, toInsert).toString();
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        if (original == null || original.toString().isEmpty() || toAppend == null || toAppend.isEmpty())
            throw new NoSuchElementException();
        return original.append(toAppend).toString();
    }

    @Override
    public boolean isPalindrome(String palindrome) {
        return new StringBuilder(palindrome).reverse().toString().equals(palindrome);
    }

    @Override
    public boolean hasLowerCase(String str) {
        if (str == null) throw new IllegalArgumentException();
        return str.equals(str.toLowerCase());
    }

    @Override
    public String uniqueCharacters(String str) {
        if (str == null) throw new IllegalArgumentException();
        StringBuilder unique = new StringBuilder();
        str = str.toLowerCase();
        for (char c : str.toCharArray()) {
            if (str.indexOf(c, str.indexOf(c) + 1) == -1) unique.append(c);
        }
        return unique.toString();
    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
        if (str == null || str.isEmpty()) throw new IllegalArgumentException();
        return str.replace(String.valueOf(charToRemove), "");
    }

    @Override
    public String toCamelCase(String str) {
        if (str == null || str.isEmpty()) throw new IllegalArgumentException();
        StringBuilder builder = new StringBuilder();
        int offset = 32;
        String[] array = str.split("-|_| ");
        builder.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            char[] chars = array[i].toCharArray();
            if (chars[0] > 97)
                chars[0] -= offset;
            builder.append(String.valueOf(chars));
        }
        return builder.toString();
    }

    @Override
    public String getCountRepeatableString(String str) {
        if (str == null) throw new IllegalArgumentException();
        char character;
        int counter;
        char[] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            character = chars[i];
            counter = 0;
            for (int j = i; j < chars.length; j++) {
                if (chars[j] == character) {
                    if (counter == 9) counter = 1;
                    else counter++;
                    builder.append(counter);
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        if (str == null) throw new IllegalArgumentException();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
