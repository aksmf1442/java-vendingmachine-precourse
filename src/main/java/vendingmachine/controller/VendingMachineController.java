package vendingmachine.controller;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinMaker;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.exception.NotEnoughItemAmountException;
import vendingmachine.exception.NotEnoughMoneyException;
import vendingmachine.exception.NotFoundItemException;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public void run() {
        Map<Coin, Integer> coins = createCoins();
        Map<String, Item> items = createItems();
        int userMoney = createUserMoney();

        VendingMachine vendingMachine = new VendingMachine(coins, items, userMoney);
        buyItems(vendingMachine);
    }

    private void buyItems(VendingMachine vendingMachine) {
        try {
            while (!endGame(vendingMachine)) {
                OutputView.printUserMoney(vendingMachine.getUserMoney());
                String item = InputView.inputItem();
                vendingMachine.buyItem(item);
            }
        } catch (NotFoundItemException | NotEnoughItemAmountException | NotEnoughMoneyException exception) {
            System.out.println(exception.getMessage());
            buyItems(vendingMachine);
        }
    }

    private boolean endGame(VendingMachine vendingMachine) {
        return vendingMachine.end();
    }

    private int createUserMoney() {
        try {
            int money = InputView.inputMoneyOfUser();
            return money;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return createUserMoney();
    }

    private Map<Coin, Integer> createCoins() {
        try {
            int money = InputView.inputMoneyOfVendingMachine();
            CoinMaker coinMaker = new CoinMaker();
            Map<Coin, Integer> coins = coinMaker.createCoins(money);
            OutputView.printCoinsStatus(coins);
            return coins;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return createCoins();
    }

    private Map<String, Item> createItems() {
        try {
            return InputView.inputItems();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return createItems();
    }
}
