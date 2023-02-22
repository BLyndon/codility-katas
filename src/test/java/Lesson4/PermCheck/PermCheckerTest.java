package Lesson4.PermCheck;

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

public class PermCheckerTest {

    @Test
    void emptyArray() {
        assertArraySize(new ArrayList<>());
    }

    @Test
    void tooLargeArray() {
        assertArraySize(new ArrayList<>(Collections.nCopies(100001, 0)));
    }

    private void assertArraySize(List<Integer> array) {
        Exception thrown = assertThrows(ArraySizeException.class,
                () -> new PermChecker(array)
        );
        assertEquals("Array size out of range!", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1000000001})
    void valueRange(int value){
        List<Integer> array = new ArrayList<>(Collections.nCopies(100, value));

        Exception thrown = assertThrows(ValueRangeException.class,
                () -> new PermChecker(array)
        );
        assertEquals("Value out of range!", thrown.getMessage());
    }

    @Test
    void singleElementTrue(){
        assertTrue(new PermChecker(List.of(1)).check());
    }

    @Test
    void singleElementFalse(){
        assertFalse(new PermChecker(List.of(2)).check());
    }

    @Test
    void exampleTest01(){
        assertTrue(new PermChecker(Arrays.asList(4, 1, 3, 2)).check());
    }

    @Test
    void exampleTest02(){
        assertFalse(new PermChecker(Arrays.asList(4, 1, 3)).check());
    }

    @Test
    void notAllValuesAreDistinctTest() {
        var actual = new PermChecker().allValuesAreDistinct(Arrays.asList(4, 4, 3));
        assertFalse(actual);
    }

    @Test
    void allValuesAreDistinctTest() {
        var actual = new PermChecker().allValuesAreDistinct(Arrays.asList(4, 1, 3));
        assertTrue(actual);
    }

    @Test
    void sumIsNotCorrectTest() {
        var actual = new PermChecker().sumIsCorrect(Arrays.asList(4, 1, 3));
        assertFalse(actual);
    }

    @Test
    void sumIsCorrectTest() {
        var actual = new PermChecker().sumIsCorrect(Arrays.asList(2, 1, 3));
        assertTrue(actual);
    }
}
