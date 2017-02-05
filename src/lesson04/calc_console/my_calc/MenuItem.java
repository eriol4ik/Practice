package lesson04.calc_console.my_calc;

/**
 * Created by eriol4ik on 14/01/2017.
 */
public enum MenuItem {
    CALCULATE,
    EXIT;


    @Override
    public String toString() {
        switch (this) {
            case CALCULATE:
                return "1";
            case EXIT:
                return "2";
            default:
                return null;
        }
    }
}
