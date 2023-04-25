/** Задача 5 (со звездочкой).
* Задано уравнение вида q + w = e; при этом q, w, e >= 0.
* Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
* Требуется восстановить выражение до верного равенства. Предложить хотя бы одно
* решение или сообщить, что его нет.
*/

import java.util.Scanner;

public class task5 {

    public static void main(String[] args) {
        String expression = getUserExpression();
        String reconstructExpression = getReconstructedExpression(expression);
        System.out.println(reconstructExpression);
    }

    static String getUserExpression() {
        StringBuilder prettyInvitationText = new StringBuilder();
        prettyInvitationText.append("Введите уравнение вида: q + w = e; при этом q, w, e >= 0.");
        prettyInvitationText.append("Некоторые цифры могут быть заменены знаком вопроса (2? + ?5 = 69)");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.printf("%s\n>>> ", prettyInvitationText);
            return scanner.nextLine();
        }
    }

    static String getReconstructedExpression(String expression) {
        int middleOf = expression.indexOf('+');
        int endOf = expression.indexOf('=');

        String leftOperandString = expression.substring(0, middleOf).trim();
        String rightOperandString = expression.substring(middleOf + 1, endOf).trim();
        String resultOfExpressionString = expression.substring(endOf + 1).trim();
        int resultOfExpression = Integer.parseInt(resultOfExpressionString);

        return reconstruction(leftOperandString, rightOperandString, resultOfExpression);
    }

    static String reconstruction(String left, String right, int result) {
        int[] digits = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        CharSequence from = "?";
        for (int digitOfLeft : digits) {
            // Заменяем пропущенную цифру на очередную из массива и преобразуем к числу:
            CharSequence toLeft = Integer.toString(digitOfLeft);
            int tempLeft = Integer.parseInt(left.replace(from, toLeft));
            // Находим разницу результата выражения и очередного варианта левого операнда выражения. Сравниваем
            // попозиционно "очередную разницу" с правым операндом, для этого подставим в разницу символ
            // пропущенной цифры '?' на соответсвующую позицию:
            String temp = Integer.toString(result - tempLeft);
            int missingIndex = right.indexOf('?');
            if (missingIndex != -1 && temp.replace(temp.charAt(missingIndex), '?').equals(right)) {
                // Если все символы кроме пропущенной цифры совпали, то возвращаем результат работы:
                return String.format("%d + %s = %d", tempLeft, temp, result);
            } else if (temp.equals(right)) {
                return String.format("%s + %s = %d", left, temp, result);
            }
        }
        // Если не удалось найти пропущенные цифры, сообщаем об этом
        return String.format("Не удалось восстановить уравнение: %s + %s = %d", left, right, result);
    }
}