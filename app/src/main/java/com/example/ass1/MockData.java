package com.example.ass1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MockData {
    private static final int NUM_PROBLEMS = 5;
    private static final int MAX_NUM = 10;
    private static final Random random = new Random();

    public static List<MathProblem> getMathProblems() {
        List<MathProblem> problems = new ArrayList<>();

        for (int i = 0; i < NUM_PROBLEMS; i++) {
            int num1 = random.nextInt(MAX_NUM + 1);
            int num2 = random.nextInt(MAX_NUM + 1);
            String problem = String.format("%d + %d =", num1, num2);
            int solution = num1 + num2;

            List<String> options = new ArrayList<>();
            options.add(String.valueOf(solution));
            while (options.size() < 4) {
                int incorrect = random.nextInt(MAX_NUM * 2 + 1);
                if (incorrect != solution && !options.contains(String.valueOf(incorrect))) {
                    options.add(String.valueOf(incorrect));
                }
            }
            Collections.shuffle(options);
            problems.add(new MathProblem(problem, String.valueOf(solution), options));
        }

        return problems;
    }
}

