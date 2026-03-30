package com.scarv.adventofcode.day03.part02;

import com.scarv.adventofcode.common.IOWrapper;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    private static final String INPUT_FILE_PATH = "src/main/resources/day-03/input.txt";

    private static final Pattern acceptedPattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)");


    public static void main(String[] args) {


        Stream<String> inputStream = IOWrapper.streamFile(INPUT_FILE_PATH);

        boolean enabled = true;
        int result = 0;

        List<MatchResult> results = inputStream
                .flatMap(input -> acceptedPattern.matcher(input)
                .results())
                .toList();


        for (MatchResult match : results) {
            final String operation = match.group(0);

            switch (operation){
                case "do()":
                    enabled = true;
                    continue;
                case "don't()":
                    enabled = false;
                    continue;
                default:
                    if (!enabled) continue;
                    int left = Integer.parseInt(match.group(1));
                    int right = Integer.parseInt(match.group(2));
                    result += mul(left, right);

            }
        }

        System.out.printf("The computed operation equals to: %s", result);

    }

    private static int mul(int left, int right) {
        return Math.multiplyExact(left, right);
    }

}
