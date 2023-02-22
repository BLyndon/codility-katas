package Lesson1.Iterations;


import static common.utils.utils.utils.InputVerifier.checkValueRange;

public abstract class BinaryGapInspector {
    public final String binaryString;

    public BinaryGapInspector(int num) {
        checkValueRange(num, 1);

        binaryString = Integer.toBinaryString(num);
    }

    @SuppressWarnings("unused")
    public abstract int getLargestGap();
}
