package com.knubisoft.tasks.algorithm.fibonacci;

public class FibonacciImpl implements Fibonacci {
    @Override
    public int generateNFibonacciSequence(int n) {
        if (n < 2) {
            return 0;
        }
        int firstVal = 1, secondVal = 2, sum = 3;
        for (int i = 2; i < n; i++){
            sum = firstVal + secondVal;
            firstVal = secondVal;
            secondVal = sum;
        }
        return sum;
    }
}
