package com.knubisoft.tasks.algorithm.charsinstring;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharsInStringImpl implements CharsInString {
    @Override
    public Map<Character, Integer> charactersCount(String text) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                map.merge(c, 1, Integer::sum);
                /*if (map.get(c) == null) {
                map.put(c, 1);
                } else map.put(c, map.get(c) + 1);*/
            }
        }
        return map;
    }
}
