package com.knubisoft.base.pattern;

import java.util.regex.Pattern;

public class PatternTasksImpl implements PatternTasks {

    @Override
    public boolean haveSetOfCharacters(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return text.matches("[\\w&&[^_]]+");
    }

    @Override
    public String matchByCharacters(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        return text.matches("pq*") ? "Found a match!" : "Not matched!";
    }

    @Override
    public String matchStartAndEnd(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        return text.matches(".+g\\w+") ? "Found a match!" : "Not matched!";
    }

    @Override
    public String matchIpAddress(String text) {
        if (text == null || text.trim().isEmpty()) throw new IllegalArgumentException();
        return text.replaceAll("(\\.0+)", ".").replaceFirst("^0+", "");
    }

    @Override
    public String matchVowels(String text) {
        if (text == null || text.trim().isEmpty()) throw new IllegalArgumentException();
        return text.replaceAll("[AaEeIiOoUu]", "");
    }

    @Override
    public boolean validatePIN(String text) {
        if (text == null || text.trim().isEmpty()) throw new IllegalArgumentException();
        return text.matches("\\d{4}|\\d{6}|\\d{8}");
    }

    @Override
    public String divideDigit(int digit) {
        return String.valueOf(digit).replaceAll("0{3}$", "#000");
    }

    @Override
    public String removeAllNonAlphanumericCharacters(String text) {
        return text.replaceAll("\\W", "");
    }

    @Override
    public boolean validatePhoneNumber(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return text.matches("\\d{10}|\\(\\d{3}\\)\\d{7}|\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)\\d{3}-\\d{4}");
    }

    @Override
    public String getLastVowelsByConstraint(String text, int n) {
        if (n == 0) throw new RuntimeException();
        text = text.replaceAll("[^AaEeIiOoUu]", "");
        return text.substring(text.length() - n);
    }

    @Override
    public boolean isMathematicalExpression(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return text.matches("(\\d+ [+\\-*/] \\d+)|(^\\d+$)");
    }

    @Override
    public String insertDash(String text) {
        return text.replaceAll("([A-Z](?=[a-z]))", "$1-");
    }
}
