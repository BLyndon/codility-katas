package Lesson4.MissingInteger;

import common.exceptions.ArraySizeException;
import common.exceptions.ValueRangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MissingIntegerDetectiveTest {

    private void assertArraySize(List<Integer> array) {
        Exception thrown = assertThrows(
                ArraySizeException.class,
                () -> new MissingIntegerDetective(new ArrayList<>(array))
        );
        assertEquals("Array size out of range!", thrown.getMessage());
    }

    @Test
    void emptyArray() {
        assertArraySize(new ArrayList<>());
    }

    @Test
    void tooLargeArray() {
        assertArraySize(Collections.nCopies(100001, 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000000001, 1000000001})
    void valueRange(int value){
        List<Integer> array = new ArrayList<>(Collections.nCopies(100, value));

        Exception thrown = assertThrows(ValueRangeException.class,
                () -> new MissingIntegerDetective(array)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @Test
    void negativeArrayTest() {
        assertEquals(1, new MissingIntegerDetective(Arrays.asList(-1, -3)).find());
    }

    @Test
    void exampleTest() {
        assertEquals(4, new MissingIntegerDetective(Arrays.asList(1, 2, 3)).find());
    }

    @Test
    void negPosIntTest01() {
        assertEquals(2, new MissingIntegerDetective(Arrays.asList(-1, -5, 3, 1)).find());
    }

    @Test
    void negPosIntTest02() {
        assertEquals(5, new MissingIntegerDetective(Arrays.asList(-1, -5, 3, 2, 1, 4)).find());
    }
}
