package Lesson2.OddOccurrencesInArray;

import static common.utils.InputVerifier.checkArraySize;
import static common.utils.InputVerifier.checkValueRange;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PairArray {
    private List<Integer> array;

    public PairArray(List<Integer> array) {
        checkArraySize(array, 1, 1000000);
        checkValueRange(array, 1, 1000000000);

        this.array = new ArrayList<>(array);
    }

    public int getLoner() {
        while (this.array.size() > 1) {
            int firstElement = this.array.get(0);
            this.array = filterArray(firstElement);
            if (elementFound())
                return firstElement;
        }
        return this.array.get(0);
    }

    private boolean elementFound() {
        return this.array.size() % 2 == 0;
    }

    private List<Integer> filterArray(int firstElement) {
        return this.array
                .stream()
                .filter(item -> item != firstElement)
                .collect(Collectors.toList());
    }
}
