package Lesson3.TapeEquilibrium;

import java.util.ArrayList;
import java.util.List;

import static common.utils.utils.utils.InputVerifier.checkArraySize;
import static common.utils.utils.utils.InputVerifier.checkValueRange;

public abstract class EquilibriumDetective {
        public final List<Integer> array;

        public EquilibriumDetective(List<Integer> array) {
            checkArraySize(array, 2, 100000);
            checkValueRange(array, 1000);

            this.array = new ArrayList<>(array);
        }

    @SuppressWarnings("unused")
    public abstract int find();
}
