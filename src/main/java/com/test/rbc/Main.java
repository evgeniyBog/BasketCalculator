package com.test.rbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Executable method. Two ways to execute:
 * 1. specifying file name: e.g.: -f test.txt
 * 2. List items basket in command line: Bananas Oranges Apple Peach
 *
 * Output - price of the items all items in the basket known to system
 * Otherwise "Unsupported item found" exception
 */
public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: use -f [FileName] to read basket from file, or pass basket as parameters");
            System.exit(-1);
        }
        BigDecimal price;
        String[] items;
        if ("-f".equalsIgnoreCase(args[0])) {
            items = readItemsFromFile(args[1]);
        } else {
            items = args;
        }

        try {
            price = BasketCalculator.calculate(items);
            System.out.println("Price of your basket: " + price);
        } catch (UnsupportedFruitTypeException e) {
            System.out.println("Unsupported item found");
            e.printStackTrace();
        }

    }

    /**
     * Helper method to read items from file
     *
     * @param fileName
     * @return Array of items from file
     */
    private static String[] readItemsFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.toArray(new String[0]);
    }
}
