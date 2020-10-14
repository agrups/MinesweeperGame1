package Models;


public class GameRendered {

    public void renderMap(GameLevel gameLevel) {
        for (int x = 0; x < 9 /*gameLevel.getGameField().getFieldWidth()*/; x++) {
            for (int y = 0; y < 9/*gameLevel.getGameField().getFieldHeight()*/; y++) {

                if(gameLevel.hasFlag(new Position(x, y))){
                    System.out.print("F");
                    continue;
                }
                if(!gameLevel.getGameField().getRevealed(x, y)){
                    System.out.print(".");
                    continue;
                }
                if(gameLevel.hasMine(new Position(x, y))){
                    System.out.print("#");
                    continue;
                }

                int near = gameLevel.getGameField().calculateMinesNear(x, y);

                if (near==0) System.out.print("0");
                else if (near==1) System.out.print("1");
                else if (near==2) System.out.print("2");
                else if (near==3) System.out.print("3");
                else if (near==4) System.out.print("4");
                else if (near==5) System.out.print("5");
                else if (near==6) System.out.print("6");
                else if (near==7) System.out.print("7");
                else if (near==8) System.out.print("8");
            }
            System.out.println();
        }
    }
}

