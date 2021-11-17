import java.util.*;

public class zad2 {
    //zadanie 2.30
    public static void main(String[] args) {
        List<Integer> numberOfPeople = new ArrayList<>();
        fillList(numberOfPeople);
        System.out.println(numberOfPeople);
        List<Integer> list = new ArrayList<>();
        fillUpList(list, 4, sum(numberOfPeople));
        List<Integer> manAndWomen = numberOfPeople.subList(0, 2);
        List<Integer> children = new ArrayList<>();
        int element = numberOfPeople.get(numberOfPeople.size() - 1);
        fillChildrenArray(children, element, element - 1);
        int sumOfManAndWomen = sum(manAndWomen);
        List<Integer> updatedManAndWoman = new ArrayList<>();
        fillUpList(updatedManAndWoman, 2, sumOfManAndWomen);
        int multiplierForManAndWomen = multiplier(updatedManAndWoman) / 2;
        int multiplierForChildren = multiplier(children) / 2;
        double multiplyAll = multiplierForManAndWomen * multiplierForChildren;
        double probability = multiplyAll / variants(list);
        System.out.println("probability: " + probability);

    }

    /**
     * Function fill up an empty list with numbers at which failure occurred
     *
     * @param list taking list which is filled up
     */
    private static void fillList(List<Integer> list) throws InputMismatchException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Give a number of People: first Men then Women then Children");
            for (int i = 0; i < 3; i++) {
                System.out.println("Give number of people");
                int number = scanner.nextInt();
                list.add(number);
            }
        } catch (InputMismatchException exception) {
            System.out.println("That's not legal value only integers !");
            System.exit(1);
        }
    }

    /**
     * Function add to list 2 elements
     *
     * @param numbers  gets the list of integers that elements are added
     * @param element  first element added to the list
     * @param element2 second element added to list
     */
    public static void fillChildrenArray(List<Integer> numbers, int element, int element2) {
        List<Integer> anotherList = Arrays.asList(element, element2);
        numbers.addAll(anotherList);
    }

    /**
     * Function sums up elements in list
     *
     * @param numbers gets a list of integers
     * @return returns sum of all elements in list
     */
    public static int sum(List<Integer> numbers) {
        return numbers.stream().reduce(Integer::sum).orElse(0);
    }

    /**
     * Function multiply all elements in list
     *
     * @param numbers gets a list of integers
     * @return returns a number equals to multiplied all elements
     */
    public static int multiplier(List<Integer> numbers) {
        return numbers.stream().reduce(1, (x, y) -> x * y);
    }

    /**
     * Function fills up an empty list with elements sum - i
     *
     * @param numbers gets a list of integers
     * @param size    gets a size of filled list
     * @param sum     gets a sum value of elements
     */
    private static void fillUpList(List<Integer> numbers, int size, int sum) {
        for (int i = 0; i < size; i++) {
            numbers.add(sum - i);
        }
    }

    /**
     * Functions counts variant number of possibilities
     *
     * @param numbers gets a list of integers
     * @return returns a number of variants
     */
    public static double variants(List<Integer> numbers) {
        double number = numbers.stream().reduce(1, (x, y) -> x * y);
        return number / 24;
    }
}
