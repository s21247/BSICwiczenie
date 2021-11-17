
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class zad1 {

    //zadanie 02.15
    public static void main(String[] args) {
        System.out.println("Give number of diodes that had failed:");
        Scanner scanner = new Scanner(System.in);
        try {
            int numberOfFailure = scanner.nextInt();
            List<Integer> timesAtFailure = new ArrayList<>();
            fillList(timesAtFailure, numberOfFailure);
            System.out.println(failureRate(numberOfFailure, timesAtFailure));
        } catch (InputMismatchException exception) {
            System.out.println("That's not legal value only integers !");
        }
    }

    /**
     * Function fill up an empty list with numbers at which failure occurred
     *
     * @param list taking list which is filled up
     * @param size getting size of list
     */
    public static void fillList(List<Integer> list, int size) throws RuntimeException {
        try {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < size; i++) {
                System.out.println("Give the time at which failure occurred:");
                int number = scanner.nextInt();
                list.add(number);
            }
        } catch (RuntimeException exception) {
            System.out.println("That's not legal value only integers !");
            System.exit(1);
        }
    }

    /**
     * Function sums up total operating time
     *
     * @param timesAtFailure are the hours at which failures occurred
     * @return returns total operating time
     */
    public static Integer totalOperatingTime(List<Integer> timesAtFailure) {
        Integer result = timesAtFailure.stream().reduce(Integer::sum).orElse(0);
        return result * timesAtFailure.size();
    }

    /**
     * @param number         is number of diodes that had failed
     * @param timesAtFailure are the hours at which failures occurred
     * @return failure rate
     */
    public static float failureRate(int number, List<Integer> timesAtFailure) {
        if(totalOperatingTime(timesAtFailure) == 0)
            return 0;
        return ((float) number / totalOperatingTime(timesAtFailure)) ;
    }

}
