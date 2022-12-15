package vendingmachine.controller;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinMaker;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public void run() {
        Map<Coin, Integer> coins = createCoins();
        Map<String, Item> items = createItems();
        VendingMachine vendingMachine = new VendingMachine(coins, items);

        int moneyOfUser = InputView.inputMoneyOfUser();

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
