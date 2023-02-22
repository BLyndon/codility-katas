package Lesson5.CountDiv;

import common.exceptions.OrderingException;

import java.util.Arrays;

import static common.utils.utils.utils.InputVerifier.checkValueRange;

public class DivCounter {
    private final int startValue;
    private final int endValue;
    private final int divisor;

    public DivCounter(int startValue, int endValue, int divisor) {
        checkValueRange(Arrays.asList(startValue, endValue), 0, 2000000000);
        checkValueRange(divisor, 1, 2000000000);
        checkABOrdering(startValue, endValue);

        this.startValue = startValue;
        this.endValue = endValue;
        this.divisor = divisor;
    }

    private void checkABOrdering(int startValue, int endValue) {
        if (endValue < startValue)
            throw new OrderingException();
    }

    public int count() {
        int lowestDivisor = startValue + (startValue % divisor);
        return lowestDivisor > endValue ? 0 : 1 + (endValue - lowestDivisor) / divisor;
    }
}
