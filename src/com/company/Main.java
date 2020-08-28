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
        int guesses = guess(username, magicnum);
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

    public static int guess(String username, int magicnum){
        int guesses = 0;
        int guess = 0;
        do {
            System.out.println("\nGuess the secret number(1-100): ");

            Scanner number = new Scanner(System.in);
            guess = number.nextInt();

            if (guess == magicnum) {
                System.out.println("\nYou guessed the secret number!");
            } else if (guess > magicnum) {
                System.out.println("\nYour guess was higher than the secret number :(");
            } else if (guess < magicnum) {
                System.out.println("\nYour guess was lower than the secret number :(");
            }
        }while (guess!=magicnum);

        System.out.println("DEBUGing magic num = " +magicnum);

        return guesses;
    }

    public static int randomizemagicnumber(){
        Random number = new Random();

        int magicnum = number.nextInt(100);

        return magicnum;
    }
}
