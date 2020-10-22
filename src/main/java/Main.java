import Models.*;

import java.io.IOException;

public class Main {
    public static void main(String s[]) throws IOException {
        Minesweeper minesweeper = new Minesweeper();

        minesweeper.playGame();
        minesweeper.printResult();
    }
}
