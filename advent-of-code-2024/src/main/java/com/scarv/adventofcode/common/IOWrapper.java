package com.scarv.adventofcode.common;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * A utility class for common I/O operations.
 */
public class IOWrapper {

    /**
     * Reads the contents of a file line by line and returns it as an {@code Iterable<String>}.
     *
     * @param filePath the path to the file to be read.
     * @return an {@code Iterable<String>} containing the lines of the file in the order they appear.
     * @throws RuntimeException if the file is not found or an I/O error occurs during reading.
     */
    public static Iterable<String> readFile(String filePath) {
        File file = new File(filePath);
        LinkedList<String> list = new LinkedList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file));) {
            String line;

            // Read each line of the file and add it to the list
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            return list;
        } catch (FileNotFoundException e) {
            // Throw a RuntimeException if the file is not found
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Throw a RuntimeException for other I/O errors
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads the contents of a file line by line and returns it as a {@code Stream<String>}.
     *
     * @param filePath the path to the file to be read.
     * @return a {@code Stream<String>} containing the lines of the file in the order they appear.
     * @throws UncheckedIOException if the file is not found or an I/O error occurs during reading.
     */
    public static Stream<String> streamFile(String filePath) {
        try {
            return Files.lines(Path.of(filePath));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
