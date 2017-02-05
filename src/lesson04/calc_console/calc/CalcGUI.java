package lesson04.calc_console.calc;

import java.util.Scanner;

/**
 * Created by eriol4ik on 25/12/2016.
 */
public class CalcGUI {
    private Scanner scanner;

    public CalcGUI() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        CalcCPU.parse(scanner.nextLine());
    }

    private void menu() {
        System.out.println("1. Додавання");
    }


}
