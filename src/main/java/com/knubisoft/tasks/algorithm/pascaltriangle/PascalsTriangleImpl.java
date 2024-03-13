package com.knubisoft.tasks.algorithm.pascaltriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleImpl implements PascalsTriangle {

    @Override
    public List<Integer> calculateLineOfPascalsTriangle(int lineNumber) {
        if (lineNumber < 1) {
            return Collections.emptyList();
        } else {
            List<Integer> previousRow = calculateLineOfPascalsTriangle(lineNumber - 1);
            List<Integer> currentRow = new ArrayList<>();
            for (int i = 0; i < lineNumber; i++) {
                if (i == 0 || i == lineNumber - 1) {
                    currentRow.add(1);
                } else {
                    currentRow.add(previousRow.get(i - 1) + previousRow.get(i));
                }
            }
            return currentRow;
        }
    }
}
