package Lesson3.FrogJmp;

import common.exceptions.InvalidTargetException;

import java.util.Arrays;

import static common.utils.utils.utils.InputVerifier.checkValueRange;

public class Frog {
    private final int initialPos;
    private final int targetPos;
    private final int leapLength;

    public Frog(int initialPos, int targetPos, int leapLength) {
        checkValueRange(Arrays.asList(initialPos, targetPos, leapLength), 1, 1000000000);
        checkPositionOrder(initialPos, targetPos);

        this.initialPos = initialPos;
        this.targetPos = targetPos;
        this.leapLength = leapLength;
    }

    private void checkPositionOrder(int initialPos, int targetPos) throws IllegalArgumentException {
        if (initialPos > targetPos)
            throw new InvalidTargetException();
    }

    public int countJumps() {
        boolean hitsTargetPos = (targetPos - initialPos) % leapLength == 0;
        int numJumps = (targetPos - initialPos) / leapLength;

        return hitsTargetPos ? numJumps : 1 + numJumps;
    }
}
