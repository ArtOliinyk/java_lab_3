package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IterableProcessorTest {

    private IterableProcessor iterableProcessor;

    @BeforeEach
    public void setUp() {
        iterableProcessor = new IterableProcessor();
    }

    @Test
    void filter_integer() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        expected.add(4);
        List<Integer> testData = new ArrayList<>();
        testData.add(2);
        testData.add(3);
        testData.add(4);
        testData.add(5);
        testData.add(6);
        Iterable<Integer> actual = IterableProcessor.filter(testData, integer -> integer < 5);
        assertEquals(expected, actual);
    }

    @Test
    void filter_string() {
        List<String> expected = new ArrayList<>();
        expected.add("abt");
        expected.add("bfni");
        List<String> testData = new ArrayList<>();
        testData.add("abt");
        testData.add("bfni");
        testData.add("hsrstoh");
        testData.add("ergpieaoprg");
        Iterable<String> actual = IterableProcessor.filter(testData, string -> string.length() < 5);
        assertEquals(expected, actual);
    }

    @Test
    void filter_character() {
        List<Character> expected = new ArrayList<>();
        expected.add('a');
        expected.add('b');
        expected.add('a');
        List<Character> testData = new ArrayList<>();
        testData.add('a');
        testData.add('b');
        testData.add('c');
        testData.add('d');
        testData.add('e');
        testData.add('a');
        Iterable<Character> actual = IterableProcessor.filter(testData, character -> character == 'a' | character  == 'b');
        assertEquals(expected, actual);
    }

    @Test
    void filter_double() {
        List<Double> expected = new ArrayList<>();
        expected.add(3.22);
        expected.add(4.04);
        List<Double> testData = new ArrayList<>();
        testData.add(3.22);
        testData.add(4.04);
        testData.add(5.02);
        Iterable<Double> actual = IterableProcessor.filter(testData, doublePrecision -> doublePrecision < 5);
        assertEquals(expected, actual);
    }

    @Test
    void transform_integer() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(6);
        List<Integer> testData = new ArrayList<>();
        testData.add(1);
        testData.add(2);
        testData.add(3);
        Iterable<Integer> actual = IterableProcessor.transform(testData, integer -> integer * 2);
        assertEquals(expected, actual);
    }

    @Test
    void transform_string() {
        List<String> expected = new ArrayList<>();
        expected.add("bt");
        expected.add("fni");
        expected.add("srstoh");
        expected.add("rgpieaoprg");
        List<String> testData = new ArrayList<>();
        testData.add("abt");
        testData.add("bfni");
        testData.add("hsrstoh");
        testData.add("ergpieaoprg");
        Iterable<String> actual = IterableProcessor.transform(testData, string -> string.substring(1));
        assertEquals(expected, actual);
    }

    @Test
    void transform_character() {
        List<Character> expected = new ArrayList<>();
        expected.add('A');
        expected.add('b');
        expected.add('c');
        expected.add('d');
        expected.add('e');
        expected.add('A');
        List<Character> testData = new ArrayList<>();
        testData.add('a');
        testData.add('b');
        testData.add('c');
        testData.add('d');
        testData.add('e');
        testData.add('a');
        Iterable<Character> actual = IterableProcessor.transform(testData, character -> {
            if (character == 'a') {
                return 'A';
            }
            return character; });
        assertEquals(expected, actual);
    }

    @Test
    void transform_double() {
        List<Double> expected = new ArrayList<>();
        expected.add(6.44);
        expected.add(8.08);
        expected.add(10.04);
        List<Double> testData = new ArrayList<>();
        testData.add(3.22);
        testData.add(4.04);
        testData.add(5.02);
        Iterable<Double> actual = IterableProcessor.transform(testData, doublePrecision -> doublePrecision * 2);
        assertEquals(expected, actual);
    }
}