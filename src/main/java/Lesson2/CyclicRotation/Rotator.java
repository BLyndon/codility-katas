package Lesson2.CyclicRotation;

import java.util.ArrayList;
import java.util.List;

import static common.utils.InputVerifier.checkArraySize;
import static common.utils.InputVerifier.checkValueRange;

public class Rotator {
    private final List<Integer> array;

    public Rotator(List<Integer> array) {
        checkArraySize(array, 0, 100);
        checkValueRange(array, 1000);

        this.array = new ArrayList<>(array);
    }

    public List<Integer> cycle(int numRotations) {
        checkValueRange(numRotations, 0, 100);

        int effectiveRotations = removeFullCycles(numRotations);
        return rotateArray(effectiveRotations);
    }

    private ArrayList<Integer> rotateArray(int effectiveRotations) {
        ArrayList<Integer> rotatedArray = new ArrayList<>();
        final int splitIndex = getSplitIndex(effectiveRotations);

        rotatedArray.addAll(array.subList(splitIndex, array.size()));
        rotatedArray.addAll(array.subList(0, splitIndex));
        return rotatedArray;
    }

    private int removeFullCycles(int numRotations) {
        try {
            return numRotations % array.size();
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    private int getSplitIndex(int numRotations) {
        return array.size() - numRotations;
    }
}
