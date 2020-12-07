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
    public static final String zeroBombsNearCell = "\u25A1";
    public static final String numberOne = "\uFF11";
    public static final String numberTwo = "\uFF12";
    public static final String numberThree = "\uFF13";
    public static final String numberFour = "\uFF14";
    public static final String numberFive = "\uFF15";
    public static final String numberSix = "\uFF16";
    public static final String numberSeven = "\uFF17";
    public static final String numberEight = "\uFF18";
    public static final String flag = "\uD83D\uDEA9";
    public static final String notRevealedCell = "\u25A0";
    public static final String bomb = "\uD83D\uDCA3";

    @Override
    public void printFlag() {
        print(RED, flag);
    }

    @Override
    public void printNotRevealed() {
        print(BLUE_BOLD, notRevealedCell);
    }

    @Override
    public void printBomb() {
        print(BLACK, bomb);
    }

    @Override
    public void printNumber(int near) {
        if (near == 0) {
            print(BLUE_BOLD, zeroBombsNearCell);
        } else if (near == 1) {
            print(BLUE, numberOne);
        } else if (near == 2) {
            print(GREEN, numberTwo);
        } else if (near == 3) {
            print(RED, numberThree);
        } else if (near == 4) {
            print(CYAN, numberFour);
        } else if (near == 5) {
            print(PURPLE, numberFive);
        } else if (near == 6) {
            print(YELLOW, numberSix);
        } else if (near == 7) {
            print(WHITE, numberSeven);
        } else if (near == 8) {
            print(WHITE, numberEight);
        }
    }

    private void print(String color, String symbol) {
        System.out.print(color + symbol + RESET + " ");
    }
}
