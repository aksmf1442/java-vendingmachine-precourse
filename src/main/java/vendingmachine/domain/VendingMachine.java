package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.exception.NotEnoughItemAmountException;
import vendingmachine.exception.NotEnoughMoneyException;
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
        if (userMoney < price) {
            throw new NotEnoughMoneyException();
        }
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

    public boolean end() {
        return checkItemOfMinPrice() | checkItemsAmount();
    }

    private boolean checkItemsAmount() {
        for (Item item : items.values()) {
            if (item.getAmount() > 0) {
                return false;
            }
        }
        return false;
    }

    private boolean checkItemOfMinPrice() {
        for (Item item : items.values()) {
            if (item.getPrice() <= userMoney) {
                return false;
            }
        }
        return true;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public Map<Coin, Integer> returnCoins() {
        Map<Coin, Integer> returnCoins = new HashMap<>();
        for (Coin coin : Coin.values()) {
            Integer coinCount = coins.getOrDefault(coin, 0);
            if (coinCount * coin.getAmount() <= userMoney) {
                userMoney -= coinCount * coin.getAmount();
                returnCoins.put(coin, coinCount);
                continue;
            }
            int minusCoin = userMoney / coin.getAmount();
            userMoney -= minusCoin * coinCount;
            returnCoins.put(coin, minusCoin);
        }
        return returnCoins;
    }
}
