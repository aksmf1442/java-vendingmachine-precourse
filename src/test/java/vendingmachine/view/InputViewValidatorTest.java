package vendingmachine.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewValidatorTest {

    @Test
    void 금액이_10으로_나누어_떨어지지_않는다면_IllegalArgumentException_발생() {
        int money = 11;
        Assertions.assertThatThrownBy(() -> InputViewValidator.validateDivisibleBy10(money))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
