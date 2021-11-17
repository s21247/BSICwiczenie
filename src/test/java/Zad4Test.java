
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Zad4Test {

    private final int Diamond = 13;
    private final int blackCard = 26;
    private final int nine = 4;
    private final int amountOfCards = 52;

    @Test
    public void checkIfProbabilityForDiamondIsCorrect(){
        assertEquals(0.25,zad4.probability(amountOfCards,Diamond),0.0);
    }
    @Test
    public void checkIfProbabilityForblackCardIsCorrect(){
        assertEquals(0.5,zad4.probability(amountOfCards,blackCard),0.0);
    }
    @Test
    public void checkIfProbabilityForNineIsCorrect() {
        assertEquals(0.07692307978868484,zad4.probability(amountOfCards,nine),0.0);
    }


}
