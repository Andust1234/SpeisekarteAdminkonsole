import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class IsKeyPressed {
	private boolean tabPressed = false;
    public boolean isTABPressed() {
        synchronized (IsKeyPressed.class) {
            return tabPressed;
       }
    }

    public void getKey() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (IsKeyPressed.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_TAB) {
                            tabPressed = true;
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                        if (ke.getKeyCode() == KeyEvent.VK_TAB) {
                            tabPressed = false;
                        }
                        break;
                    }
                    return tabPressed;
                }
            }
        });
    }
}
