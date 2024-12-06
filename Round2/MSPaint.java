import java.util.Arrays;

public class MSPaint {
    public static void main(String[] args) {
        int[][] screen = {
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 0, 0, 1, 1, 0, 1, 1 },
                { 1, 2, 2, 2, 2, 0, 1, 0 },
                { 1, 1, 1, 2, 2, 0, 1, 0 },
                { 1, 1, 1, 2, 2, 2, 2, 0 },
                { 1, 1, 1, 1, 1, 2, 1, 1 },
                { 1, 1, 1, 1, 1, 2, 2, 1 }, };
        int x = 4, y = 4, newColor = 3;
        for (int[] row : screen) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        paint(x, y, newColor, screen, screen[x][y]);
        for (int[] row : screen) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void paint(int r, int c, int newColor, int[][] screen, int prevColor) {
        if (r < 0 || c < 0 || r >= screen.length || c >= screen[0].length || screen[r][c] != prevColor) {
            return;
        }

        screen[r][c] = newColor;
        paint(r - 1, c, newColor, screen, prevColor);
        paint(r + 1, c, newColor, screen, prevColor);
        paint(r, c - 1, newColor, screen, prevColor);
        paint(r, c + 1, newColor, screen, prevColor);
    }
}
