package Models;

public class ConsoleRender extends GameRenderer{
    @Override
    public void printFlag() {
        System.out.print("F  ");
    }

    @Override
    public void printNotRevealed() {
        System.out.print(".  ");
    }

    @Override
    public void printBomb() {
        System.out.print("#  ");
    }

    @Override
    public void printNumber(int near) {
        System.out.print(near + "  ");
    }
}
