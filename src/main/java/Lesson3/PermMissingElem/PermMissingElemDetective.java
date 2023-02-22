package Lesson3.PermMissingElem;

import java.util.*;

import static common.utils.InputVerifier.*;

public class PermMissingElemDetective {
    private final List<Integer> array;

    public PermMissingElemDetective(List<Integer> array) {
        checkArraySize(array, 0, 100000);
        checkValueRange(array, 1, array.size() + 1);
        checkIfValuesDistinct(array);

        this.array = new ArrayList<>(array);
        Collections.sort(this.array);
    }

    public int find() {
        if (firstElemIsMissing())
            return 1;
        return findInSortedList(this.array);
    }

    private int findInSortedList(List<Integer> array) {
        if (lastElemIsMissing(array))
            return array.size() + 1;

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i - 1) + 2 == array.get(i))
                return array.get(i) - 1;
        }
        return 3;
    }

    private boolean firstElemIsMissing() {
        try{
            return array.get(0) != 1;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }

    private boolean lastElemIsMissing(List<Integer> array) {
        return array.size() == Collections.max(array);
    }
}
