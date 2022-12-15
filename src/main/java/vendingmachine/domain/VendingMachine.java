package vendingmachine.domain;

import java.util.Map;
import vendingmachine.exception.NotFoundItemException;

public class VendingMachine {

    private final Map<Coin, Integer> coins;
    private final Map<String, Item> items;

    private int userMoney;

    public VendingMachine(Map<Coin, Integer> coins, Map<String, Item> items, int userMoney) {
        this.coins = coins;
        this.items = items;
        this.userMoney = userMoney;
    }

    public void buyItem(String item) {
        validateItem(items.get(item));
    }

    private void validateItem(Item item) {
        if (item == null) {
            throw new NotFoundItemException();
        }
    }
}
