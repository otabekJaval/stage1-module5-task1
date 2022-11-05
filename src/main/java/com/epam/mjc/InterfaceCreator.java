package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> strings.
                stream()
                .allMatch(string -> Character.isUpperCase(string.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            int size = list.size();

            for (int i = 0; i < size; i++) {
                if (list.get(i) % 2 == 0)
                    list.add(list.get(i));
            }
        };

    }

    public Supplier<List<String>> filterCollection(List<String> values) {

        return () -> values.stream()
                .filter(value -> Character.isUpperCase(value.charAt(0)) &&
                        value.endsWith(".") && value.split(" ").length > 3)
                .toList();

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {

        return strings -> {

            Map<String, Integer> res = new HashMap<>();

            for (String string : strings) {
                res.put(string, string.length());
            }
            return res;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {

        return (list, list2) -> {

            List<Integer> list3 = new ArrayList<>();
            list3.addAll(list);
            list3.addAll(list2);
            return list3;

        };
    }
}
