package p01_overloadMethod;

public class MathOperation {
    private MathOperation() {

    }

    public static int add(int number1, int number2) {
        return number1 + number2;
    }

    public static int add(int number1, int number2, int number3) {
        return add(number1, number2) + number3;
    }

    public static int add(int number1, int number2, int number3, int number4) {
        return add(number1, number2, number3) + number4;
    }
}
