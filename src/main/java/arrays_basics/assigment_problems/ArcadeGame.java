package arrays_basics.assigment_problems;

import java.util.*;

public class ArcadeGame{
    public static void main(String[] args) {
        String[] choices = {"rock", "paper", "scissors"}; // which is better list or the array?
        //list of new items

        
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        int wins = 0;
        int losses = 0;
        int draws = 0;
        int totalRounds = 5;
        
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");
        
        // Loop for N rounds (suggested N=5)
        for (int i = 1; i <= totalRounds; i++) {
            System.out.print("Enter your move (rock/paper/scissors): ");
            String playerMove = scanner.nextLine().toLowerCase().trim();
            
            // Validate input
            while (!java.util.Arrays.asList(choices).contains(playerMove)) {
                System.out.print("Invalid input. Please enter rock, paper, or scissors: ");
                playerMove = scanner.nextLine().toLowerCase().trim();
            }
            String computerMove = choices[random.nextInt(3)]; // Generate computer's move randomly
            
            String result = playRound(playerMove, computerMove);
            System.out.println("Round " + i + " | " + playerMove + " | " + computerMove + " | " + result);
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }
        
        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.println("\nFinal Summary (after " + totalRounds + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}
