package vendingmachine.exception;

public class NotEnoughMoneyException extends RuntimeException {

    public NotEnoughMoneyException() {
        super("[ERROR] 상품을 구매하기엔 돈이 부족합니다.");
    }
}
