package Models;

public class GameRules {

    public GameRules() {
    }

    public GameStatus processUserInput(String input, Field[][] fields) {
        int x = Integer.parseInt(input.substring(1, 2));
        int y = Integer.parseInt(input.substring(2));

        //Field field = gameField.getFields()[x][y];

        switch (input.charAt(0)) {
            case 'f':

                //Position position = new Position(x, y);
                if (fields[x][y].isFlagged()) {
                    fields[x][y].setFlagged(false);
                    //level.getFlags().remove(level.getFlag(position));
                    //level.getGameField().setRevealed(x, y, false);
                    return GameStatus.CONTINUE;
                } else {
                    fields[x][y].setFlagged(true);
/*                    Flag flag = new Flag(position);
                    level.getFlags().add(flag);
                    level.getGameField().setRevealed(x, y, true);*/
                    checkIfWon(x, y, fields);
                }
                break;
            case 'o':
                if (!fields[x][y].isRevealed() && !fields[x][y].isFlagged()) {
                    if (fields[x][y].isMine()) {
/*                        setGameOver(true);
                        setWon(false);*/
                        fields[x][y].setRevealed(true);
                        return GameStatus.LOST;
                    } else {
                        fields[x][y].setRevealed(true);
                        checkIfWon(x, y, fields);
                }
                }
                break;
        }
        return GameStatus.CONTINUE;
    }

    public GameStatus checkIfWon(int x, int y, Field[][] fields) {
        int flaggedFields = 0;
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                if (!fields[x][y].isRevealed() && !fields[x][y].isFlagged()) {
                    return GameStatus.CONTINUE;
                }
                if(fields[x][y].isFlagged()){
                    flaggedFields++;
                }
            }
        }
        if (flaggedFields == 10) {
            return GameStatus.WON;
/*            setGameOver(true);
            setWon(true);
            System.out.println("Congrats, you won!!!");*/
        }
        return GameStatus.CONTINUE;
    }
}
