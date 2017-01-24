package xyz.alhdo;

/**
 * Created by root on 1/14/17.
 */
public class Utils {
    public static boolean is_Op(String op) {
        switch (op) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }
    }

    public static double operate(Double a, Double b, String op) {

        switch (op) {
            case "+":
                return Double.valueOf(a) + Double.valueOf(b);
            case "-":
                return Double.valueOf(a) - Double.valueOf(b);
            case "*":
                return Double.valueOf(a) * Double.valueOf(b);
            case "/":
                try {
                    return Double.valueOf(a) / Double.valueOf(b);
                } catch (Exception e) {
                    e.getMessage();
                }
            default:
                return -1;
        }
    }
}
