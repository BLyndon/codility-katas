package Lesson4.MaxCounters;

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

public class CounterTest {

    private void assertArraySize(List<Integer> array) {
        Exception thrown = assertThrows(
                ArraySizeException.class,
                () -> new Counter(new ArrayList<>(array), 5)
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
    @ValueSource(ints = {0, 1000000001})
    void valueRange(int value) {
        List<Integer> array = new ArrayList<>(Collections.nCopies(100, value));

        Exception thrown = assertThrows(
                ValueRangeException.class,
                () -> new Counter(array, 5)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @Test
    void exampleTest() {
        assertEquals(
                Arrays.asList(3, 2, 2, 4, 2),
                new Counter(Arrays.asList(3, 4, 4, 6, 1, 4, 4), 5).run()
        );
    }
}
