package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final String DESCRIPTION = "What is the result of the expression?";

    public static void play() {
        Engine.play(DESCRIPTION, "Calc");
    }

    // Новый метод для генерации раунда
    public static void generateRound() {
        // Генерация случайных чисел от 1 до 20 (можно увеличить диапазон при желании)
        int num1 = (int) (Math.random() * 20) + 1;
        int num2 = (int) (Math.random() * 20) + 1;

        // Выбор случайной операции: 0 -> +, 1 -> -, 2 -> *
        int operatorIndex = (int) (Math.random() * 3);
        String operator = "";
        int result = 0;

        if (operatorIndex == 0) {
            operator = "+";
            result = num1 + num2;
        } else if (operatorIndex == 1) {
            operator = "-";
            result = num1 - num2;
        } else {
            operator = "*";
            result = num1 * num2;
        }

        // Записываем данные в переменные движка
        Engine.currentQuestion = num1 + " " + operator + " " + num2;
        Engine.currentAnswer = String.valueOf(result);
    }
}
