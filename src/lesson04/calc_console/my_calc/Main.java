package lesson04.calc_console.my_calc;

/**
 * Created by eriol4ik on 25/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        CalcModel model = new CalcModel();
        CalcView view = new CalcView(model);
        model.setView(view);
        CalcController controller = new CalcController(model, view);


    }
}
