
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class zad1Test {
    private List<Integer> ListOfNumbers = List.of(115,120,205,370,459, 607, 714,
            840, 990, 1160, 1188, 1300, 1380, 1414, 1449,1497);
    @Test
    public void checkIfTotalOperatingTimeIsCorrect(){
       int result =  zad1.totalOperatingTime(ListOfNumbers);
       assertEquals(result,220928);
    }
    @Test
    public void checkIfTotalOperatingTimeIsIncorrect(){
        int result =  zad1.totalOperatingTime(ListOfNumbers);
        assertNotEquals(result,110231);
    }
    @Test
    public void checkIfFailureTimeIsCorrect(){
        assertEquals(7.242178253363818E-5,zad1.failureRate(ListOfNumbers.size(), ListOfNumbers),0.0);
    }
    @Test
    public void checkIfFailureTimeIsIncorrect(){
        assertNotEquals(1,zad1.failureRate(ListOfNumbers.size(), ListOfNumbers),0.0);
    }
    @Test
    public void checkIfFailureTimeIsCorrectButFailureRateIs0(){
        List<Integer> emptyList = new ArrayList<>();
        assertEquals(0,zad1.failureRate(ListOfNumbers.size(), emptyList),0.0);
    }

}
