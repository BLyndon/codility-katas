package Lesson4.FrogRiverOne;

import Lesson3.TapeEquilibrium.StreamEquilibriumDetective;
import common.exceptions.ArraySizeException;
import common.exceptions.ValueRangeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeTest {

    private void assertArraySize(List<Integer> array) {
        Exception thrown = assertThrows(ArraySizeException.class,
                ()-> new StreamEquilibriumDetective(array)
        );
        assertEquals("Array size out of range!", thrown.getMessage());
    }

    @Test
    void arrayTooSmall(){
        assertArraySize(List.of(1));
    }

    @Test
    void arrayTooLarge(){
        assertArraySize(Collections.nCopies(100001, 1));
    }

    @Test
    void valueRangeTest(){
        Exception thrown = assertThrows(ValueRangeException.class,
                () -> new Bridge(Arrays.asList(1, 3, 5, 2), 3)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @Test
    void unitLengthTest(){
        List<Integer> positions = List.of(6);

        assertEquals(0, new Bridge(positions, 6).earliestTime());
    }

    @Test
    void oneShotTest(){
        List<Integer> positions = Arrays.asList(6, 3, 1, 4, 2, 3, 5, 4);

        assertEquals(0, new Bridge(positions, 6).earliestTime());
    }

    @Test
    void worstCaseTest(){
        List<Integer> positions = Arrays.asList(1, 3, 1, 4, 2, 3, 5, 4, 6);

        assertEquals(8, new Bridge(positions, 6).earliestTime());
    }

    @Test
    void exampleTest(){
        List<Integer> positions = Arrays.asList(1, 3, 1, 4, 2, 3, 5, 4);

        assertEquals(6, new Bridge(positions, 5).earliestTime());
    }
}
