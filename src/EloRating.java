import java.lang.Math;
import java.util.Scanner;

public class EloRating {

    // Function to calculate the Probability
    public static double Probability(int rating1, int rating2) {
        // Calculate and return the expected score
        return 1.0 / (1 + Math.pow(10, (rating1 - rating2) / 400.0));
    }

    // Function to calculate Elo rating
    // K is a constant.
    // outcome determines the outcome: 1 for Player A win, 0 for Player B win, 0.5 for draw.
    public static void EloRating(double Ra, double Rb, int K, double outcome) {
        // Calculate the Winning Probability of Player B
        double Pb = Probability((int) Ra, (int) Rb);

        // Calculate the Winning Probability of Player A
        double Pa = Probability((int) Rb, (int) Ra);

        // Update the Elo Ratings
        Ra = Ra + K * (outcome - Pa);
        Rb = Rb + K * ((1 - outcome) - Pb);

        // Print updated ratings
        System.out.println("Updated Ratings:-");
        System.out.println("Ra = " + Math.round(Ra) + " Rb = " + Math.round(Rb));
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);  // Create a Scanner object

        // Current ELO ratings
        System.out.print("Player A Rating: ");
        double Ra = input.nextInt();
        System.out.print("Player B Rating: ");
        double Rb = input.nextInt();

        // K is a constant
        int K = 16;

        // Outcome: 1 for Player A win, 0 for Player B win, 0.5 for draw
        System.out.print("Outcome of Duel, 1 for Player A Win, 0.5 for Draw, 0 for Player B Win: ");
        double outcome = input.nextDouble();

        // Function call
        EloRating(Ra, Rb, K, outcome);

    }
}