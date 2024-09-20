package opgave02;

import java.util.Scanner;

public class Craps {

    private static int rollCount = 0;
    private static int[] faces = new int[2];
    private static int point = 0;
    private static int timesWon = 0;
    private static int timesLost = 0;
    private static int eyes = 0;
    private static int totalRolls = 0;


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
        System.out.print("Press [enter] to play: ");
        String answer = scanner.nextLine();
        boolean winCon = true;

        while (!answer.equals("stop")) {
            int[] faces = rollDice();
            eyes = faces[0] + faces[1];
            System.out.println("\nYou rolled: " + eyes);
            System.out.println();
            updateStatistics(faces);

            if (rollCount == 1 && eyes == 7 || rollCount == 1 && eyes == 11) {
                endText(winCon);
                answer = scanner.nextLine();
            } else if (rollCount == 1 && eyes == 2 || rollCount == 1 && eyes == 3 || rollCount == 1 && eyes == 12) {
                endText(!winCon);
                answer = scanner.nextLine();
            } else if (rollCount == 1) {
                point = eyes;
                System.out.println(point + " Is your point.");
                System.out.printf("%10s", "-------------------------");
            }

            rollForPoint(point);
            answer = scanner.nextLine();
        }
        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] faces = {(int) (Math.random() * 6 + 1), (int) (Math.random() * 6 + 1)};
        return faces;
    }


    private static boolean rollForPoint(int point){
        boolean winCon = true;
        if (rollCount > 1 && eyes != point && eyes != 7) {
            System.out.println(eyes + " is not your point.");
            System.out.printf("%10s", "-------------------------");
            System.out.println("\nPress [enter] to roll again");
        }
        if (rollCount > 1 && eyes == 7)
            endText(!winCon);

        if (rollCount > 1 && eyes == point) {
            endText(winCon);
        }
        return true;
    }
    private static void endText(boolean winCon) {
        if (winCon) {
            System.out.println("\nWinner winner, chicken dinner");
            System.out.println();
            timesWon++;
        } else if (!winCon)
            System.out.println("\nSorry, you lost!");
        System.out.println();
        timesLost++;
        System.out.print("Press [enter] to play again, or type stop and press [enter] to stop: ");
        rollCount = 0;
        point = 0;
    }


    private static void updateStatistics(int[] temp) {
        rollCount++;
        totalRolls++;
    }


    private static void printStatistics() {
        System.out.println("\n-------- Results.--------");
        System.out.println("\nYou have won " + timesWon + " times");
        System.out.println("\nYou have lost " + timesLost + " times");
        System.out.println("\nyou rolled: " + totalRolls + " times.");
        System.out.printf("-------------------------");
    }
}
