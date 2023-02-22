package common.utils;

import common.exceptions.ArraySizeException;
import common.exceptions.DuplicateValueException;
import common.exceptions.InvalidTargetException;
import common.exceptions.ValueRangeException;
import org.w3c.dom.ranges.RangeException;

import java.util.*;

public class InputVerifier {

    public static void checkValueRange(int num, int lowerBoundary) throws RangeException {
        if (valueTooLow(num, lowerBoundary))
            throw new ValueRangeException();
    }

    public static void checkValueRange(int num, int lowerBoundary, int upperBoundary) throws RangeException {
        if (valueTooLow(num, lowerBoundary) || valueTooHigh(num, upperBoundary))
            throw new ValueRangeException();
    }

    public static void checkValueRange(List<Integer> array, int lowerBoundary, int upperBoundary) throws RangeException {
        if (valueTooHigh(array, upperBoundary) || valueTooLow(array, lowerBoundary))
            throw new ValueRangeException();
    }

    public static <T> void checkArraySize (List<T> array, int minSize, int maxSize) throws RangeException {
        if (array.size() < minSize || array.size() > maxSize)
            throw new ArraySizeException();
    }

    public static void checkValueRange(List<Integer> array, int boundary) throws RangeException {
        if (absValuesTooHigh(array, boundary))
            throw new ValueRangeException();
    }

    public static void checkIfValuesDistinct(List<Integer> array) throws DuplicateValueException {
        Set<Integer> s = new HashSet<>(array);

        if (s.size() != array.size())
            throw new DuplicateValueException();
    }

    public static void checkTargetPos(int targetPos) throws InvalidTargetException {
        if (targetPos < 1 || targetPos > 100000)
            throw new InvalidTargetException();
    }

    private static boolean absValuesTooHigh(List<Integer> array, int boundary) {
        try {
            return array.stream()
                    .mapToInt(Integer::intValue)
                    .map(Math::abs)
                    .max()
                    .orElseThrow(NoSuchFieldError::new) > boundary;
        } catch (NoSuchFieldError e) {
            return false;
        }
    }

    private static boolean valueTooLow(List<Integer> array, int lowerBoundary) {
        try {
            return Collections.min(array) < lowerBoundary;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private static boolean valueTooHigh(List<Integer> array, int upperBoundary) {
        try {
            return Collections.max(array) > upperBoundary;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private static boolean valueTooLow(int num, int lowerBoundary) {
        return num < lowerBoundary;
    }

    private static boolean valueTooHigh(int num, int upperBoundary) {
        return num > upperBoundary;
    }
}
