package Lesson3.TapeEquilibrium;

import java.util.List;

public class ImperativeEquilibriumDetective extends EquilibriumDetective {
    public ImperativeEquilibriumDetective(List<Integer> array) {
        super(array);
    }

    public int find() {
        if (array.size() == 2)
            return Math.abs(array.get(0) - array.get(1));

        int leftSum = array.get(0);
        int rightSum = array.subList(1, array.size())
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        int diff = Math.abs(leftSum - rightSum);
        for (int elem : arrayWithoutBoundaries(array)) {
            leftSum += elem;
            rightSum -= elem;
            diff = Math.min(diff, Math.abs(leftSum - rightSum));
        }
        return diff;
    }

    private List<Integer> arrayWithoutBoundaries(List<Integer> array) {
        return array.subList(1, array.size() - 1);
    }
}
