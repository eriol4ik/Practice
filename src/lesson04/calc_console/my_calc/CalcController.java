package lesson04.calc_console.my_calc;

/**
 * Created by eriol4ik on 25/12/2016.
 */
public class CalcController {
    private CalcView view;
    private CalcModel model;

    private String input;

    public CalcController(CalcModel model, CalcView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        view.showMenu();



    }
}
