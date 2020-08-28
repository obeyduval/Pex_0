package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	playgame();
    }

    public static void playgame(){
        String username = getusername();
        int magicnum = randomizemagicnumber();
        game(username, magicnum);

    }

    public static String getusername(){

        Scanner in = new Scanner(System.in);

        System.out.print("Welcome to the High-Low Game!\nThe goal of this game is to guess the secret number (1-100)\nEnter your username: ");
        String playername = in.nextLine();

        if(playername.isEmpty()){
            System.out.println("Welcome, Player 1!");
        }else{
            System.out.println("Welcome, " + playername + "!");
        }

        return playername;
    }

    public static void game(String username, int magicnum){
        int totalguesses = 0;
        int games = 0;
        boolean playagain = true;

        while(playagain == true) {
            games++;
            int guesses = 0;
            int guess = 0;
            int prevguess = 0;
            do {
                System.out.print("\nGuess the secret number(1-100): ");

                Scanner number = new Scanner(System.in);
                guess = number.nextInt();

                if(guess > 100 || guess < 0){
                    System.out.println("invalid guess");
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
                guesses++;
                prevguess = guess;
            } while (guess != magicnum);

            totalguesses = guesses + totalguesses;

            Scanner end = new Scanner(System.in);
            System.out.println("Total guesses this game: " + guesses);
            System.out.print("Do you want to play again: ");
            String endgame = end.nextLine();

            if(endgame.equalsIgnoreCase("n") || endgame.equalsIgnoreCase("no")){
                playagain = false;
            }

        }

        double optimal =  (Math.log(100)/Math.log(2));

        System.out.println("Total guesses in all sessions: " + totalguesses);
        System.out.println("Total guesses per game: " + totalguesses/games);
        System.out.printf("Optimal number of guesses per game: %.2f\n", optimal);
        System.out.println("Thanks for playing!");

    }

    public static int randomizemagicnumber(){
        Random number = new Random();

        int magicnum = number.nextInt(100);

        return magicnum;
    }
}
