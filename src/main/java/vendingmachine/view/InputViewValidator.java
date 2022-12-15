package vendingmachine.view;

public class InputViewValidator {

    private static int MIN_DIVISION_NUMBER = 10;

    public static void validateNumber(String money) {
        String expression = "^[0-9]+$";
        if (!money.matches(expression)) {
            throw new IllegalArgumentException("[ERROR] 입려 받은 금액이 숫자여야 합니다.");
        }
    }

    public static void validateDivisibleBy10(String money) {
        if (Integer.parseInt(money) % MIN_DIVISION_NUMBER != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 받은 금액이 10으로 나누어 떨어져야 합니다.");
        }
    }
}
