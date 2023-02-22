package Lesson2.CyclicRotation;

import common.exceptions.ArraySizeException;
import common.exceptions.ValueRangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RotatorTest {

    @Test
    void checkArraySize(){
        Exception thrown = assertThrows(ArraySizeException.class,
                () -> new Rotator(new ArrayList<>(Collections.nCopies(101, 0)))
        );
        assertEquals("Array size out of range!", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    void checkNumRotations(int numRotations){
        Rotator rotator = new Rotator(new ArrayList<>(Collections.nCopies(10, 1)));

        Exception thrown = assertThrows(ValueRangeException.class,
                () -> rotator.cycle(numRotations)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1001, 1001})
    void checkIntegerRange(int value){
        List<Integer> array = new ArrayList<>(Collections.nCopies(10, value));

        Exception thrown = assertThrows(ValueRangeException.class,
                () -> new Rotator(array)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @Test
    void emptyArray_returnsEmptyArray(){
        assertEquals(new ArrayList<>(), new Rotator(new ArrayList<>()).cycle(1));
    }

    @Test
    void noCycle_justPasses() {
        List<Integer> rotatedArray = new Rotator(Arrays.asList(1, 2, 3)).cycle(0);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3)), rotatedArray);
    }

    @Test
    void fullCycle_justPasses() {
        List<Integer> rotatedArray = new Rotator(Arrays.asList(1, 2, 3)).cycle(3);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3)), rotatedArray);
    }

    @Test
    void multiplePeriodCycle() {
        List<Integer> actual = new Rotator(Arrays.asList(-3, 8, 9, -7, 6)).cycle(13);
        assertEquals(Arrays.asList(9, -7, 6, -3, 8), actual);
    }
}
