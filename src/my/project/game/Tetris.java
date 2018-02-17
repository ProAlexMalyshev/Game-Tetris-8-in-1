package my.project.game;

import javax.swing.*;
import java.awt.*;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

public class Tetris extends JFrame{
    CanvasPanel canvasPanel = new CanvasPanel();
    BodyPanelColumn bodyPanelColumn = new BodyPanelColumn();
    BodyPanelRowTop bodyPanelRowTop = new BodyPanelRowTop();
    ControlPanel controlPanel = new ControlPanel();


    public static void main(String[] args) {

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                       new Tetris();
                }
            });
        }

    Tetris(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(canvasPanel.canvasPanelSizeWight + bodyPanelColumn.bodyPanelWight*2,
                canvasPanel.canvasPanelSizeHight + controlPanel.controlPanelHight + bodyPanelRowTop.bodyPanelRowTopHight);
        setTitle("Game Tetris 8 in 1");
        setResizable(false);
        setLocationRelativeTo(null);
        add(new BodyPanelColumn(),BorderLayout.WEST);
        add(bodyPanelRowTop,BorderLayout.NORTH);
        add(new BodyPanelColumn(),BorderLayout.EAST);
        add(canvasPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}

