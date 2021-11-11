public class MathOperations {
    public static int add (Values values) {
        int result = values.getA() + values.getB();
        return result;
    }
    public static int sub (Values values) {
        int result = values.getA() - values.getB();
        return result;
    }
    public static int mult (Values values) {
        int result = values.getA() * values.getB();
        return result;
    }
    public static int div (Values values) {
        int result = values.getA() / values.getB();
        return result;
    }
}
