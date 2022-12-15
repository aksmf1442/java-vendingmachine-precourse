package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
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
        List<Integer> coins = Arrays.stream(Coin.values()).filter(coin -> coin.amount <= money)
            .map(coin -> coin.amount)
            .collect(Collectors.toList());
        int coin = Randoms.pickNumberInList(coins);
        return Coin.of(coin);
    }

    private static Coin of(int coin) {
        return Arrays.stream(Coin.values())
            .filter(c -> c.amount == coin)
            .findAny()
            .get();
    }


    public int getAmount() {
        return amount;
    }
}
