import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class Zad3Test {
    Map<Integer,Double> shots = new HashMap<>();
    Map<Integer,Double> test = zad3.fillUpList(shots, 4, 0.6);
    Map<Integer,Double> testFilledMap = Map.of(0,0.6,1,0.5,2,0.4,3,0.3);
    Map<Integer,Double> testNegativeValuesList = Map.of(0,0.4,1,0.5,2,0.6,3,0.7);
    @Test
    public void checkIfBothMapsAreEqual(){
        assertTrue(areEqual(test, testFilledMap));
    }
    @Test
    public void checkIfBothMapsAreNotEqual(){
        Map<Integer,Double> test = zad3.fillUpList(shots, 4, 0.5);
        assertFalse(areEqual(test, testFilledMap));
    }
    @Test
    public void checkIfBothMapsWithNegativeValuesAreEqual(){
        Map<Integer,Double> negativeValues = zad3.NegativeValueInList(shots);
        assertTrue(areEqual(negativeValues,testNegativeValuesList));
    }
    @Test
    public void checkIfBothMapsWithNegativeValuesAreNotEqual(){
        Map<Integer,Double> test = zad3.NegativeValueInList(shots);
        assertFalse(areEqual(test, testFilledMap));
    }
    @Test
    public void checkIfMultiplierMulitplyCorrectly(){
        double result = zad3.multiplier(testFilledMap);
        assertEquals(0.036,result,0.0);
    }
    @Test
    public void checkIfMultiplierMulitplyIncorrectly(){
        double result = zad3.multiplier(testFilledMap);
        assertNotEquals(0.01,result,0.0);
    }
    private boolean areEqual(Map<Integer, Double> first, Map<Integer, Double> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
                .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }

}
