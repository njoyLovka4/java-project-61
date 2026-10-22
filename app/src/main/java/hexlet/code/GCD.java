package hexlet.code;

import java.util.Scanner;

public class GCD {
    public static void play() {
        Scanner scanner = new Scanner(System.in);

        // Приветствие и знакомство
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = scanner.next();
        System.out.println("Hello, " + username + "!");

        // Правила игры
        System.out.println("Find the greatest common divisor of given numbers.");

        int correctAnswers = 0;
        final int maxCorrectAnswers = 3;

        // Цикл продолжается, пока игрок не ответит правильно 3 раза
        while (correctAnswers < maxCorrectAnswers) {
            // Генерация двух случайных чисел от 1 до 100
            int num1 = (int) (Math.random() * 100) + 1;
            int num2 = (int) (Math.random() * 100) + 1;

            // Вывод вопроса пользователю
            System.out.println("Question: " + num1 + " " + num2);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            // Алгоритм Евклида для нахождения НОД
            int a = num1;
            int b = num2;
            while (b != 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }

            // Результат НОД в переменной 'a'
            int gcdResult = a;
            String correctAnswer = String.valueOf(gcdResult);

            // Проверка ответа пользователя
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswers = correctAnswers + 1;
            } else {
                // Если ответ неверный, выводим ошибку и полностью выходим из метода
                System.out.println(
                        "'"
                                + userAnswer
                                + "' is wrong answer ;(. Correct answer was '"
                                + correctAnswer
                                + "'.");
                System.out.println("Let's try again, " + username + "!");
                return; // Завершает работу метода play() при ошибке
            }
        }

        // Поздравление при успешном прохождении 3 раундов
        System.out.println("Congratulations, " + username + "!");
    }
}
