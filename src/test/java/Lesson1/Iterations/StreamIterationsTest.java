package Lesson1.Iterations;

import common.exceptions.ValueRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StreamIterationsTest {
    @Test
    void rangeExceptionTest() {
        Exception thrown = assertThrows(ValueRangeException.class,
                () -> new StreamBinaryGapInspector(0)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2147483647, 0"
    })
    void atBoundaryTests(int num, int expected) {
        assertEquals(expected, new StreamBinaryGapInspector(num).getLargestGap());
    }

    @ParameterizedTest
    @DisplayName("Test single gap, open gap, example")
    @CsvSource({
            "65, 5",
            "8, 0",
            "1041, 5"
    })
    void tests(int num, int expected) {
        assertEquals(expected, new StreamBinaryGapInspector(num).getLargestGap());
    }
}
