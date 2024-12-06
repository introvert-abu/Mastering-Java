import java.util.Arrays;

public class MakeAdjacentToZero {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 0, 1 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };
        convert(arr);
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void convert(int[][] arr) {
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == 1) {

                    for (int[] direction : directions) {
                        int r = direction[0] + i, c = direction[1] + j;

                        if (isValid(r, c, arr.length, arr[i].length)) {
                            arr[r][c] = 0;
                        }
                    }

                }

            }
        }
    }

    private static boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }
}