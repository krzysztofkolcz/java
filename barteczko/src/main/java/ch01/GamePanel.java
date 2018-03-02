package ch01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GamePanel  extends JPanel {

    public static final int WIDTH = 80 ;
    public static final int WINDOWWIDTH = 120 ;
    public static final int HEIGHT = 240;
    public static final int SCALE = 2;

    public GamePanel(){
        super();
        setPreferredSize(new Dimension(WINDOWWIDTH * SCALE , HEIGHT * SCALE ));
        setFocusable(true);
        requestFocus();
    }
}
