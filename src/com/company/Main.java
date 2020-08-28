package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	playgame();
    }

    public static void playgame(){
        String username = getusername();
    }

    public static String getusername(){

        Scanner in = new Scanner(System.in);

        System.out.print("Welcome to the High-Low Game!\nThe goal of this game is to guess the secret number (1-100)\nEnter your username:");
        String playername = in.nextLine();

        if(playername.isEmpty()){
            System.out.println("Welcome, Player 1!");
        }else{
            System.out.println("Welcome, " + playername + "!");
        }

        return playername;
    }
}
