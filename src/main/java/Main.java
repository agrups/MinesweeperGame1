import Models.Minesweeper;

public class Main {
    public static void main(String[] s) {
        Minesweeper minesweeper = new Minesweeper();

        minesweeper.playGame();
        minesweeper.printResult();
    }
}
