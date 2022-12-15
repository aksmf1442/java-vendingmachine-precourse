package vendingmachine.controller;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinMaker;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public void run() {
        VendingMachine vendingMachine = new VendingMachine(createCoins());
        OutputView.printCoinsStatus(vendingMachine.getCoins());
    }

    private Map<Coin, Integer> createCoins() {
        int moneyOfVendingMachine = InputView.inputMoneyOfVendingMachine();
        CoinMaker coinMaker = new CoinMaker();
        return coinMaker.createCoins(moneyOfVendingMachine);
    }
}
