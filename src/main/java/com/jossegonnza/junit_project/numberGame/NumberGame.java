package com.jossegonnza.junit_project.numberGame;

import java.util.ArrayList;
import java.util.List;

public class NumberGame {
    public List<String> getNumbers() {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                numbers.add("FizzBuzz");
            } else if (i % 3 == 0) {
                numbers.add("Fizz");
            } else if (i % 5 == 0) {
                numbers.add("Buzz");
            } else {
                numbers.add("" + i);
            }
        }
        return numbers;
    }
}
