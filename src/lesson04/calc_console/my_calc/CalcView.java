package lesson04.calc_console.my_calc;

import java.lang.reflect.Field;

/**
 * Created by eriol4ik on 25/12/2016.
 */
public class CalcView {
    CalcModel model = new CalcModel();

    public CalcView(CalcModel model) {
        this.model = model;
    }

    public void showMenu() {
        String menu =   "1. Calculate...\n" +
                        "2. Exit.";
        System.out.println(menu);
    }
}
