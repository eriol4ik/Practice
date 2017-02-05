package hw2.learning;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by eriol4ik on 27/12/2016.
 */
public class LearnDates {
    public static void main(String[] args) {
//        usingDates();

//        usingCharArrays();

        Boolean bool1 = true;
        Boolean bool2 = true;
        Boolean bool3 = true;
        Boolean bool4 = false;
        Boolean bool5 = false;

        System.out.println(bool1.hashCode());
        System.out.println(bool2.hashCode());
        System.out.println(bool3.hashCode());
        System.out.println(bool4.hashCode());
        System.out.println(bool5.hashCode());

    }

    private static void usingCharArrays() {
        char[] arr1 = {'a','b','c'};
        char[] arr2 = {'a','b','c'};

        System.out.println(Arrays.equals(arr1,arr2));
    }

    private static void usingDates() {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now();
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date1.hashCode());
        System.out.println(date2.hashCode());
        System.out.println(date1.equals(date2));
    }
}
