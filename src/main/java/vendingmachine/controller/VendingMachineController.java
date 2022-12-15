package vendingmachine.controller;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinMaker;
import vendingmachine.domain.VendingMachineGame;
import vendingmachine.view.InputView;

public class VendingMachineController {

    public void run() {
        VendingMachineGame vendingMachineGame = new VendingMachineGame(createCoins());

    }

    private Map<Coin, Integer> createCoins() {
        int moneyOfVendingMachine = InputView.inputMoneyOfVendingMachine();
        CoinMaker coinMaker = new CoinMaker();
        return coinMaker.createCoins(moneyOfVendingMachine);
    }
}
