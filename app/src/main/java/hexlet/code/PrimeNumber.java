package hexlet.code;

import java.util.Scanner;

public class PrimeNumber {
    public static void play() {
        Scanner scanner = new Scanner(System.in);

        // Приветствие и знакомство
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");

        // Правила игры
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        // Счетчик правильных ответов
        int correctAnswers = 0;
        final int maxCorrectAnswers = 3;

        // Цикл продолжается, пока игрок не ответит правильно 3 раза
        while (correctAnswers < maxCorrectAnswers) {
            // Генерируем случайное число от 1 до 50
            int number = (int) (Math.random() * 50) + 1;

            // Базовый ответ — число простое
            String correctAnswer = "yes";

            // Шаг 1 и 2 из Хекслета: Если число меньше 2, то оно точно не простое
            if (number < 2) {
                correctAnswer = "no";
            }
            // Шаг 3: Если число ровно 2, то оно простое (ответ "yes" уже стоит)
            else if (number == 2) {
                correctAnswer = "yes";
            }
            // Шаг 4: Если число чётное (делится на 2), оно не может быть простым
            else if (number % 2 == 0) {
                correctAnswer = "no";
            }
            // Шаг 5: Для всех остальных нечётных чисел проверяем делители
            else {
                // Начинаем проверку с 3, так как двойку мы уже проверили выше
                int divider = 3;

                // Делает проверку только пока квадрат делителя не превысит наше число
                // Это часть заменяет поиск квадратного корня
                while (divider * divider <= number) {
                    // Если число разделилось на этот нечётный делитель нацело
                    if (number % divider == 0) {
                        correctAnswer = "no";
                    }
                    // Идем только по нечетным числам (3, 5, 7...), прибавляя по 2
                    divider = divider + 2;
                }
            }

            // Вывод вопроса пользователю
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

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
                return; // Завершает работу метода play() при ошибке
            }
        }

        // Поздравление при успешном прохождении 3 раундов
        System.out.println("Congratulations, " + username + "!");
    }
}
