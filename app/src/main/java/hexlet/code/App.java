package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even"); // Добавили пункт меню
        System.out.println("3 - Calc"); // Добавил в меню калькулятор
        System.out.println("4 - GCD"); // Добавили новый пукнт игры: GCD
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Cli.welcomeUser();
                break;
            case 2:
                Even.play();
                break;
            case 3:
                Calc.play(); // Вызов калькулятора
                break;
            case 4:
                GCD.play(); // Добавили вызов новой игры
            case 0:
                break;
            default:
                System.out.println("Unknown game: " + choice);
                break;
        }

        scanner.close();
    }
}
