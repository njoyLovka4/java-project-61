package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String DESCRIPTION =
            "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void play() {
        Engine.play(DESCRIPTION, "Even");
    }

    // Новый метод для генерации раунда
    public static void generateRound() {
        // Генерация числа от 1 до 100
        int number = (int) (Math.random() * 100) + 1;

        Engine.currentQuestion = String.valueOf(number);

        // Определяем правильный ответ текстом (создается заново на каждой итерации)
        if (number % 2 == 0) {
            Engine.currentAnswer = "yes"; // используем =, а не ==
        } else {
            Engine.currentAnswer = "no"; // используем =, а не ==
        }
    }
}
