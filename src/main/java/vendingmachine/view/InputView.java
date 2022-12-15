package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputMoneyOfVendingMachine() {
        String money = Console.readLine();
        InputViewValidator.validateNumber(money);
        InputViewValidator.validateDivisibleBy10(money);
        return Integer.parseInt(money);
    }
}
