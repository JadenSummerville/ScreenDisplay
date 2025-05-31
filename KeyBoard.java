import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyBoard implements KeyListener{
    private Set<Character> keysBeingPressed = new HashSet<>();
    private KeyEvent lastKeyPressed = null;

    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyPressed(KeyEvent e)
    {
        keysBeingPressed.add(e.getKeyChar());
        lastKeyPressed = e;
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
        keysBeingPressed.remove(e);
    }

    public boolean anyPressed()
    {
        return keysBeingPressed.size() != 0;
    }

    public int numOfKeysPressed()
    {
        return keysBeingPressed.size();
    }

    public KeyEvent lastKeyPressed()
    {
        return lastKeyPressed;
    }

    public boolean isPressed(KeyEvent e)
    {
        return keysBeingPressed.contains(e);
    }

    public List<Character> getList()
    {
        return new ArrayList<Character>(keysBeingPressed);
    }
}
