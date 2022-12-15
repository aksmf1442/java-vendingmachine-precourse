package vendingmachine.domain;

import java.util.Map;

public class VendingMachineGame {

    private final Map<Coin, Integer> coins;

    public VendingMachineGame(Map<Coin, Integer> coins) {
        this.coins = coins;
        System.out.println(coins);
    }
}
