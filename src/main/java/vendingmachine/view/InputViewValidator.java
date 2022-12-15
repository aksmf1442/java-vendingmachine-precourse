package vendingmachine.view;

public class InputViewValidator {

    private static int MIN_DIVISION_NUMBER = 10;
    private static int MIN_PRICE = 100;

    public static void validateNumber(String number) {
        String expression = "^[0-9]+$";
        if (!number.matches(expression)) {
            throw new IllegalArgumentException("[ERROR] 입력 받은 금액이 숫자여야 합니다.");
        }
    }

    public static void validateDivisibleBy10(String money) {
        if (Integer.parseInt(money) % MIN_DIVISION_NUMBER != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 받은 금액이 10으로 나누어 떨어져야 합니다.");
        }
    }

    public static void validateItemSize(String[] item) {
        if (item.length != 3) {
            throw new IllegalArgumentException("[ERROR] 상품명, 가격, 수량 모두를 입력해줘야합니다.");
        }
    }

    public static void validatePriceRange(String price) {

    }
}
