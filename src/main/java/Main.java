import Models.MinesweeperSingleton;

public class Main {
    public static void main(String[] s) {
/*        Minesweeper minesweeper = new Minesweeper();

        minesweeper.playGame();
        minesweeper.printResult();*/

        MinesweeperSingleton minesweeperSingleton = MinesweeperSingleton.getInstance();

        minesweeperSingleton.playGame(minesweeperSingleton.chooseVisual());
        minesweeperSingleton.printResult();
    }
}
