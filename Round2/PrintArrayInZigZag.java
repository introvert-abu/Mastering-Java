import java.util.ArrayDeque;
import java.util.Deque;

public class PrintArrayInZigZag {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 },
                { 19, 20, 21, 22, 23, 24 },
                { 25, 26, 27, 28, 29, 30 }
        };
        print(arr);
    }

    private static void print(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        Deque<Integer> deq = new ArrayDeque<>();
        int[] set = new int[n * m];
        deq.add(0);
        set[0] = 1;
        System.out.print(arr[0][0] + " ");

        boolean isCTurn = true;
        while (!deq.isEmpty()) {
            int size = deq.size();

            for (int i = 0; i < size; i++) {
                if (isCTurn) {
                    int curr = deq.pollFirst();
                    int r = curr / m;
                    int c = curr % m;

                    int newR = r;
                    int newC = c + 1;

                    if (isValid(newR, newC, n, m) && set[newR * m + newC] == 0) {
                        System.out.print(arr[newR][newC] + " ");
                        deq.offerLast(newR * m + newC);
                        set[newR * m + newC] = 1;
                    }

                    newR = r + 1;
                    newC = c;

                    if (isValid(newR, newC, n, m) && set[newR * m + newC] == 0) {
                        System.out.print(arr[newR][newC] + " ");
                        deq.offerLast(newR * m + newC);
                        set[newR * m + newC] = 1;
                    }

                } else {

                    int curr = deq.pollLast();
                    int r = curr / m;
                    int c = curr % m;

                    int newR = r + 1;
                    int newC = c;

                    if (isValid(newR, newC, n, m) && set[newR * m + newC] == 0) {
                        System.out.print(arr[newR][newC] + " ");
                        deq.offerFirst(newR * m + newC);
                        set[newR * m + newC] = 1;
                    }

                    newR = r;
                    newC = c + 1;

                    if (isValid(newR, newC, n, m) && set[newR * m + newC] == 0) {
                        System.out.print(arr[newR][newC] + " ");
                        deq.offerFirst(newR * m + newC);
                        set[newR * m + newC] = 1;
                    }

                }
            }

            isCTurn = !isCTurn;
        }
    }

    private static boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }
}