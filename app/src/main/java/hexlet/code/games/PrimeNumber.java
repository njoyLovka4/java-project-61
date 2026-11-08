package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeNumber {
    // Правила игры
    private static final String DESCRIPTION =
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void play() {
        Engine.play(DESCRIPTION, "PrimeNumber");
    }

    // Новый метод для генерации раунда
    public static void generateRound() {
        // Генерируем случайное число от 1 до 50
        int number = (int) (Math.random() * 50) + 1;

        // Базовый ответ - число простое
        String correctAnswer = "yes";

        // Шаг 1: 0 и 1 не простое! Если число меньше 2, то оно точно не простое
        if (number < 2) {
            correctAnswer = "no";
            // Шаг 2: Если число равно 2, то оно простое (ответ "yes" уже стоит)
        } else if (number == 2) {
            correctAnswer = "yes";
            // Шаг 4: Если число чётное (делится на 2), оно не может быть простым
        } else if (number % 2 == 0) {
            correctAnswer = "no";
            // Шаг 5: Для всех остальных нечётных чисел проверяем делители
        } else {
            // Начинаем проверку с 3, так как двойку мы уже проверили выше
            int divider = 3;

            // Делаем проверку только пока квадрат делителя не превысит наше число
            // Эта часть заменяет поиск квадратного корня
            while (divider * divider <= number) {
                // Если число разделилось на этот нечётный делитель нацело
                if (number % divider == 0) {
                    correctAnswer = "no";
                }
                // Идем только по нечётным числам (3, 5, 7...), прибавляя по 2
                divider = divider + 2;
            }
        }

        // Записываем данные в переменные движка
        Engine.currentQuestion = String.valueOf(number);
        Engine.currentAnswer = correctAnswer;
    }
}
