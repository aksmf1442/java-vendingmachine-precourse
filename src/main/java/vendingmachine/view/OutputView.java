package vendingmachine.view;

import java.util.Map;
import vendingmachine.domain.Coin;

public class OutputView {

    public static void printCoinsStatus(Map<Coin, Integer> coins) {
        System.out.println("\n자판기가 보유한 동전");

        System.out.println("500원 - " + coins.getOrDefault(Coin.COIN_500, 0) + "개");
        System.out.println("100원 - " + coins.getOrDefault(Coin.COIN_100, 0) + "개");
        System.out.println("50원 - " + coins.getOrDefault(Coin.COIN_50, 0) + "개");
        System.out.println("10원 - " + coins.getOrDefault(Coin.COIN_10, 0) + "개");
    }

    public static void printUserMoney(int userMoney) {
        System.out.println("\n투입 금액: " + userMoney);
    }
}
