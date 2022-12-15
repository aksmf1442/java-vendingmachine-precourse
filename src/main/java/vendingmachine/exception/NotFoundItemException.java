package vendingmachine.exception;

public class NotFoundItemException extends RuntimeException{

    public NotFoundItemException() {
        super("[ERROR] 상품 목록에서 해당 상품을 찾을 수 없습니다.");
    }
}
