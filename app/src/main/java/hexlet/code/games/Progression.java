package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    // Правила игры
    private static final String DESCRIPTION = "What number is missing in the progression?";

    public static void play() {
        Engine.play(DESCRIPTION, "Progression");
    }

    // Новый метод для генерации раунда
    public static void generateRound() {
        // Арифметическая прогрессия
        // состоит из 3 вещей
        // 1. шаг
        int step = (int) (Math.random() * 10) + 1; // Шаг от 1 до 10
        // 2. начальное значение (старт)
        int start = (int) (Math.random() * 20) + 1; // Стартовое число от 1 до 10

        // полезные переменные в дополнение к 1 и 2
        // общее количество чисел в прогрессии
        int length = (int) (Math.random() * 5) + 5; // Длина от 5 до 10 чисел
        // позиция числа, которую ищет игрок (число какое-нибудь от 0 до 10)
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
                question = question + ".. ";
                correctAnswer = currentElement;
            } else {
                question = question + currentElement + " ";
            }
            i++;
        }

        question = question.trim(); // Убираем лишний пробел в конце

        // Записываем данные в переменные движка
        Engine.currentQuestion = question;
        Engine.currentAnswer = String.valueOf(correctAnswer);
    }
}
