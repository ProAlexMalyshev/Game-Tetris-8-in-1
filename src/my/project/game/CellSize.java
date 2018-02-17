package my.project.game;

import java.awt.*;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

    class CellSize {
    private static Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int RATIO_SCREEN_HEGHT = 35;
    private static int sizeCell = displaySize.height/RATIO_SCREEN_HEGHT;

    static int getSizeCell(){return sizeCell;}
}
