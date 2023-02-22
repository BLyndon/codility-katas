package Lesson5.CoundDiv;

import common.exceptions.OrderingException;
import common.exceptions.ValueRangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivCounterTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 2000000001})
    void checkABRange(int value){
        Exception thrown = assertThrows(ValueRangeException.class,
                () -> new DivCounter(value, 2000000002, 1)
                );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2000000001})
    void checkKRange(int value){
        Exception thrown = assertThrows(ValueRangeException.class,
                () -> new DivCounter(1, 2, value)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @Test
    void checkABOrdering (){
        Exception thrown = assertThrows(OrderingException.class,
                () -> new DivCounter(1, 0, 1)
        );
        assertEquals("Wrong ordering!", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "6,11,2,3",
            "6,12,2,4",
            "7,13,2,3",
            "6,11,3,2",
            "6,11,4,1",
            "2,2,1,1",
            "3,3,2,0"
    })
    void example01(int startValue, int endValue, int divisor, int expected){
        assertEquals(expected, new DivCounter(startValue, endValue, divisor).count());
    }
}
