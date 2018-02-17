package my.project.game;

import javax.swing.*;
import java.awt.*;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

public class BodyPanelColumn extends JPanel{
    private CanvasPanel canvasPanel = new CanvasPanel();
    private final static int COLUMN = 2;

     int bodyPanelHight = canvasPanel.canvasPanelSizeHight;
     int bodyPanelWight = CellSize.getSizeCell() *COLUMN;
    BodyPanelColumn(){
        setPreferredSize(new Dimension(bodyPanelWight, bodyPanelHight));
        setBackground(Style.BODY_COLOR);
        setVisible(true);

    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        GradientPaint gradientPaintLeft = new GradientPaint(0,0,Style.GRADIENT_COLOR_START, 10,0, Style.GRADIENT_COLOR_END_DARK,false);
        GradientPaint gradientPaintRight = new GradientPaint(getWidth()-10,0,Style.GRADIENT_COLOR_START, getWidth(),0,Style.GRADIENT_COLOR_END_DARK,false);
        g2D.setPaint(gradientPaintLeft);
        BasicStroke pint1 = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
        g2D.setStroke(pint1);
        g2D.drawLine(0, 0, 0, getHeight());
        g2D.setPaint(gradientPaintRight);
        g2D.drawLine(getWidth(), 0, getWidth(), getHeight());
    }
}
