package Lesson2.OddOccurrencesInArray;

import common.exceptions.ArraySizeException;
import common.exceptions.ValueRangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PairArrayTest {

    @Test
    void emptyArray(){
        assertArraySize(new ArrayList<>());
    }

    @Test
    void tooLargeArray(){
        assertArraySize(Collections.nCopies(1000001, 1));
    }

    private void assertArraySize(List<Integer> array) {
        Exception thrown = assertThrows(ArraySizeException.class,
                () -> new PairArray(new ArrayList<>(array))
        );
        assertEquals("Array size out of range!", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1000000001})
    void arrayValueRange(int value){
        List<Integer> array = new ArrayList<>(Collections.nCopies(100, value));

        Exception thrown = assertThrows(ValueRangeException.class,
                () -> new PairArray(array)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @Test
    void unitLengthArray() {
        int actual = new PairArray(List.of(1)).getLoner();
        assertEquals(1, actual);
    }

    @Test
    void lonerAtLastPos() {
        int actual = new PairArray(Arrays.asList(1, 1, 2)).getLoner();
        assertEquals(2, actual);
    }

    @Test
    void exampleArray() {
        int actual = new PairArray(Arrays.asList(9, 3, 9, 3, 9, 7, 9)).getLoner();
        assertEquals(7, actual);
    }

    @Test
    void randomArray(){
        int expected = 5;
        assertEquals(expected, new PairArray(getArrayList(expected)).getLoner());
    }

    private List<Integer> getArrayList(int expected) {
        List<Integer> array = new ArrayList<>();
        int maxNum = 10000;
        Random rn = new Random();

        for (int n = 0; n < maxNum; n++) {
            int randNum = rn.nextInt(1000000000) + 1;
            array.add(randNum + 1);
            array.add(randNum + 1);
        }
        array.add(rn.nextInt(maxNum + 1), expected);

        return array;
    }
}
