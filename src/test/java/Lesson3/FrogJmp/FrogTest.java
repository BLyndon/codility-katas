package Lesson3.FrogJmp;

import common.exceptions.InvalidTargetException;
import common.exceptions.ValueRangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FrogTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1000000001})
    void checkValueRangeTest(int value){
        Exception thrown = assertThrows(ValueRangeException.class,
                () -> new Frog(1, 10, value)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @Test
    void twistedPositions(){
        Exception thrown = assertThrows(InvalidTargetException.class,
                () -> new Frog(10, 1, 3)
        );
        assertEquals("Invalid target position!", thrown.getMessage());
    }

    @Test
    void hittingTheTarget() {
        assertEquals(3, new Frog(10, 100, 30).countJumps());
    }

    @Test
    void initEqualsTargetTest() {
        int actual = new Frog(10, 10, 30).countJumps();
        assertEquals(0, actual);
    }

    @Test
    void exampleTest() {
        int actual = new Frog(10, 85, 30).countJumps();
        assertEquals(3, actual);
    }
}
