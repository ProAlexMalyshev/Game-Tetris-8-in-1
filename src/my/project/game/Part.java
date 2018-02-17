package my.project.game;
import java.awt.*;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

    class Part{
    private int x;
    private int y;
    private boolean isSetColor;
    private Graphics g;

    Part(int x, int y, Graphics g, boolean isSetColor){
        this.x = x;
        this.y = y;
        this.isSetColor=isSetColor;
        this.g=g;
        paintPart();
    }

   private void paintPart (){
        if(isSetColor){
            g.setColor(Style.ACTIVE_COLOR);
        }else {
            g.setColor(Style.NO_ACTIVE_COLOR);
        }
        g.fillRect(x * CellSize.getSizeCell() + 12, y * CellSize.getSizeCell() + 12, CellSize.getSizeCell() - 14, CellSize.getSizeCell() - 14);
        g.drawRect(x * CellSize.getSizeCell() + 8,  y * CellSize.getSizeCell() + 8, CellSize.getSizeCell() - 6, CellSize.getSizeCell() - 6);
    }

}
