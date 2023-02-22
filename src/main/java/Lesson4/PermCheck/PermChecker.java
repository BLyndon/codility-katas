package Lesson4.PermCheck;

import java.util.ArrayList;
import java.util.List;

import static common.utils.InputVerifier.checkArraySize;
import static common.utils.InputVerifier.checkValueRange;

public class PermChecker {
    private List<Integer> array = null;

    public PermChecker() {
    }

    public PermChecker(List<Integer> array) {
        checkArraySize(array, 1, 100000);
        checkValueRange(array, 1, 1000000000);

        this.array = new ArrayList<>(array);
    }

    public boolean check() {
        return sumIsCorrect(array) && allValuesAreDistinct(array);
    }

    public boolean allValuesAreDistinct(List<Integer> array) {
        final long numDistinctValues = array.stream()
                .distinct()
                .count();

        return array.size() == numDistinctValues;
    }

    public boolean sumIsCorrect(List<Integer> array) {
        final int expectedSum = array.size() * (array.size() + 1) / 2;
        final int actualSum = array.stream()
                .mapToInt(Integer::intValue)
                .sum();

        return expectedSum == actualSum;
    }
}
