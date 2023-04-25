/**
* Задача 1.
* Вычислить n-ое треугольного числа (сумма чисел от 1 до n)
*/

import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.printf("Введите число n: ");
        int n = num.nextInt();
        System.out.printf("Треугольное число: %d\n", giveMeNumber(n));
        num.close();
    }
    public static int giveMeNumber(int i) {
        return (i * (i + 1) / 2);
    }
}