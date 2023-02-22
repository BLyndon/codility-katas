package Lesson3.TapeEquilibrium;

import common.exceptions.ArraySizeException;
import common.exceptions.ValueRangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImperativeEquilibriumDetectiveTest {

    private void assertArraySize(List<Integer> array) {
        Exception thrown = assertThrows(ArraySizeException.class,
                () -> new ImperativeEquilibriumDetective(array)
        );
        assertEquals("Array size out of range!", thrown.getMessage());
    }

    @Test
    void arrayTooSmall() {
        assertArraySize(List.of(1));
    }

    @Test
    void arrayTooLarge() {
        assertArraySize(Collections.nCopies(100001, 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1001, 1001})
    void valueRange(int value) {
        Exception thrown = assertThrows(ValueRangeException.class,
                () -> new ImperativeEquilibriumDetective(Collections.nCopies(100, value))
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @Test
    void minimalArray() {
        assertEquals(2, new ImperativeEquilibriumDetective(Arrays.asList(2, 4)).find());
    }

    @Test
    void testComponentSum2() {
        assertEquals(3, new ImperativeEquilibriumDetective(Arrays.asList(2, 4, 1)).find());
    }

    @Test
    void testComponentSum3() {
        assertEquals(4, new ImperativeEquilibriumDetective(Arrays.asList(-6, 4, 2)).find());
    }

    @Test
    void testComponentSum4() {
        assertEquals(0, new ImperativeEquilibriumDetective(Arrays.asList(-6, 4, -2)).find());
    }

    @Test
    void testIndifferent() {
        assertEquals(0, new ImperativeEquilibriumDetective(Arrays.asList(0, 0, 0, 0)).find());
    }

    @Test
    void exampleTest() {
        assertEquals(1, new ImperativeEquilibriumDetective(Arrays.asList(3, 1, 2, 4, 3)).find());
    }
}