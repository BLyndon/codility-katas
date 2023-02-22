package Lesson1.Iterations;

import static java.lang.Math.max;

public class ImperativeBinaryGapInspector extends BinaryGapInspector{
    public ImperativeBinaryGapInspector(int num) {
        super(num);
    }

    @Override
    public int getLargestGap() {
        int counter = 0;
        int gapLength = 0;

        for (Character character : binaryString.toCharArray())
            if (character == '0')
                counter++;
            else {
                gapLength = max(gapLength, counter);
                counter = 0;
            }
        return gapLength;
    }
}
