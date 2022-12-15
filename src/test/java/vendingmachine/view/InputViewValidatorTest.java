package vendingmachine.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputViewValidatorTest {

    @Test
    void 금액이_숫자가_아니라면_IllegalArgumentException_발생() {
        String money = "aa";
        assertThatThrownBy(() -> InputViewValidator.validateNumber(money)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void 금액이_10으로_나누어_떨어지지_않는다면_IllegalArgumentException_발생() {
        String money = "11";
        assertThatThrownBy(() -> InputViewValidator.validateDivisibleBy10(money))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품의_사이즈가_3이_아니라면_IllegalArgumentException_발생() {
        String[] item = {"콜라", "1000"};
        assertThatThrownBy(() -> InputViewValidator.validateItemSize(item)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
