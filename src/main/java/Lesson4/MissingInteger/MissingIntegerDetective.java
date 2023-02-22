package Lesson4.MissingInteger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static common.utils.utils.utils.InputVerifier.checkArraySize;
import static common.utils.utils.utils.InputVerifier.checkValueRange;

public class MissingIntegerDetective {
    private List<Integer> array;

    public MissingIntegerDetective(List<Integer> array) {
        checkArraySize(array, 1, 100000);
        checkValueRange(array, -1000000, 1000000);

        this.array = new ArrayList<>(array);
        Collections.sort(this.array);
    }

    public int find() {
        if (hasOnlyNonPositiveValues(array)) return 1;

        array = dropNegativeValues(array);
        return findInPositivePart(array);
    }

    public int findInPositivePart(List<Integer> array) {
        return IntStream.range(1, array.size() + 1)
                .filter(item -> item != array.get(item - 1))
                .findFirst()
                .orElse(array.size() + 1);
    }

    public List<Integer> dropNegativeValues(List<Integer> array) {
        return array.stream()
                .filter(item -> item > 0)
                .collect(Collectors.toList());
    }

    public boolean hasOnlyNonPositiveValues(List<Integer> array) {
        return array.get(array.size() - 1) < 1;
    }
}
