package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class IterableProcessor {

    public static <T> Iterable<T> filter(Iterable<T> unfiltered, Predicate<? super T> retainIfTrue) {
        List<T> result = new LinkedList<>();
        for (T temp: unfiltered) {
            if (retainIfTrue.test(temp))
                result.add(temp);
        }
        return result;
    }
    public static <F, T> Iterable<T> transform(Iterable<F> fromIterable, Function<? super F, ? extends T> function)
    {
        List<T> result = new LinkedList<>();
        for (F temp: fromIterable)
            result.add(function.apply(temp));
        return result;
    }
}
