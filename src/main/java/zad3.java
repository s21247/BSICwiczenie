import java.util.*;

public class zad3 {
    //zadanie 2.35
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Double> shots = new HashMap<>();
        try {
            System.out.println("Give the number of shots u want to take: ");
            int numberOfShots = scanner.nextInt();
            System.out.println("Whats the probability of first shot ?");
            float firstShot = scanner.nextFloat();
            fillUpList(shots, numberOfShots, firstShot);
            Map<Integer, Double> negativeValues;
            negativeValues = NegativeValueInList(shots);
            System.out.println(negativeValues);
            double probability = 1 - multiplier(negativeValues);
            System.out.println("Probability of success: " + probability);
        } catch (InputMismatchException exception) {
            System.out.println("That's not legal value !");
        }

    }

    /**
     * Function puts keys and values to an empty map, keys are number of shot and values are probability of shot
     *
     * @param shots              gets an empty map <key,value> as <Integer,Double>
     * @param numberOfShots      gets a number of shots that are taken
     * @param highestProbability gets a double number of first probability of the shot
     * {@Return}                 returns filledUpMap with<key: number of shot, value: probability of hit>
     */
    public static Map<Integer,Double> fillUpList(Map<Integer, Double> shots, int numberOfShots, double highestProbability) {
        double result = Math.round(highestProbability * 100.0) / 100.0;
        for (int i = 0; i < numberOfShots; i++) {
            boolean flag = shots.isEmpty();
            if (result == 0.1)
                throw new IllegalArgumentException("Probability of this shot is less or equal 0!");
            if (!flag) {
                result = Math.round((highestProbability -= 0.1d) * 100.0) / 100.0;
            }
            shots.put(i, result);
        }
        return shots;
    }

    /**
     * Function fills up an empty map, keys are number of shot and values are probability of shot
     * but values in map are negation
     *
     * @param shots gets a map elements based on which elements are negative
     * @return returns new Map<Integer,Value> where values are negative of values in shots Map
     */
    public static Map<Integer, Double> NegativeValueInList(Map<Integer, Double> shots) {
        Map<Integer, Double> negativeValues = new HashMap<>();
        for (int i = 0; i < shots.size(); i++) {
            negativeValues.put(i, 1 - shots.get(i));
        }
        return negativeValues;
    }

    /**
     * Function multiplies all values element in Map
     *
     * @param numbers gets a map that elements are multiplied
     * @return returns a multiplied number of all elements of map values
     */
    public static double multiplier(Map<Integer, Double> numbers) {
        List<Double> multiply = new ArrayList<>(numbers.values());
        return multiply.stream().reduce(1d, (x, y) -> x * y);
    }
}