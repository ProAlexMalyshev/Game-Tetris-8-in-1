package my.project.game;

import javax.swing.*;
import java.awt.*;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

 class CanvasPanel extends JPanel{

   private MapGamePanel mapGamePanel = new MapGamePanel();
   private InfoPanel infoPanel = new InfoPanel();
    int canvasPanelSizeWight = mapGamePanel.mapPanelWight+infoPanel.infoPanelWight;
    int canvasPanelSizeHight = mapGamePanel.mapPanelHight;

    CanvasPanel(){
        setSize(canvasPanelSizeWight, canvasPanelSizeHight);
        setLayout(new BorderLayout());
        add(mapGamePanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.EAST);
        setVisible(true);
    }
}
