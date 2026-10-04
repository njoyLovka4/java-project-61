package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void play() {
        Scanner scanner = new Scanner(System.in);

        // Приветствие и знакомство
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = scanner.next();
        System.out.println("Hello, " + username + "!");

        // Правила игры
        System.out.println("Answer \"yes\" if the number is even, otherwise answer \"no\".");

        // Счетчик правильных ответов
        int correctAnswers = 0;

        // Цикл продолжается, пока игрок не ответит правильно 3 раза
        while (correctAnswers < 3) {
            // Генерация числа от 1 до 100
            int number = (int) (Math.random() * 100) + 1;

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            // Определяем правильный ответ текстом (создается заново на каждой итерации)
            String correctAnswer = "";
            if (number % 2 == 0) {
                correctAnswer = "yes"; // Используем =, а не +=
            } else {
                correctAnswer = "no"; // Используем =, а не +=
            }

            // Проверка ответа пользователя
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswers = correctAnswers + 1; // Увеличиваем счетчик
            } else {
                // Если ответ неверный, выводим ошибку и полностью выходим из метода
                System.out.println(
                        "'"
                                + userAnswer
                                + "' is wrong answer ;(. Correct answer was '"
                                + correctAnswer
                                + "'.");
                System.out.println("Let's try again, " + username + "!");
                return; // Завершает работу метода play()
            }
        }

        // Если игрок успешно прошел 3 раунда
        System.out.println("Congratulations, " + username + "!");
    }
}
