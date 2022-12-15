package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class CoinMakerTest {

    @Test
    void 랜덤으로_생성된_코인들이_금액과_일치하는지_확인() {
        CoinMaker coinMaker = new CoinMaker();
        int money = 450;

        Map<Coin, Integer> coins = coinMaker.createCoins(money);
        int result = 0;
        for (Coin coin : coins.keySet()) {
            result += coins.get(coin) * coin.getAmount();
        }

        assertThat(result).isEqualTo(money);
    }
}
