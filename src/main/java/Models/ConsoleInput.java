package Models;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleInput {

    public String readConsoleInput(GameLevel gameLevel) throws IOException {

        boolean check = false;
        Scanner scan = new Scanner(System.in);
        String input = "";
        while(check == false){
            System.out.println("f - put or take off a flag, o - open a cell + coordinates e.g. f15, t48, o75");

            input = scan.next();
            if((input.charAt(0) == 'f' || input.charAt(0) == 'o')
                    && Integer.parseInt(input.substring(1, 2)) < gameLevel.getGameField().getFieldHeight()
                    && Integer.parseInt(input.substring(2)) < gameLevel.getGameField().getFieldWidth()
                    && input.length() == 3){
                check = true;
            }else{
                System.out.println("Wrong input.");
            }
        }
       // scan.close();
        return input;
    }
}
