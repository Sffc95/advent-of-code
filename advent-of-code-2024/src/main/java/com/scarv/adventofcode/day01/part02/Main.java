package com.scarv.adventofcode.day01.part02;

import com.scarv.adventofcode.common.IOWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static final String INPUT_FILE_PATH = "advent-of-code-2024/src/main/resources/day-01/input.txt";


    public static void main(String[] args) {

        ArrayList<Integer> listLeft = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (String s : IOWrapper.readFile(INPUT_FILE_PATH)) {
            String[] arr = s.split("\\s+");

            listLeft.add(Integer.parseInt(arr[0]));
            final int rightListKey = Integer.parseInt(arr[1]);

            if(map.containsKey(rightListKey)) {
                map.replace(rightListKey, map.get(rightListKey) + 1);
            } else {
                map.put(rightListKey, 1);
            }

        }

        int result = listLeft.stream()
                .map(i -> i * map.getOrDefault(i, 0))
                .mapToInt(Integer::intValue)
                .sum();

        //Should be 21790168
        System.out.println("Result = " + result);
    }
}
