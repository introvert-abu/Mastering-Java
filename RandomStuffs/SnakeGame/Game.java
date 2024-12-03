import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private char[][] board;
    private int rows, cols;

    public Game(int r, int c) throws Exception {
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
        int row = 0, col = 0;
        int rows = this.board.length, cols = this.board[0].length;

        Queue<SnakeNode> snakeBody = new LinkedList<>();
        Set<String> snakeNodes = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        snakeBody.add(new SnakeNode(row, col));
        snakeNodes.add(row + "" + col);
        board[row][col] = '.';

        System.out.println("-----> Controls W A S D <------");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (isValid(row, col, rows, cols)) {
            printBoard();

            System.out.print("Direction : ");
            int[] nextDiection = nextDirection(sc, sc.next().charAt(0));
            row += nextDiection[0];
            col += nextDiection[1];
            System.out.println();

            SnakeNode newNode = new SnakeNode(row, col);
            boolean isSnakeBody = snakeNodes.contains(row + "" + col);

            if (!isValid(row, col, rows, cols) || isSnakeBody)
                break;

            if (this.board[row][col] != 'x') {
                SnakeNode tailNode = snakeBody.poll();
                int tailRow = tailNode.getRow(), tailCol = tailNode.getCol();
                snakeNodes.remove(tailRow + "" + tailCol);
                this.board[tailRow][tailCol] = 'O';
            } else {
                this.board[row][col] = '.';
                setObtragle(rows, cols);
            }

            this.board[row][col] = '.';
            snakeBody.add(newNode);
            snakeNodes.add(row + "" + col);
        }

        System.out.println("Game Over! \n");
        System.out.print("Wanna try again ? Pres Y/N");
        startAgain(sc);

        sc.close();
    }

    private void startAgain(Scanner sc) {
        char choice = sc.next().charAt(0);
        switch (Character.toUpperCase(choice)) {
            case 'Y':
                this.setBoard(this.rows, this.cols);
                this.setObtragle(this.rows, this.cols);
                this.startGame();
                break;
            case 'N':
                return;
            default:
                System.out.println("Invalid Choice");
                startAgain(sc);
        }
    }

    private int[] nextDirection(Scanner sc, char nextDiection) {
        switch (Character.toUpperCase(nextDiection)) {
            case 'W':
                return new int[] { -1, 0 };
            case 'A':
                return new int[] { 0, -1 };
            case 'S':
                return new int[] { 1, 0 };
            case 'D':
                return new int[] { 0, 1 };
            default:
                System.out.println("Invalid Direction");
                System.out.print("Direction : ");
                return nextDirection(sc, sc.next().charAt(0));
        }
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return col >= 0 && col < cols && row >= 0 && row < rows;
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
