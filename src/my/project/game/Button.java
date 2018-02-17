package my.project.game;

import javax.swing.*;
import java.awt.*;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

public class Button extends JButton{
    private double size;

    Button(double size){
        this.size = size;
        setPreferredSize(new Dimension((int) size, (int) size));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        g.setColor(Color.BLACK);
        if(getModel().isArmed())
        {
            g2D.setColor(Style.NO_ACTIVE_COLOR);
            g2D.fillOval(0, 0, (int) size, (int)size);
            g2D.setColor(Style.BOTTON_ORANGE_PRES);
        } else {
            GradientPaint gradientButton = new GradientPaint(0,0,Style.GRADIENT_BOTTON_HIGHLIGHT, 0,8,Style.GRADIENT_BOTTON_ORANGE,false);
            GradientPaint gradientPaintTop = new GradientPaint(0,0,Style.GRADIENT_COLOR_START, 80,0,Style.GRADIENT_COLOR_END_DARK,false);
            g2D.setPaint(gradientPaintTop);
            g2D.fillOval(0, 0, (int) size, (int)size);
            g2D.setColor(Color.ORANGE);
            g2D.setPaint(gradientButton);
        }
        g2D.fillOval(3, 3, (int) size - 6, (int) size-6);

    }

}
