package Lesson3.PermMissingElem;

import common.exceptions.ArraySizeException;
import common.exceptions.DuplicateValueException;
import common.exceptions.ValueRangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PermMissingElemDetectiveTest {

    @Test
    void emptyArray_returns1(){
        assertEquals(1, new PermMissingElemDetective(new ArrayList<>()).find());
    }

    @Test
    void tooLargeArray(){
        List<Integer> array = new ArrayList<>(Collections.nCopies(100001, 1));
        Exception thrown = assertThrows(ArraySizeException.class,
                ()-> new PermMissingElemDetective(array)
        );
        assertEquals("Array size out of range!", thrown.getMessage());
    }

    @Test
    void valuesNotDistinct(){
        List<Integer> array = Arrays.asList(1, 2, 2);
        Exception thrown = assertThrows(DuplicateValueException.class,
                ()-> new PermMissingElemDetective(array)
        );
        assertEquals("Values are not distinct!", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5})
    void valueRange(int value){
        List<Integer> array = Arrays.asList(1, 2, value);
        Exception thrown = assertThrows(ValueRangeException.class,
                ()-> new PermMissingElemDetective(array)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2",
        "2, 1"
    })
    void unitLengthTest(int elem, int expected){
        assertEquals(expected, new PermMissingElemDetective(List.of(elem)).find());
    }

    @Test
    void tupleTest01(){
        assertEquals(1, new PermMissingElemDetective(Arrays.asList(3, 2)).find());
    }

    @Test
    void tupleTest02(){
        assertEquals(3, new PermMissingElemDetective(Arrays.asList(2, 1)).find());
    }

    @Test
    void exampleTest() {
        assertEquals(4, new PermMissingElemDetective(Arrays.asList(2,3,1,5)).find());
    }

    @Test
    void longList(){
        int expected = 1000;

        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < 10000; i++)
            range.add(i+1);
        range.remove(expected-1);

        assertEquals(expected, new PermMissingElemDetective(range).find());
    }
}
