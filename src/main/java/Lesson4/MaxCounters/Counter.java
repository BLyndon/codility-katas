package Lesson4.MaxCounters;

import java.util.*;

import static common.utils.InputVerifier.checkArraySize;
import static common.utils.InputVerifier.checkValueRange;

public class Counter {
    private final List<Integer> commandList;
    private final int numCounters;
    private ArrayList<Integer> counterPanel;


    public Counter(List<Integer> commandsList, int numCounters) {
        checkArraySize(commandsList, 1, 100000);
        checkValueRange(commandsList, 1, 1000000000);

        this.commandList = new ArrayList<>(commandsList);
        this.numCounters = numCounters;
        this.counterPanel = new ArrayList<>(Collections.nCopies(numCounters, 0));
    }

    public List<Integer> run() {
        for (int command : commandList) {
            if (0 < command && command <= numCounters)
                increase(command);
            else
                setToMax();
        }

        return new ArrayList<>(counterPanel);
    }

    private void setToMax() {
        int maxValue = counterPanel.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(NoSuchElementException::new);

        counterPanel = new ArrayList<>(Collections.nCopies(numCounters, maxValue));
    }

    private void increase(int command) {
        int counterIndex = command - 1;
        int value = counterPanel.get(counterIndex);

        counterPanel.set(counterIndex, ++value);
    }
}

