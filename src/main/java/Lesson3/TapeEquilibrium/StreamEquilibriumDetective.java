package Lesson3.TapeEquilibrium;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Math.abs;

public class StreamEquilibriumDetective extends EquilibriumDetective{
    public StreamEquilibriumDetective(List<Integer> array) {
        super(array);
    }

    public int find() {
        return getListOfDifferences()
                .stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(NoSuchElementException::new);
    }

    private List<Integer> getListOfDifferences() {
        List<Integer> differences = new ArrayList<>();

        for (int position = 1; position < array.size(); position++)
            differences.add(getDifference(position));

        return differences;
    }

    private int getDifference(int sliceAt) {
        List<Integer> leftSlice = array.subList(0, sliceAt);
        List<Integer> rightSlice = array.subList(sliceAt, array.size());

        return abs(getSum(leftSlice) - getSum(rightSlice));
    }

    private int getSum(List<Integer> slice) {
        return slice.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
