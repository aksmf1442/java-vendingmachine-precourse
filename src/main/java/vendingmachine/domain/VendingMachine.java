package vendingmachine.domain;

import java.util.Map;
import vendingmachine.exception.NotEnoughItemAmountException;
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

    public void buyItem(String key) {
        Item item = items.get(key);
        validateItem(item);

        reduceUserMoney(item.getPrice());
    }

    private void reduceUserMoney(int price) {
        userMoney -= price;
    }

    private void validateItem(Item item) {
        if (item == null) {
            throw new NotFoundItemException();
        }

        if (item.getAmount() == 0) {
            throw new NotEnoughItemAmountException();
        }
    }

    public int getUserMoney() {
        return userMoney;
    }
}
