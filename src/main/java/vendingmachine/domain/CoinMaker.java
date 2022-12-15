package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class CoinMaker {

    public Map<Coin, Integer> createCoins(int money) {
        Map<Coin, Integer> coins = new HashMap<>();
        while (money > 0) {
            Coin coin = Coin.createRandomCoin(money);
            coins.put(coin, coins.getOrDefault(coin, 0) + 1);
            money -= coin.getAmount();
        }
        return coins;
    }
}
