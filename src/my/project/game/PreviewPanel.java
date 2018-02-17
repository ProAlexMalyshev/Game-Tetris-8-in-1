package my.project.game;

import javax.swing.*;
import java.awt.*;
import static my.project.game.MapGamePanel.isGameOver;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

public class PreviewPanel extends JPanel {

    private final static int ROW = 4;
    private final static int COLUMN = 4;
    private static int previewPanelHight = CellSize.getSizeCell() * ROW;
    private static int previewPanelWight = CellSize.getSizeCell() * COLUMN;
    static int fieldPreview [][] = new int[ROW][COLUMN];

    PreviewPanel(){
        setPreferredSize(new Dimension(previewPanelWight, previewPanelHight));
        setBackground(Style.CANVAS_COLOR);
        setVisible(true);
    }
     static int getPreviewPanelHight(){return previewPanelHight+5;}
     static int getPreviewPanelWight(){return previewPanelWight+3;}

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        BasicStroke pint1 = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2D.setStroke(pint1);
        drowPreviewPanel(g);
    }
    private void drowPreviewPanel(Graphics g){
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COLUMN; j++) {
                    if (fieldPreview[i][j] == 1&&!isGameOver) {
                        new Part(j,i,g,true);
                    }else {
                        new Part(j,i,g,false);
                    }
                }
            }
    }

}
