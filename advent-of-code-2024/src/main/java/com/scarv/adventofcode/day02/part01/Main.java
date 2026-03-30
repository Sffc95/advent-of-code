package com.scarv.adventofcode.day02.part01;

import com.scarv.adventofcode.common.IOWrapper;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {


    private static final String INPUT_FILE_PATH = "src/main/resources/day-02/input.txt";


    public static void main(String[] args) {

        long result = IOWrapper.streamFile(INPUT_FILE_PATH)
                .map(Main::convertToValues)
                .filter(compliantAllRules)
                .count();

        System.out.printf("There are %d valid reports%n", result);

    }

    private static Integer[] convertToValues(String valuesAsString) {
        return Arrays.stream(valuesAsString.split(" "))
                .map(Integer::valueOf)
                .toList()
                .toArray(Integer[]::new);
    }

    private static final Predicate<Integer[]> rule01 = levels -> {
        int initialDiff = levels[1] - levels[0];

        boolean shouldIncrease = initialDiff > 0;

        return IntStream.range(0, levels.length - 1)
                .allMatch(i -> {
                    int diff = levels[i+1] - levels[i];
                    return shouldIncrease ? diff > 0 : diff < 0;
                });
    };

    private static final Predicate<Integer[]> rule02 = levels ->
            IntStream.range(0, levels.length - 1)
                    .map(i -> Math.abs(levels[i] - levels[i + 1]))
                    .allMatch(diff -> diff >= 1 && diff <= 3);

    private static final List<Predicate<Integer[]>> ALL_RULES = Arrays.asList(
            rule01, rule02
    );

    private static final Predicate<Integer[]> compliantAllRules = ALL_RULES.stream()
            .reduce(p -> true, Predicate::and);

}
