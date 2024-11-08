package live.mukeshtechlab.utils;

import java.util.Random;

public final class DiceUtility {
    private static final Random random = new Random();

    public static int rollDice(int numberOfDice) {

        int min = 1;
        int max = 6;

        int total = 0;

        for (int i = 1; i <= numberOfDice; i++) {
            total += random.nextInt(max - min + 1) + min;
        }

        return total;
    }

}
