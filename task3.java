/**
* Задача 3.
* Выведите все простые числа от 1 до 1000 (числа, которые делятся только на 1 и на себя без остатка)
*/

import java.util.Arrays;
import java.util.Scanner;

public class task3 {

    public static void main(String[] args) {
        int inputtedNumber = getUserNumber();
        int[] arraySimples = getSimples(inputtedNumber);
        showSimples(inputtedNumber, arraySimples);
    }


    static int getUserNumber() {
        System.out.printf("Укажите границу поиска простых чисел: ");
        try (Scanner number = new Scanner(System.in)) {
            return number.nextInt();
        }
    }


    static int[] getSimples(int stopSearch) {
        
        int[] resultArray = new int[]{};
        
        if (stopSearch <= 1) {
            return resultArray;
        }

        for (int currentNumber = 2; currentNumber <= stopSearch ; currentNumber++) {
            boolean isSimple = true;
            for (int divider = 2; divider < currentNumber / 2 - 1; divider++) {
                if (currentNumber % divider == 0 && currentNumber != 2) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) {
                resultArray = Arrays.copyOf(resultArray, resultArray.length + 1);
                resultArray[resultArray.length - 1] = currentNumber;
            }
        }

        return resultArray;
    }

    static void showSimples(int upperBound, int[] simples) {
        String choice = simples.length != 0 ? Arrays.toString(simples) : "отсутствуют";
        String prettyTextFormat = String.format("Простые числа в диапазоне до %s: %s", upperBound, choice);
        System.out.println(prettyTextFormat);
    }
}