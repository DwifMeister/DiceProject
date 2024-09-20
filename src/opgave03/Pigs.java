package opgave03;

import java.util.Scanner;

public class Pigs {
    Scanner scanner = new Scanner(System.in);
    private static int rollCount = 0;
    private static int eyes = 0;
    private static int sumOfEyes = 0;
    private static int[] playerscore = new int[2];
    private int target = scanner.nextInt();

    public static void main(String[] args) {
        System.out.println("\nWelcome to the game, Pigs");
        printRules();
        System.out.println();

        playPigs();

        System.out.println();
        System.out.println("Thanks for playing!");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("The player rolls two dice and tries to get to their target first.");
        System.out.println("The die can be rolled as long as you want, or unti you roll a one.");
        System.out.println("If you roll two ones (snake eyes) you all your points not just the round points");
        System.out.println("=====================================================");
    }

    private static void playPigs() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press [enter] to roll: ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int [] faces = rollDice();
            System.out.println("\nYou rolled: " + faces[0] + " and " + faces[1]);
            System.out.println();

            updateStatistics();

            System.out.println("Press [enter] to roll");
            System.out.println("------------------------------");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int [] rollDice() {
       int[] faces = {(int) (Math.random()*6+1), (int) (Math.random()*6+1)};
        return faces;
    }

    private static void playerSwitch(String []players){


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
