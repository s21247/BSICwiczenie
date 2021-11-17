import java.util.Scanner;

public class zad4 {
    //zadanie 2.20
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfCards = 52;
        int numberOfCards = 0;
        System.out.println("What case do you want to calculate?");
        System.out.println("Write: 'Diamond' or 'black card' or 'nine'");
        String variable = scanner.nextLine();
        boolean flag = true;
        do {
            switch (variable) {
                case "Diamond":
                    numberOfCards = 13;
                    flag = false;
                    break;
                case "black card":
                    numberOfCards = 26;
                    flag = false;
                    break;
                case "nine":
                    numberOfCards = 4;
                    flag = false;
                    break;
                default:
                    System.out.println("That's not given input!");
                    System.out.println("What case do you want to calculate?");
                    System.out.println("Write: 'Diamond' or 'black card' or 'nine'");
                    variable = scanner.nextLine();
                    break;
            }
        } while (flag);

        System.out.println("Probability of " + variable + ": " + probability(amountOfCards, numberOfCards));
    }

    /**
     * Function counts probability
     *
     * @param amountOfCards amount of cards in the deck
     * @param numberOfCards number of cards
     * @return returns a probability of first card in top deck
     */
    public static float probability(int amountOfCards, int numberOfCards) {
        return (float) numberOfCards / amountOfCards;
    }
}
