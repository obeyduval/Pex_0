package com.company;

// for scanner library
import java.util.Scanner;
// for random library
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	playgame();
    } //main play game abstracted view

    //process of game
    public static void playgame(){
        //gets username to use throughout playtime
        String username = getusername();
        //randomizes number
        int magicnum = randomizemagicnumber();
        //starts guessing process and handles replays
        game(username, magicnum);

    }

    public static String getusername(){
        // create scanner object for username
        Scanner in = new Scanner(System.in);

        //Introduce player and ask for username
        System.out.print("Welcome to the High-Low Game!\nThe goal of this game is to guess the secret number (1-100)\nEnter your username: ");
        String playername = in.nextLine();

        //Verify username and prep to play game
        if(playername.isEmpty()){
            System.out.println("Welcome, Player 1!");
        }else{
            System.out.println("Welcome, " + playername + "!");
        }

        return playername; // return name
    }

    public static void game(String username, int magicnum){
        //initialize total guesses and games for whole session
        int totalguesses = 0;
        int games = 0;
        boolean playagain = true;

        // start individual game loop
        while(playagain) {
            // keeps tab of total games
            games++;
            // gets number of guesses for this play through
            int guesses = 0;
            //holds player's guess
            int guess = 0;
            //holds player's previous guess for unique messages
            int prevguess = 0;

            // base game loop
            do {
                // ask for guess
                System.out.print(username + ", Guess the secret number(1-100): ");

                // create scanner for user guess
                Scanner number = new Scanner(System.in);
                guess = number.nextInt();

                // evaluate guess
                if(guess > 100 || guess < 1){
                    System.out.println("invalid guess (must be in between 1 and 100)");
                } else if (guess == magicnum) {
                    System.out.println("\nYou guessed the secret number!");
                } else if (guess > magicnum) {
                    if (guess > prevguess && guesses > 0 && prevguess > magicnum) {
                        System.out.println("\nYou guessed higher again loserrr!");
                    } else {
                        System.out.println("\nYour guess was higher than the secret number :(");
                    }
                } else if (guess < magicnum) {
                    if (guess < prevguess && guesses > 0 && prevguess < magicnum) {
                        System.out.println("\nYou guessed lower again loserrr!");
                    } else {
                        System.out.println("\nYour guess was lower than the secret number :(");
                    }
                }
                // keep track of guesses this game
                guesses++;
                // store this guess as previous guess for next loop
                prevguess = guess;
                //check if player has won
            } while (guess != magicnum);

            totalguesses = guesses + totalguesses;

            Scanner end = new Scanner(System.in);
            System.out.println("Total guesses this game: " + guesses);

            //check if player wants to play again
            System.out.print("Do you want to play again: ");
            String endgame = end.nextLine();
            int i = 0;
            do {
                if (endgame.equalsIgnoreCase("n") || endgame.equalsIgnoreCase("no")) {
                    playagain = false;
                    i++;
                } else if (endgame.equalsIgnoreCase("y") || endgame.equalsIgnoreCase("yes")){
                    playagain = true;
                    i++;
                }else {
                    System.out.print("Do you want to play again: ");
                    endgame = end.nextLine();
                }
            }while(i == 0);
        }

        double optimal =  (Math.log(100)/Math.log(2));

        // endgame output
        System.out.println("\nTotal guesses in all sessions: " + totalguesses);
        System.out.println("Total guesses per game: " + totalguesses/games);
        System.out.printf("Optimal number of guesses per game: %.2f\n", optimal);
        System.out.println("Thanks for playing " + username + "!");

    }

    // gets random number for game
    public static int randomizemagicnumber(){
        Random number = new Random();

        int magicnum = number.nextInt(100);

        return magicnum;
    }
}
