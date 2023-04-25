/** Задача 4/
* Реализовать простой калькулятор (введите первое число, введите второе число, введите требуемую операцию, ответ)
*/

import java.util.Scanner;

public class task4 {

    public static void main(String[] args) {
        Scanner operandScanner = new Scanner(System.in);
        Scanner operationScanner = new Scanner(System.in);

        double first = getOperand("Введите первое число:", operandScanner);
        double second = getOperand("Введите второе число:", operandScanner);
        String operation = getOperation(operationScanner, first, second);

        double result;
        switch (operation) {
            case "+" -> {
                result = addition(first, second);
                System.out.println(result);
            }
            case "-" -> {
                result = subtraction(first, second);
                System.out.println(result);
            }
            case "*" -> {
                result = multiplication(first, second);
                System.out.println(result);
            }
            case "/" -> {
                result = division(first, second);
                System.out.println(result);
            }
            default -> System.out.println("Такой операции нет ;(");
        }
    }

    private static String getOperation(Scanner operationScanner, double first_operand, double second_operand) {
        System.out.printf("Какую операцию выполнить над \"%f ? %f\"?\nДоступные операции: +, -, *, /\n",
                first_operand, second_operand);
        return operationScanner.nextLine();
    }

    private static double getOperand(String invitation, Scanner operandScanner) {
        System.out.println(invitation);
        return  operandScanner.nextDouble();
    }

    static double addition(double first, double second) {
        return first + second;
    }

    static double subtraction(double first, double second) {
        return first - second;
    }

    static double multiplication(double first, double second) {
        return first * second;
    }

    static double division(double first, double second) {
        return first / second;
    }
}