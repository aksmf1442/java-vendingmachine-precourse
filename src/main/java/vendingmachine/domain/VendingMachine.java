package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {

    private final Map<Coin, Integer> coins;
    private final Map<String, Item> items;

    private int userMoney;

    public VendingMachine(Map<Coin, Integer> coins, Map<String, Item> items, int userMoney) {
        this.coins = coins;
        this.items = items;
        this.userMoney = userMoney;
    }
}
