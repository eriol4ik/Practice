package lesson04.calc_console.calc;

import java.util.Scanner;

/**
 * Created by eriol4ik on 25/12/2016.
 */
public class CalcCPU {
    private static Integer first;
    private static String operation;
    private static Integer second;
    private static String equals;

    private CalcCPU() {}

    public static Integer calc(Integer first,
                            String operation,
                            Integer second) {
        switch (operation) {
            case "+": return first + second;
            case "-": return first - second;
            case "*": return first * second;
            case "/": return first / second;
        }
        return null;
    }


    public static void parse(String expression) {
        Scanner scanExp = new Scanner(expression);
        first = scanExp.nextInt();
        operation = scanExp.next();
        second = scanExp.nextInt();
        equals = scanExp.next();
    }

    public static Integer getFirst() {
        return first;
    }

    public static String getOperation() {
        return operation;
    }

    public static Integer getSecond() {
        return second;
    }

    public static String getEquals() {
        return equals;
    }
}
