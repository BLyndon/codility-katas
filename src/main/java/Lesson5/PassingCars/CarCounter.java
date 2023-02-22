package Lesson5.PassingCars;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static Lesson5.PassingCars.Direction.LEFT;
import static Lesson5.PassingCars.Direction.RIGHT;
import static common.utils.utils.utils.InputVerifier.checkArraySize;

public class CarCounter {

    private final Map<Integer, Direction> rightMovingCars;
    private final Map<Integer, Direction> leftMovingCars;

    public CarCounter(List<Direction> array) {
        checkArraySize(array, 1, 100000);

        Map<Integer, Direction> directionMap = getIndexedDirectionMap(array);

        rightMovingCars = getCarsMovingInDir(directionMap, RIGHT);
        leftMovingCars = getCarsMovingInDir(directionMap, LEFT);
    }

    public int count() {
        int counter = 0;
        for (Entry<Integer, Direction> rightMvCar : rightMovingCars.entrySet())
            for (Entry<Integer, Direction> leftMvCar : leftMovingCars.entrySet()) {
                if (rightMvCar.getKey() < leftMvCar.getKey()) {
                    counter++;
                }
            }
        return counter;
    }

    private Map<Integer, Direction> getIndexedDirectionMap(List<Direction> array) {
        return IntStream.range(0, array.size())
                .boxed()
                .collect(Collectors.toMap(idx -> idx, array::get));
    }

    private Map<Integer, Direction> getCarsMovingInDir(Map<Integer, Direction> directionMap, Direction direction) {
        return directionMap.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(direction))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }
}
