package opgave02;

import java.util.Scanner;

public class Craps {

    private static int rollCount = 0;
    private static int[] faces = new int[2];
    private static int point = 0;
    private static int timesWon = 0;
    private static int timesLost = 0;
    private static int eyes = 0;


    public static void main(String[] args) {
        System.out.println("\nwelcome to the game of Craps");
        printRules();
        System.out.println();

        playCraps();

        System.out.println();
        System.out.println("Thanks for playing!");
    }

    private static void printRules() {
        System.out.println("\n-----------------------------------------------------");
        System.out.println("\nIn Craps you roll the dice until you win, or decide to stop");
        System.out.println("\n-----------------------------------------------------");
    }

    private static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("press [enter] to play: ");
        String answer = scanner.nextLine();

        while (!answer.equals("stop")) {
            int[] faces = rollDice();
            eyes = faces[0] + faces[1];
            System.out.println("You rolled: " + eyes);
            System.out.println();
            updateStatistics(faces);

            if (rollCount == 1 && eyes == 7 || rollCount == 1 && eyes == 11) {
                endText(true);
                answer = scanner.nextLine();
            } else if (rollCount == 1 && eyes == 2 || rollCount == 1 && eyes == 3 || rollCount == 1 && eyes == 12) {
                endText(false);
                answer = scanner.nextLine();

            } else if (rollCount == 1) {
                point = eyes;
                System.out.println(point + " Is your point.");
                answer = scanner.nextLine();
            }

            if (eyes != point) {
                System.out.println(eyes + " is not your point.");
                System.out.println("Press [enter] to roll again");
                answer = scanner.nextLine();
            }
            if (rollCount > 1 && eyes == 7)
                endText(false);

            if (eyes == point && rollCount > 1) {
                endText(true);
            }
            answer = scanner.nextLine();
        }
        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] faces = {(int) (Math.random() * 6 + 1), (int) (Math.random() * 6 + 1)};
        return faces;
    }


    private static void endText(boolean string) {
        if (true) {
            System.out.println("\nWinner winner, chicken dinner");
            timesWon++;
            System.out.println("Press [enter] to play again, or type stop and press [enter] to stop");

        } else if (false)
            System.out.println("\nSorry you lost");
        timesLost++;
        System.out.println("Press [enter] to play again, or type stop and press [enter] to stop");
    }


    private static void updateStatistics(int[] temp) {
        rollCount++;
    }


    private static void printStatistics() {
        System.out.println("\nResults.");
        System.out.printf("%17s", "---------------");
        System.out.println("\nYou have won " + timesWon + " times");
        System.out.println("\nYou have lost " + timesLost + " times");
        System.out.println("\nyou rolled: " + rollCount + " times.");
        System.out.printf("%17s", "---------------");
        System.out.println("\nPress [enter] to play again.");
    }
}
