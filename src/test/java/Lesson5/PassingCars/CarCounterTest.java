package Lesson5.PassingCars;

import common.exceptions.ArraySizeException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Lesson5.PassingCars.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarCounterTest {

    private void assertArraySize(List<Direction> array) {
        Exception thrown = assertThrows(
                ArraySizeException.class,
                () -> new CarCounter(new ArrayList<>(array))
        );
        assertEquals("Array size out of range!", thrown.getMessage());
    }

    @Test
    void emptyArray() {
        assertArraySize(new ArrayList<>());
    }

    @Test
    void tooLargeArray() {
        assertArraySize(Collections.nCopies(100001, RIGHT));
    }

    @Test
    void onlyOneCarTest() {
        assertEquals(0, new CarCounter(new ArrayList<>(List.of(RIGHT))).count());
    }

    @Test
    void twoCarSameDirTest() {
        assertEquals(0, new CarCounter(new ArrayList<>(Arrays.asList(RIGHT, RIGHT))).count());
    }

    @Test
    void twoApprCarsTest() {
        assertEquals(1, new CarCounter(new ArrayList<>(Arrays.asList(RIGHT, LEFT))).count());
    }

    @Test
    void someCarsTest() {
        assertEquals(6, new CarCounter(new ArrayList<>(Arrays.asList(RIGHT, LEFT, LEFT, RIGHT, LEFT, LEFT))).count());
    }

    @Test
    void exampleTest() {
        assertEquals(5, new CarCounter(new ArrayList<>(Arrays.asList(RIGHT, LEFT, RIGHT, LEFT, LEFT))).count());
    }
}
