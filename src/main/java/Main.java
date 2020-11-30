import Models.MinesweeperSingleton;

public class Main {
    public static void main(String[] s) {
        MinesweeperSingleton minesweeperSingleton = MinesweeperSingleton.getInstance();

        minesweeperSingleton.playGame(minesweeperSingleton.chooseVisual());
        minesweeperSingleton.printResult();
    }
}
