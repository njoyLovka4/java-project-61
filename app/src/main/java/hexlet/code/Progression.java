package hexlet.code;

import java.util.Scanner;

public class Progression {
    public static void play() {
        Scanner scanner = new Scanner(System.in);

        // Приветствие и знакомство
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");

        // Правила игры
        System.out.println("What number is missing in the progression?");

        // Счетчик правильных ответов
        int correctAnswers = 0;
        final int maxCorrectAnswers = 3;

        // Цикл продолжается, пока игрок не ответит правильно 3 раза
        while (correctAnswers < maxCorrectAnswers) {
            // Арифметическая прогрессия
            // состоит из 2 вещей
            //  1. шаг
            int step = (int) (Math.random() * 10) + 1; // Шаг от 1 до 10
            //  2. начальное значение
            int start = (int) (Math.random() * 20) + 1; // Стартовое число от 1 до 20

            // полезные переменные в дополнение к 1 и 2
            // общее количество чисел в прогрессии
            int length = (int) (Math.random() * 6) + 5; // Длина от 5 до 10 чисел
            // позиция числа, которое ищет игрок (какое нибудь от 0 до 10)
            int hiddenIndex = (int) (Math.random() * length);
            // вопрос
            String question = "";
            // правильный ответ
            int correctAnswer = 0;

            // Генерируем числа и сразу строим строку вопроса в одном цикле
            int i = 0;
            while (i < length) {
                int currentElement = start + i * step;

                if (i == hiddenIndex) {
                    question += ".. ";
                    correctAnswer = currentElement;
                } else {
                    question += currentElement + " ";
                }
                i++;
            }
            question = question.trim(); // Убираем лишний пробел в конце

            // Вывод вопроса пользователю
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            String correctAnswerStr = String.valueOf(correctAnswer);

            // Проверка ответа пользователя
            if (userAnswer.equals(correctAnswerStr)) {
                System.out.println("Correct!");
                correctAnswers = correctAnswers + 1; // Увеличиваем счетчик
            } else {
                // Если ответ неверный, выводим ошибку и полностью выходим из метода
                System.out.println(
                        "'"
                                + userAnswer
                                + "' is wrong answer ;(. Correct answer was '"
                                + correctAnswerStr
                                + "'.");
                System.out.println("Let's try again, " + username + "!");
                return; // Завершает работу метода play() при ошибке
            }
        }

        // Поздравление при успешном прохождении 3 раундов
        System.out.println("Congratulations, " + username + "!");
    }
}
