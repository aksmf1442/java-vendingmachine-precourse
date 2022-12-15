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
        Map<String, Item> items = InputView.inputItems();
        VendingMachine vendingMachine = new VendingMachine(coins, items);

        
    }

    private Map<Coin, Integer> createCoins() {
        int moneyOfVendingMachine = InputView.inputMoneyOfVendingMachine();
        CoinMaker coinMaker = new CoinMaker();
        Map<Coin, Integer> coins = coinMaker.createCoins(moneyOfVendingMachine);
        OutputView.printCoinsStatus(coins);
        return coins;
    }
}
