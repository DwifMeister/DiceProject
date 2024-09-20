package opgave01;

import java.util.Scanner;

public class RollTwoDice {

    private static int rollCount = 0;
    private static int totalRollSum = 0;
    private static int pairsCount = 0;
    private static int highestRoll = 0;
    private static int[] eyesCounter = new int [6];



    public static void main(String[] args) {
        System.out.println("welcome to the game, roll two dice");
        printRules();
        System.out.println();

        playWithDice();

        System.out.println();
        System.out.println("Thanks for playing!");
    }

    private static void printRules() {
        System.out.println("\n-----------------------------------------------------");
        System.out.println("\nthe player rolls two dice.");
        System.out.println("\nThe dice can be rolled as long as you want.");
        System.out.println("\n-----------------------------------------------------");
    }

    private static void playWithDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll the dice? If yes press [enter] if no, type no and press [enter]");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] faces = rollDice();
            System.out.println("You rolled: ");
            System.out.println("Die 1: " + faces[0]);
            System.out.println("Die 2: " + faces[1]);

            System.out.println();

            updateStatistics(faces);

            System.out.println("Roll the dice? If yes, press [enter]. If no, type no and press [enter]");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] faces = new int[2];
        faces[0] = (int) (Math.random() * 6 + 1);
        faces[1] = (int) (Math.random() * 6 + 1);

        return faces;
    }

    private static void updateStatistics(int[] temp) {
        rollCount++;
        totalRollSum += temp[0] + temp[1];
        if (temp[0] == temp[1]) {
            pairsCount++;
        }
        if (highestRoll < temp[0] + temp[1]) {
            highestRoll = temp[0] + temp[1];
        }
        for (int i = 0; i < temp.length; i++) {
            eyesCounter[temp[i]-1]++;
        }

    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("---------------------------------");
        System.out.printf("\n%10s %2d\n", "Number of rolls:", rollCount);
        System.out.println("\nThe total sum of all rolls are: " + totalRollSum);
        System.out.println("\nPairs have been rolled " + pairsCount + " times.");
        System.out.println("\nThe highest roll is: " + highestRoll);
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.println((i+1) + " has been rolled " + eyesCounter[i] + " times");

        }
    }
}

