
import java.util.List;

public class KeyBoardTest {
    public static void main(String[] args) throws Exception{
        Display display = new Display();
        display.start();
        System.out.println("num: " + display.keyBoard.numOfKeysPressed());
        while(!display.keyBoard.anyPressed())
        {
            System.out.print("");
        }
        for(long i = 0; i != 1000_000_000_000_000_000L; i++);
        List<Character> list = display.keyBoard.getList();
        display.end();
        for(Character event: list)
        {
            System.out.println("events: " + event);
        }
    }
    private static void assertTrue(boolean bool, String errorMessage) throws Exception
    {
        if(bool)
        {
            return;
        }
        throw new Exception(errorMessage);
    }
}
