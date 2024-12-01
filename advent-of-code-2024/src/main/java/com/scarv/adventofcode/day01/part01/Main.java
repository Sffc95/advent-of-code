package com.scarv.adventofcode.day01.part01;

import com.scarv.adventofcode.common.IOWrapper;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static final String INPUT_FILE_PATH = "advent-of-code-2024/src/main/resources/day-01/input.txt";

    public static void main(String[] args) {

        ArrayList<Integer> listLeft = new ArrayList<>();
        ArrayList<Integer> listRight = new ArrayList<>();

        for (String s : IOWrapper.readFile(INPUT_FILE_PATH)) {
            String[] arr = s.split("\\s+");

            listLeft.add(Integer.parseInt(arr[0]));
            listRight.add(Integer.parseInt(arr[1]));

        }

        Collections.sort(listLeft);
        Collections.sort(listRight);

        int count = 0;
        for (int i = 0; i < listLeft.size(); i++) {
            count += Math.abs(listLeft.get(i) - listRight.get(i));
        }

        //This should be 1151792
        System.out.println("Result: " + count);

    }
}
