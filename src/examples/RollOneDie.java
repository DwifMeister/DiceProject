package examples;

import java.util.Scanner;

public class RollOneDie {
    private static int rollCount = 0;

    public static void main(String[] args) {
        System.out.println("welcome to the game, roll one die");
        printRules();
        System.out.println();

        playOneDie();

        System.out.println();
        System.out.println("Thanks for playing!");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("the player rolls a die.");
        System.out.println("The die can be rolled as long as you want.");
        System.out.println("=====================================================");
    }

    private static void playOneDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll a die? If yes press [enter] if no, type no and press [enter]");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int face = rollDie();
            System.out.println("You rolled: " + face);
            System.out.println();

            updateStatistics();
            System.out.println("Roll a die? If yes press [enter] if no, type no and press [enter]");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static void updateStatistics() {
        rollCount++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Rolls:", rollCount);
    }

}
