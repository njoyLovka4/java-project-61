package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    // Правила игры
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void play() {
        Engine.play(DESCRIPTION, "GCD");
    }

    // Новый метод для генерации раунда
    public static void generateRound() {
        // Генерация двух случайных чисел от 1 до 100
        int num1 = (int) (Math.random() * 100) + 1;
        int num2 = (int) (Math.random() * 100) + 1;

        // Вызов нового метода для поиска НОД
        int gcdResult = findGcd(num1, num2);

        // Записываем данные в переменные движка (переводим числа в текст)
        Engine.currentQuestion = num1 + " " + num2;
        Engine.currentAnswer = String.valueOf(gcdResult);
    }

    // Новый вспомогательный метод для алгоритма Евклида
    private static int findGcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
