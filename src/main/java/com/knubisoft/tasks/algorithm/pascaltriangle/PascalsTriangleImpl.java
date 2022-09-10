package com.knubisoft.tasks.algorithm.pascaltriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleImpl implements PascalsTriangle {

    @Override
    public List<Integer> calculateLineOfPascalsTriangle(int lineNumber) {
        List<Integer> prevLine = null, line;
        if (lineNumber < 1) {
            return Collections.emptyList();
        } else {
            line = new ArrayList<>();
            for (int i = 0; i < lineNumber; i++) {
                if (i == 0 || i == lineNumber - 1) {
                    line.add(1);
                } else {
                    if(i == 1){
                        prevLine = calculateLineOfPascalsTriangle(lineNumber - 1);
                    }
                    line.add(i, prevLine.get(i) + prevLine.get(i - 1));
                }
            }
            return line;
        }
    }
}
