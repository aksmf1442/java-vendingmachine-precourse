package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;
import vendingmachine.domain.Item;

public class InputView {

    public static int inputMoneyOfVendingMachine() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String money = Console.readLine();
        InputViewValidator.validateNumber(money);
        InputViewValidator.validateDivisibleBy10(money);
        return Integer.parseInt(money);
    }

    public static Map<String, Item> inputItems() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
        String input = Console.readLine();
        input = input.replace("]", "");
        input = input.replace("[", "");
        String[] items = input.split(";");
        return mappingItems(items);
    }

    private static Map<String, Item> mappingItems(String[] originItems) {
        Map<String, Item> items = new HashMap<>();
        for (String item : originItems) {
            String[] splitItem = item.split(",");
            validateItem(splitItem);
            String name = splitItem[0];
            int price = Integer.parseInt(splitItem[1]);
            int amount = Integer.parseInt(splitItem[2]);
            items.put(name, new Item(name, price, amount));
        }
        return items;
    }

    private static void validateItem(String[] item) {
        InputViewValidator.validateItemSize(item);
        String price = item[1];
        String amount = item[2];
        validatePrice(price);
        validateAmount(amount);
    }

    private static void validatePrice(String price) {
        InputViewValidator.validateNumber(price);
        InputViewValidator.validatePriceRange(price);
        InputViewValidator.validateDivisibleBy10(price);
    }

    private static void validateAmount(String amount) {
        InputViewValidator.validateNumber(amount);
        InputViewValidator.validateAmountRange(amount);
    }

    public static int inputMoneyOfUser() {
        System.out.println("투입 금액을 입력해 주세요.");
        String money = Console.readLine();
        InputViewValidator.validateNumber(money);
        return Integer.parseInt(money);
    }
}
