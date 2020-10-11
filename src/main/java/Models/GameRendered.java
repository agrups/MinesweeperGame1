package Models;


public class GameRendered {

    public void renderMap(GameLevel gameLevel) {
        for (int x = 0; x < 9 /*gameLevel.getGameField().getFieldWidth()*/; x++) {
            for (int y = 0; y < 9/*gameLevel.getGameField().getFieldHeight()*/; y++) {

                if(gameLevel.getGameField().getRevealed()[x][y] == false){
                    System.out.println(".");
                    continue;
                }
                if(gameLevel.getFlag(new Position(x, y)) != null){
                    System.out.println("F");
                    continue;
                }
/*                for(Flag flag: gameLevel.getFlags()){
                    if(flag.getPosition().at(x, y)){

                    }
                }*/

                int near = gameLevel.getGameField().calculateMinesNear(x, y);

                if (near==0) System.out.println("0");
                else if (near==1) System.out.println("1");
                else if (near==2) System.out.println("2");
                else if (near==3) System.out.println("3");
                else if (near==4) System.out.println("4");
                else if (near==5) System.out.println("5");
                else if (near==6) System.out.println("6");
                else if (near==7) System.out.println("7");
                else if (near==8) System.out.println("8");


                else if(gameLevel.hasMine(new Position(x,y)) ){
                    System.out.println("#");
                }

                System.out.println();
            }

        }
    }
}

