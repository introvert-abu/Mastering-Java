public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'j';
        System.out.println(nextGreatestLetter(letters, target));
    }

    static char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int l = 0;
        int r = letters.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m != 0 && letters[m] > target && letters[m - 1] < target) {
                return letters[m];
            } else if (l != 0 && letters[l] > target && letters[l - 1] < target) {
                return letters[l];
            } else if (m != 0 && letters[r] > target && letters[r - 1] < target) {
                return letters[r];
            } else if (letters[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return letters[l];
    }
}
