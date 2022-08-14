package com.knubisoft.base.numbers;

import java.math.BigInteger;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(IntWrapper firstNumber, IntWrapper secondNumber) {
        if(firstNumber == null || secondNumber == null)
            throw  new IllegalArgumentException();
        secondNumber.setValue(secondNumber.getValue() + firstNumber.getValue());
        firstNumber.setValue(secondNumber.getValue() - firstNumber.getValue());
        secondNumber.setValue(secondNumber.getValue() - firstNumber.getValue());
    }

    @Override
    public boolean isUglyInt(int number) {
        if (number > 0 && number < 7 || number > 7 && number < 11) return true;
        if (number == 0) return false;
        if (number % 5 == 0) return isUglyInt(number / 5);
        if (number % 3 == 0) return isUglyInt(number / 3);
        if (number % 2 == 0) return isUglyInt(number / 2);
        return false;
    }

    @Override
    public int addDigits(int number) {
        if (number / 10 > 0) return addDigits(number % 10 + number / 10);
        return number;
    }

    @Override
    public boolean isHarshadNumber(int number) {
        if (number == 0) return false;
        int sum = 0;
        for (int i : getDigits(number)) {
            sum += i;
        }
        return number % sum == 0;
    }

    @Override
    public boolean isPrime(int number) {
        if (number != 3 && number <= 3571 && (number & 1) == 0) return false;
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        if (number < 10 && number > -1) return true;
        int[] digits = getDigits(number);
        int sumOfPowedDigits = 0;
        for (int d : digits) {
            sumOfPowedDigits += Math.pow(d, digits.length);
        }
        return sumOfPowedDigits == number;
    }

    @Override
    public BigInteger factorial(int number) {
//        return loopFactorial(number);
        if (number == 0) return BigInteger.ONE;
        return BigInteger.valueOf(number).multiply(factorial(number - 1));
    }

    private BigInteger loopFactorial(int number) {
        BigInteger res = BigInteger.ONE;
        for (; number > 0; number--) {
            res = res.multiply(BigInteger.valueOf(number));
        }
        return res;
    }

    @Override
    public boolean palindrome(int number) {
//        return palindromeCheckWithStrings(number);
        return palindromeCheckWithLoop(number);
    }

    private boolean palindromeCheckWithLoop(int number) {
        int[] ar = getDigits(number);
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != ar[ar.length - i - 1]) return false;
        }
        return true;
    }

    private boolean palindromeCheckWithStrings(int number) {
        String palindrome = String.valueOf(number);
        String firstPart = palindrome.substring(0, palindrome.length() / 2);
        StringBuilder secondPart;
        if (palindrome.length() % 2 == 0)
            secondPart = new StringBuilder(palindrome.substring(palindrome.length() / 2));
        else secondPart = new StringBuilder(palindrome.substring(palindrome.length() / 2 + 1));
        return firstPart.equals(secondPart.reverse().toString());
    }

    @Override
    public boolean isAutomorphic(int number) {
        int i = 10;
        while (i < number) i *= 10;
        return Math.pow(number, 2) % i == number;
    }

    private int[] getDigits(int num) {
        int numberOfDigits = 1;
        long decimalPlace = 10;
        while (num > decimalPlace) {
            numberOfDigits++;
            decimalPlace *= 10;
        }
        int[] digitsReversed = new int[numberOfDigits];
        for (int i = 0; i < numberOfDigits; i++) {
            digitsReversed[i] = num % 10;
            num /= 10;
        }
        return digitsReversed;
    }
}
