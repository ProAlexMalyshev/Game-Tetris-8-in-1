package my.project.game;

import javax.swing.*;
import java.awt.*;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

public class BodyPanelRowTop extends JPanel{

    CanvasPanel canvasPanel = new CanvasPanel();
    BodyPanelColumn bodyPanelColumn = new BodyPanelColumn();

    int bodyPanelRowTopHight = CellSize.getSizeCell() *2;
    int bodyPanelRowTopWight = canvasPanel.canvasPanelSizeWight + bodyPanelColumn.bodyPanelWight*2;
    BodyPanelRowTop(){
        setPreferredSize(new Dimension(bodyPanelRowTopWight, bodyPanelRowTopHight));
        setBackground(Style.BODY_COLOR);
        setVisible(true);

    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        GradientPaint gradientPaintLeft = new GradientPaint(0,0,Style.GRADIENT_COLOR_START, 10,0,Style.GRADIENT_COLOR_END_DARK,false);
        GradientPaint gradientPaintRight = new GradientPaint(getWidth()-10,0,Style.GRADIENT_COLOR_START, getWidth(),0,Style.GRADIENT_COLOR_END_DARK,false);
        GradientPaint gradientPaintTop = new GradientPaint(0,0,Style.GRADIENT_COLOR_START, 0,10,Style.GRADIENT_COLOR_END_DARK,false);
        GradientPaint gradientPaintBottom = new GradientPaint(0,getHeight()-10,Style.GRADIENT_COLOR_START, 0,getHeight(),Style.GRADIENT_COLOR_END_DARK,false);
        BasicStroke pint1 = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
        g2D.setStroke(pint1);
        g2D.setPaint(gradientPaintLeft);
        g2D.drawLine(0, 0, 0, getHeight());
        g2D.setPaint(gradientPaintRight);
        g2D.drawLine(getWidth(), 0, getWidth(), getHeight());
        g2D.setPaint(gradientPaintTop);
        g2D.drawLine(0, 0, getWidth(), 0);
        g2D.setPaint(gradientPaintBottom);
        g2D.drawLine(bodyPanelColumn.bodyPanelWight-5, getHeight(), getWidth()-bodyPanelColumn.bodyPanelWight+5, getHeight());
    }
}
