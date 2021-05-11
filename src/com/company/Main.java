package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Master changes");
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        UnaryOperator<Integer> squareFunction = i -> i * i;
        int num = 2;

        System.out.println("Square of " + num + " is: " + squareFunction.apply(num));

        String reducedList = topNames2015.stream()
                .map(s -> new StringBuilder(s).replace(0, 1, s.substring(0, 1).toUpperCase()).toString())
                .peek(System.out::println)
                .reduce("All names list: ", (s1, s2) -> s1 + ", " + s2);
        System.out.println(reducedList);
    }

    public static String everySecondCharacter(Function<String, String> function, String input) {
        return function.apply(input);
    }
}
