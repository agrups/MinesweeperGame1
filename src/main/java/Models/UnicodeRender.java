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
        System.out.print(RED + "\uD83D\uDEA9 " + RESET);
    }

    @Override
    public void printNotRevealed() {
        System.out.print(BLUE_BOLD + "\u25A0 " + RESET);
    }

    @Override
    public void printBomb() {
        System.out.print(BLACK + "\uD83D\uDCA3 " + RESET);
    }

    @Override
    public void printNumber(int near) {
        if (near == 0) {
            System.out.print(BLUE_BOLD + "\u25A1" + RESET + " ");
        } else if (near == 1) {
            System.out.print(BLUE + "\uFF11" + RESET + " ");
        } else if (near == 2) {
            System.out.print(GREEN + "\uFF12" + RESET + " ");
        } else if (near == 3) {
            System.out.print(RED + "\uFF13" + RESET + " ");
        } else if (near == 4) {
            System.out.print(CYAN + "\uFF14" + RESET + " ");
        } else if (near == 5) {
            System.out.print(PURPLE + "\uFF15" + RESET + " ");
        } else if (near == 6) {
            System.out.print(YELLOW + "\uFF16" + RESET + " ");
        } else if (near == 7) {
            System.out.print(WHITE + "\uFF17" + RESET + " ");
        } else if (near == 8) {
            System.out.print(WHITE + "\uFF18" + RESET + " ");
        }
    }
}
