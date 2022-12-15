package vendingmachine.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static Coin createRandomCoin(int money) {
        List<Coin> coins = Arrays.stream(Coin.values()).filter(coin -> coin.amount <= money)
            .collect(Collectors.toList());
        Collections.shuffle(coins);
        return coins.get(0);
    }

    public int getAmount() {
        return amount;
    }
}
