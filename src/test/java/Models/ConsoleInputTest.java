package Models;

import org.junit.Assert;
import org.junit.Test;

public class ConsoleInputTest {

    private ConsoleInput consoleInput = new ConsoleInput();

    @Test
    public void falseIfOutOfBounceInput() {
        GameField gameField = new GameField();
        Field[][] fields = gameField.getFields();
        int outOfBorder = fields.length + 1;
        String input = "o0" + outOfBorder;
        Boolean withinBorders = consoleInput.checkConsoleInput(fields, input);

        Assert.assertFalse(withinBorders);
    }

    @Test
    public void falseIfWrongCommandLetter() {
        GameField gameField = new GameField();
        Field[][] fields = gameField.getFields();
        char command = 'z';
        String input = command + "00";
        Boolean flagOrOpenCommand = consoleInput.checkConsoleInput(fields, input);

        Assert.assertFalse(flagOrOpenCommand);
    }

}