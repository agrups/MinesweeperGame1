package Models;

public class UnicodeRender extends GameRenderer {

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String CYAN = "\033[0;36m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String WHITE = "\033[0;37m";
    public static final String BLACK = "\033[0;30m";

    @Override
    public void printFlag() {
        print(RED,"\uD83D\uDEA9");
    }

    @Override
    public void printNotRevealed() {
        print(BLUE_BOLD, "\u25A0");
    }

    @Override
    public void printBomb() {
        print(BLACK, "\uD83D\uDCA3");
    }

    @Override
    public void printNumber(int near) {
        if (near == 0) {
            print(BLUE_BOLD, "\u25A1");
        } else if (near == 1) {
            print(BLUE, "\uFF11");
        } else if (near == 2) {
            print(GREEN, "\uFF12");
        } else if (near == 3) {
            print(RED, "\uFF13");
        } else if (near == 4) {
            print(CYAN, "\uFF14");
        } else if (near == 5) {
            print(PURPLE, "\uFF15");
        } else if (near == 6) {
            print(YELLOW, "\uFF16");
        } else if (near == 7) {
            print(WHITE, "\uFF17");
        } else if (near == 8) {
            print(WHITE, "\uFF18");
        }
    }

    private void print(String color, String symbol) {
        System.out.print(color + symbol + RESET + " ");
    }
}
