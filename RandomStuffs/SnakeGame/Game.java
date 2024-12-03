import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private char[][] board;
    Queue<SnakeNode> snakeBody;
    private int rows, cols;

    public Game(int r, int c) throws Exception {
        this.snakeBody = new LinkedList<>();
        this.board = new char[r][c];

        if (r <= 0)
            throw new Exception("Row shouldn't be lesser than or equals to 0");
        if (c < 0)
            throw new Exception("Col shouldn't be lesser than 0");

        this.rows = r;
        this.cols = c;
        setBoard(r, c);
        setObtragle(r, c);
    }

    private void setBoard(int r, int c) {
        for (char[] row : board) {
            Arrays.fill(row, 'O');
        }
    }

    private void setObtragle(int r, int c) {
        Random random = new Random();

        int row = random.nextInt(r);
        int col = random.nextInt(c);
        if (this.board[row][col] == 'x' || this.board[row][col] == '.')
            setObtragle(r, c);
        else
            this.board[row][col] = 'x';
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        moveSnake(sc, 0, 0);
	System.out.println("Wanna play Again ?");
        startAgain(sc);
        sc.close();
    }

    private void moveSnake(Scanner sc, int r, int c) {
        if (this.isValid(r, c)) {
            if (this.board[r][c] == '.') {
                System.out.println("Game Over!!!");
                return;
            }
            char prevVal = this.board[r][c];
            if (this.board[r][c] == 'x') {
                this.board[r][c] = '.';
                this.setObtragle(this.rows, this.cols);
            } else {
                if (r == 0 && c == 0) {
                    this.board[r][c] = '.';
                } else {
                    this.board[r][c] = '.';
                    SnakeNode tailNode = this.snakeBody.poll();
                    int tailRow = tailNode.getRow(), tailCol = tailNode.getCol();
                    this.board[tailRow][tailCol] = 'O';
                }
            }
            this.snakeBody.add(new SnakeNode(r, c));
            printBoard();

            System.out.print("Direction : ");
            char nextDiection = sc.next().charAt(0);
            System.out.println();

            switch (Character.toUpperCase(nextDiection)) {
                case 'W' -> moveSnake(sc, r-1, c); 
                case 'A' -> moveSnake(sc, r, c-1); 
                case 'S' -> moveSnake(sc, r+1, c); 
                case 'D' -> moveSnake(sc, r, c+1); 
                default -> {
                    System.out.println("Invalid Move");
                    this.board[r][c] = prevVal;
                    moveSnake(sc, r, c);
                }
            }

        } else {
            System.out.println("Game Over!!!");
        }
    }

    private void startAgain(Scanner sc) {
	System.out.print("Enter Y/N ");
        char choice = sc.next().charAt(0);
	System.out.println();
        switch (Character.toUpperCase(choice)) {
            case 'Y':
                this.setBoard(this.rows, this.cols);
                this.setObtragle(this.rows, this.cols);
                this.startGame();
                break;
            case 'N':
                System.out.println("See ya!!!");
                return;
            default:
                System.out.println("Invalid Choice");
                startAgain(sc);
        }
    }

    private boolean isValid(int row, int col) {
        return col >= 0 && col < this.cols && row >= 0 && row < this.rows;
    }

    private void printBoard() {
        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
