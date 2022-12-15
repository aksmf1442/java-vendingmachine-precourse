package vendingmachine.exception;

public class NotEnoughItemAmountException extends RuntimeException {

    public NotEnoughItemAmountException() {
        super("[ERROR] 해당 상품의 수량이 부족합니다.");
    }
}
