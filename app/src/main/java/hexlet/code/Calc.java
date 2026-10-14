package hexlet.code;

import java.util.Scanner;

public class Calc {
    public static void play() {
        Scanner scanner = new Scanner(System.in);

        // Приветствие и знакомство
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = scanner.next();
        System.out.println("Hello, " + username + "!");

        // Правила игры
        System.out.println("What is the result of the expression?");

        int correctAnswers = 0;
        final int maxCorrectAnswers = 3;

        while (correctAnswers < maxCorrectAnswers) {
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

            // Вывод вопроса пользователю
            System.out.println("Question: " + num1 + " " + operator + " " + num2);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            String correctAnswer = String.valueOf(result);

            // Проверка ответа
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswers = correctAnswers + 1;
            } else {
                System.out.println(
                        "'"
                                + userAnswer
                                + "' is wrong answer ;(. Correct answer was '"
                                + correctAnswer
                                + "'.");
                System.out.println("Let's try again, " + username + "!");
                return; // Выходим из метода, завершая игру
            }
        }

        // Поздравление при успешном прохождении 3 раундов
        System.out.println("Congratulations, " + username + "!");
    }
}
