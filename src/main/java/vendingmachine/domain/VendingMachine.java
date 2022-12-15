package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {

    private final Map<Coin, Integer> coins;

    public VendingMachine(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }
}
