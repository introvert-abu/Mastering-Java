package RockPaperScissor;

public enum Choices {
    ROCK(1), PAPER(2), SCISSOR(3);

    private int val;

    Choices(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static Choices getVal(int val) {
        return Choices.values()[val - 1];
    }
}
