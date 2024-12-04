package RockPaperScissor;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        this.playerChoice(sc);
        System.out.println("See ya");
        sc.close();
    }

    private void playerChoice(Scanner sc) {
        this.showChoices();
        int choice = sc.nextInt();
        int comChoice = this.comChoice();

        if (choice > 3 || choice < 1) {
            System.out.println("Invalid Choice");
            playerChoice(sc);
            return;
        }

        this.printChoices(choice, comChoice);

        if (choice == comChoice) {
            System.out.println("Draw!!!");
        } 
        else {            
            if (choice == 1 && comChoice == 2) {
                System.out.println("Computer Wins!!!");
            } 
            else if (comChoice == 1 && choice == 2) {
                System.out.println("Player Wins!!");
            } 
            else if (comChoice == 1 && choice == 3) {
                System.out.println("Computer Wins!!!");
            } 
            else if (choice == 1 && comChoice == 3) {
                System.out.println("Player Wins");
            } 
            else if (choice == 2 && comChoice == 3) {
                System.out.println("Computer Wins!!!");
            } 
            else if (comChoice == 2 && choice == 3) {
                System.out.println("Player Wins!!!");
            }
        }

        if (this.playAgain(sc))
            playerChoice(sc);
    }

    private boolean playAgain(Scanner sc) {
        System.out.print("Wanna play again ? Choose [Y/N] : ");
        char choice = Character.toUpperCase(sc.next().charAt(0));
        System.out.println();

        if (choice != 'Y' && choice != 'N') {
            System.out.println("Invalid Choice");
            return playAgain(sc);
        }

        return choice == 'Y';
    }

    private int comChoice() {
        return new Random().nextInt(1, 4);
    }

    private void printChoices(int choice, int comChoice) {
        System.out.println("You chose : " + Choices.getVal(choice));
        System.out.println("Computer chose : " + Choices.getVal(comChoice));
    }

    private void showChoices() {
        System.out.println("Choose One");
        Choices[] choices = Choices.values();
        for (Choices choice : choices) {
            System.out.println("Enter " + choice.getVal() + " for " + choice);
        }
    }

}
