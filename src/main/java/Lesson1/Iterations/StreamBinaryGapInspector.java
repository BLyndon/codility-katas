package Lesson1.Iterations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamBinaryGapInspector extends BinaryGapInspector {
    private final List<String> zeroChains;

    public StreamBinaryGapInspector(int num) {
        super(num);

        zeroChains = Arrays.stream(binaryString.split("1"))
                .filter(chain -> !chain.isEmpty())
                .collect(Collectors.toList());
    }

    @Override
    public int getLargestGap() {
        if (containsNoClosedZeroChain(zeroChains))
            return 0;

        return zeroChains.stream()
                .map(String::length)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    private boolean containsNoClosedZeroChain(List<String> zeroChains) {
        return zeroChains.size() == 1
                && binaryString.charAt(binaryString.length() - 1) == '0';
    }
}
