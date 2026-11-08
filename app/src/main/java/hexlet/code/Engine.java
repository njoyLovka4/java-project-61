package hexlet.code;

import hexlet.code.games.*;
import java.util.Scanner;

public class Engine {
    public static final int MAX_ROUNDS = 3;
    public static String currentQuestion = "";
    public static String currentAnswer = "";

    public static void play(String description, String gameName) {
        Scanner scanner = new Scanner(System.in);

        // Приветствие и знакомство
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");

        // Правила игры
        System.out.println(description);

        // Счетчик правильных ответов
        int correctAnswers = 0;
        final int maxCorrectAnswers = 3;

        // Цикл продолжается, пока игрок не ответит правильно 3 раза
        for (int i = 0; i < MAX_ROUNDS; i++) {

            // Запрашиваем генерацию раунда у нужной игры
            if (gameName.equals("Even")) {
                Even.generateRound();
            } else if (gameName.equals("Calc")) {
                Calc.generateRound();
            } else if (gameName.equals("GCD")) {
                GCD.generateRound();
            } else if (gameName.equals("Progression")) {
                Progression.generateRound();
            } else if (gameName.equals("PrimeNumber")) {
                PrimeNumber.generateRound();
            }

            // Вывод вопроса пользователю
            System.out.println("Question: " + currentQuestion);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            // Проверка ответа пользователя
            if (userAnswer.equals(currentAnswer)) {
                System.out.println("Correct!");
                correctAnswers = correctAnswers + 1; // Увеличиваем счетчик
            } else {
                // Если ответ неверный, выводим ошибку и полностью выходим из метода
                System.out.println(
                        "'"
                                + userAnswer
                                + "' is wrong answer ;(. Correct answer was '"
                                + currentAnswer
                                + "'.");
                System.out.println("Let's try again, " + username + "!");
                return; // Завершает работу метода play() при ошибке
            }
        }

        // Поздравление при успешном прохождении 3 раундов
        System.out.println("Congratulations, " + username + "!");
    }
}
