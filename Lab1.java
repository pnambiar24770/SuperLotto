/**
 * Lab 1 - SuperLotto
 * Program that creates lotto tickets to a customer
 * @author Pranav Nambiar
 * @date 9/4/2022
 * CS 210
 */

import java.util.*;
public class Lab1 {
    static int numTickets;
    //method that creates array containing ticket numbers
    public static int[] quickPick() {
        int supLotto[] = new int[7];
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            supLotto[i] = rand.nextInt(47 - 1) + 1;
            for (int j = 0; j < i; j++) {
                if (supLotto[i] == supLotto[j])
                    --i;
            }
        }
        supLotto[6] = rand.nextInt(27 - 1) + 1;
        return supLotto;
    }
    //method to print tickets using array from quickPick
    public static void printTicket(int numbers[]){
        for (int i = 0; i < numTickets; i++) {

            for (int j = 0; j < 5; j++) {
                System.out.print(numbers[j] + " ");
            }
                System.out.println("(MEGA: " + numbers[6] + ")");
             numbers = quickPick();
        }
    }
    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String check;
        do {
            System.out.println("Welcome to the Quicky Mart, what is your name?");
            String name = sc.next();
            System.out.println("Hi " + name + ", how many Super Lotto tickets would you like to purchase?");
            numTickets = sc.nextInt();
            int numbers[] = quickPick();
            printTicket(numbers);
            System.out.println("");
            System.out.println("Good luck! Would you like to run the program again?");
            check = sc.next();
        } while (check.equals("yes"));

        System.out.println("Goodbye!");
    }
}
