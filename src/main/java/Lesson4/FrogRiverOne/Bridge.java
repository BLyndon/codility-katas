package Lesson4.FrogRiverOne;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static common.utils.InputVerifier.*;

public class Bridge {
    private final List<Integer> positions;
    private final int targetPos;

    public Bridge(List<Integer> positions, int targetPos) {
        checkArraySize(positions, 1, 100000);
        checkValueRange(positions, targetPos);
        checkTargetPos(targetPos);

        this.positions = positions;
        this.targetPos = targetPos;
    }

    public int earliestTime() {
        IntPredicate targetIsReached = index -> positions.get(index) == targetPos;

        return IntStream.range(0, positions.size())
                .filter(targetIsReached)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
