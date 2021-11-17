import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class zad2Test {
    private List<Integer> numbers = new ArrayList<>();
    private final int element = 2;
    private final int element2 = 2;
    List<Integer> test = List.of(2, 2);

    @Test
    public void checkIfTwoListsAreTheSame() {
        numbers.add(element);
        numbers.add(element2);
        assertTrue(test.size() == numbers.size() &&
                test.containsAll(numbers) && numbers.containsAll(test));
    }

    @Test
    public void checkIfSumsUpCorrectly() {
        numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(zad2.sum(numbers), 28);
    }

    @Test
    public void checkIfMultiplyCorrectly() {
        numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(zad2.multiplier(numbers), 5040);
    }

    @Test
    public void checkIfVariantsAreCorrect() {
        numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(zad2.variants(numbers), 210.0);
    }
}
