package vendingmachine.view;

public class InputViewValidator {

    private static int MIN_DIVISION_NUMBER = 10;

    public static void validateNumber(String money) {
    }

    public static void validateDivisibleBy10(int money) {
        if (money % MIN_DIVISION_NUMBER != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 10으로 나누어 떨어져야 합니다.");
        }
    }
}
