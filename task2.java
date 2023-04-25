/**
* Задача 2.
* Вычислить n! (произведение чисел от 1 до n)
*/

import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.printf("Введите число n: ");
        int n = num.nextInt();
        System.out.printf("Факториал числа n: %d\n", getFactorial(n));
        num.close();
    }
    public static int getFactorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}