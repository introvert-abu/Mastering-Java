package TicTacToe;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private char[][] board;
    private Set<Integer> player;
    private Set<Integer> com;

    public Game() {
        this.board = new char[3][3];
        this.player = new HashSet<>();
        this.com = new HashSet<>();
    }
    
    public void startGame() {
        this.setBoard();
        Scanner sc = new Scanner(System.in);
        this.nextMove(sc, new Random());
        this.startAgain(sc);
        sc.close();
    }

    private void startAgain(Scanner sc) {
        System.out.println("Wanna Play Again? ");
        System.out.print("Enter Y/N : ");
        char choice = sc.next().charAt(0);
        System.out.println();
        if (Character.toUpperCase(choice) == 'Y') {
            this.com.clear();
            this.player.clear();
            this.startGame();
        } else if (Character.toUpperCase(choice) == 'N') {
            System.out.println("See ya!!!");
        } else {
            System.out.println("Invalid choice");
            startAgain(sc);
        }
    }

    private void nextMove(Scanner sc, Random random) {
        this.printGame();
        
        System.out.println("Choose spot");
        System.out.print("Enter row : ");
        int row = sc.nextInt();
        System.out.println();
        System.out.print("Enter col : ");
        int col = sc.nextInt();
        System.out.println();
        if (!isValid(row, col)) nextMove(sc, random);

        if (this.board[row][col] == '-') {
            this.board[row][col] = 'X';
            this.player.add(row * 3 + col);
            if (this.checkWin(this.player)) {
                printGame();
                System.out.println("Player Won!!!");
                return;
            }
            if (this.gameOver()) {
                this.printGame();
                System.out.println("Draw!!!");
                return;
            }
            if (this.comMove(random))
                return;
            if (this.gameOver()) {
                this.printGame();
                System.out.println("Draw!!!");
                return;
            }
            nextMove(sc, random);
        } else {
            System.out.println("Invalid Move");
            nextMove(sc, random);
        }
    }

    private boolean gameOver() {
        return this.com.size() + this.player.size() == 9;
    }

    private boolean comMove(Random random) {
        int r = random.nextInt(3);
        int c = random.nextInt(3);
        if (this.board[r][c] == '-') {
            this.board[r][c] = 'O';
            this.com.add(r * 3 + c);
            if (this.checkWin(this.com)) {
                System.out.println("Computer won!!!");
                return true;
            }
        } else {
            comMove(random);
        }

        return false;
    }

    private void setBoard() {
        for (char[] row : board) {
            for (int i = 0; i < row.length; i++) {
                row[i] = '-';
            }
        }
    }

    private void printGame() {
        for (char[] row : this.board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private boolean checkWin(Set<Integer> player) {
        int[] rowCheck = new int[] { 0, 1, 2 };
        int[] columnCheck = new int[] { 0, 3, 6 };
        int[] diagnolCheck = new int[] { 0, 2 };
        for (int i = 0; i < 3; i++) {
            if (checkVerical(player, rowCheck[i]) || checkHorizontal(player, columnCheck[i])) {
                return true;
            }
            if (i != 2 && checkDiagnol(player, diagnolCheck[i])) {
                return true;
            }
        }

        return false;
    }

    private boolean checkDiagnol(Set<Integer> player, int n) {
        if (n == 0) {
            for (int i = 0; i < 9; i += 4) {
                if (!player.contains(i)) {
                    return false;
                }
            }
        } else {
            for (int i = 2; i < 7; i += 2) {
                if (!player.contains(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkHorizontal(Set<Integer> player, int n) {
        for (int i = n; i < n + 3; i++) {
            if (!player.contains(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkVerical(Set<Integer> player, int n) {
        for (int i = n; i < 9; i += 3) {
            if (!player.contains(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && c < 3 && r < 3;
    }
}