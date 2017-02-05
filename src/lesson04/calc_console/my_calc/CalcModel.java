package lesson04.calc_console.my_calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by eriol4ik on 25/12/2016.
 */
public class CalcModel {
    CalcView view;

    public void setView(CalcView view) {
        this.view = view;
    }

    public String getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException ioe) {
            System.out.println("Incorrect input. Try again.\n");
            return getInput();
        }
    }


}
