package com.scarv.adventofcode.day03.part01;

import com.scarv.adventofcode.common.IOWrapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main  {

    private static final String INPUT_FILE_PATH = "src/main/resources/day-03/input.txt";

    private static final Pattern acceptedPattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");

    public static void main(String[] args) {


        Stream<String> inputStream = IOWrapper.streamFile(INPUT_FILE_PATH);

        long result = inputStream
                .flatMap(input -> acceptedPattern.matcher(input)
                .results())
                .mapToLong(match -> {
                    int left = Integer.parseInt(match.group(1));
                    int right = Integer.parseInt(match.group(2));
                    return mul(left, right);
                })
                .sum();

        System.out.printf("The computed operation equals to: %s", result);

    }

    private static int mul(int left, int right) {
        return Math.multiplyExact(left, right);
    }

}
