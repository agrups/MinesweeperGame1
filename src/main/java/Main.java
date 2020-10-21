import Models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String s[]) throws IOException {
/*        GameField map = new GameField();

        ArrayList<Flag> mines = new ArrayList<>();

        Random rand = new Random();
        int i = 0;
        while (i < 10) {
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);
            if (containsMine(mines, x, y)) continue;
            Flag mine = new Flag(new Position(x, y));
            mines.add(mine);
            map.setModel(x, y);
            i++;
        }

        ArrayList<Flag> flags = new ArrayList<>();

        GameLevel level = new GameLevel(map, mines, flags);

        GameRenderer renderer = new GameRenderer();

        GameRules gameRules = new GameRules(level);

        ConsoleInput consoleInput = new ConsoleInput();

        while (!gameRules.isGameOver()) {

            renderer.renderMap(level);

            String key = consoleInput.readConsoleInput(level);

            gameRules.processUserInput(key);
        }

        renderer.renderMap(level);

        if(gameRules.isGameOver() && !gameRules.isWon()){
            System.out.println("There was a mine. You have lost");
        }
    }

    public static boolean containsMine(List<Flag> mines, int x, int y){                 //sitas kartojasi klaseje gamelevel
        return mines.stream().anyMatch((mine -> mine.getPosition().getX() == x &&
                mine.getPosition().getY() == y));
    }*/
    }
}
