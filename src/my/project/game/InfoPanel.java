package my.project.game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

public class InfoPanel extends JPanel{
   private PreviewPanel previewPanel =    new PreviewPanel();

   private JLabel labelHiScore =          new JLabel();
   private JLabel labelNumberHiScore =    new JLabel();
   private JLabel labelNumberHiScoreOff = new JLabel();
   private JLabel labelScore =            new JLabel();
   private JLabel labelNumberScore =      new JLabel();
   private JLabel labelNumberScoreOff =   new JLabel();
   private JLabel labelLevel =            new JLabel();
   private JLabel labelLevelNumber =      new JLabel();
   private JLabel labelLevelNumberOff =   new JLabel();
   private JLabel labelSpeed =            new JLabel();
   private JLabel labelSpeedNumber =      new JLabel();
   private JLabel labelSpeedNumberOff =   new JLabel();
   private JLabel labelPause =            new JLabel();
   private JLabel labelGameOver =         new JLabel();
   private JLabel labelSound =            new JLabel();

    private Font fontNumber = new Font("Electronic symbols",Font.BOLD, 30);
    private Font fontNumberLabelAffine = fontNumber.deriveFont(AffineTransform.getScaleInstance(0.8,1.2));
    private Font fontTextLabel = new Font("Britannic Bold", Font.BOLD, 18);
    private Font fontTextLabelAffine = fontTextLabel.deriveFont(AffineTransform.getScaleInstance(0.85,1));

    private final static int ROW = 20;
    private final static int COLUMN = 4;
    private final static int MAX_DELAY_ANIMATION_PAUSE = 4;
    private final static int MIN_DELAY_ANIMATION_PAUSE = 0;
    private final static int MAX_DELAY_REPAINT = 3;
    private final static int MIN_DELAY_REPAINT = 0;

    int infoPanelHight = CellSize.getSizeCell() * ROW;
     int infoPanelWight = CellSize.getSizeCell() * COLUMN;
    private float delayAnimationPause=0;
    private float delayRepaint=0;

    InfoPanel(){
        setPreferredSize(new Dimension(infoPanelWight, infoPanelHight));
        setLayout(null);
        setBackground(Style.CANVAS_COLOR);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        delayRepaint++;
        if(delayRepaint> MAX_DELAY_REPAINT) {
            setLabelTopLayer();
            setBackgroundLabelBackTextOff();
            setBackgroundInfoPanel();
           delayRepaint= MIN_DELAY_REPAINT;
        }
            repaint();
    }

    private void setBackgroundInfoPanel(){
    setBackgroundLabelHiScore();
    setBackgroundLabelScore();
    setBackgroundPreviewPanel();
    setBackgroundLabelLevel();
    setBackgroundLabelSpeed();
    }

    private void setBackgroundLabelHiScore(){
        labelHiScore.setFont(fontTextLabelAffine);
        labelHiScore.setForeground(Style.NO_ACTIVE_COLOR);
        if(ControlPanel.isPressedButtonOnOff) {
            labelHiScore.setForeground(Style.ACTIVE_COLOR);
        }
        labelHiScore.setText("Hi-Score");
        labelHiScore.setSize(100,20);
        labelHiScore.setLocation(CellSize.getSizeCell()  /2 + 12 ,CellSize.getSizeCell()  - CellSize.getSizeCell()  /2 - 3);
        add(labelHiScore);

    }

    private void setBackgroundLabelScore(){
        labelScore.setFont(fontTextLabelAffine);
        labelScore.setForeground(Style.NO_ACTIVE_COLOR);
        if(ControlPanel.isPressedButtonOnOff) {
            labelScore.setForeground(Style.ACTIVE_COLOR);
        }
        labelScore.setText("Score");
        labelScore.setSize(100,20);
        labelScore.setLocation(CellSize.getSizeCell() + CellSize.getSizeCell()  /2 + 10,CellSize.getSizeCell()  * 3 - CellSize.getSizeCell()  /2 - 3);
        add(labelScore);
    }

    private void setBackgroundPreviewPanel(){
        previewPanel.setSize(PreviewPanel.getPreviewPanelWight(),PreviewPanel.getPreviewPanelHight());
        previewPanel.setLocation(-5,CellSize.getSizeCell() *5 );
        add(previewPanel);
    }

    private void setBackgroundLabelLevel(){
        labelLevel.setFont(fontTextLabelAffine);
        labelLevel.setForeground(Style.NO_ACTIVE_COLOR);
        if(ControlPanel.isPressedButtonOnOff) {
            labelLevel.setForeground(Style.ACTIVE_COLOR);
        }
        labelLevel.setText("Level");
        labelLevel.setSize(100,20);
        labelLevel.setLocation(CellSize.getSizeCell()  + CellSize.getSizeCell() /2 + 14,CellSize.getSizeCell()  * 10 - CellSize.getSizeCell()  /5);
        add(labelLevel);
    }

    private void setBackgroundLabelSpeed(){
        labelSpeed.setFont(fontTextLabelAffine);
        labelSpeed.setForeground(Style.NO_ACTIVE_COLOR);
        if(ControlPanel.isPressedButtonOnOff) {
            labelSpeed.setForeground(Style.ACTIVE_COLOR);
        }
        labelSpeed.setText("Speed");
        labelSpeed.setSize(100,20);
        labelSpeed.setLocation(CellSize.getSizeCell()  + CellSize.getSizeCell()  /2 + 7,CellSize.getSizeCell()  * 12 + CellSize.getSizeCell()  /8);
        add(labelSpeed);
    }

    private void setBackgroundLabelBackTextOff(){
        setBackgroundLabelNumberHiScoreScoreOff();
        setBackgroundLabelNumberScoreOff();
        setBackgroundLabelNumberLevelOff();
        setBackgroundLabelNumberSpeedOff();
    }

    private void setBackgroundLabelNumberHiScoreScoreOff(){

        labelNumberHiScoreOff.setFont(fontNumberLabelAffine);
        labelNumberHiScoreOff.setForeground(Style.NO_ACTIVE_COLOR);
        labelNumberHiScoreOff.setHorizontalAlignment(JLabel.RIGHT);
        labelNumberHiScoreOff.setText("888888");
        labelNumberHiScoreOff.setSize(80,30);
        labelNumberHiScoreOff.setLocation(CellSize.getSizeCell()  /2,CellSize.getSizeCell()  + CellSize.getSizeCell()  /9);
        add(labelNumberHiScoreOff);
    }

    private void setBackgroundLabelNumberScoreOff(){

        labelNumberScoreOff.setFont(fontNumberLabelAffine);
        labelNumberScoreOff.setForeground(Style.NO_ACTIVE_COLOR);
        labelNumberScoreOff.setHorizontalAlignment(JLabel.RIGHT);
        labelNumberScoreOff.setText("888888");
        labelNumberScoreOff.setSize(80,30);
        labelNumberScoreOff.setLocation(CellSize.getSizeCell()  /2,CellSize.getSizeCell()  * 3 + CellSize.getSizeCell() /9);
        add(labelNumberScoreOff);
    }

    private void setBackgroundLabelNumberLevelOff(){
        labelLevelNumberOff.setFont(fontNumberLabelAffine);
        labelLevelNumberOff.setForeground(Style.NO_ACTIVE_COLOR);
        labelLevelNumberOff.setHorizontalAlignment(JLabel.RIGHT);
        labelLevelNumberOff.setText("888888");
        labelLevelNumberOff.setSize(80,30);
        labelLevelNumberOff.setLocation(CellSize.getSizeCell()  /2,CellSize.getSizeCell()  * 11 - CellSize.getSizeCell()  /2);
        add(labelLevelNumberOff);
    }

    private void setBackgroundLabelNumberSpeedOff(){

        labelSpeedNumberOff.setFont(fontNumberLabelAffine);
        labelSpeedNumberOff.setForeground(Style.NO_ACTIVE_COLOR);
        labelSpeedNumberOff.setHorizontalAlignment(JLabel.RIGHT);
        labelSpeedNumberOff.setText("888888");
        labelSpeedNumberOff.setSize(80,30);
        labelSpeedNumberOff.setLocation(CellSize.getSizeCell()  /2,CellSize.getSizeCell()  * 13 - CellSize.getSizeCell()  /5);
        add(labelSpeedNumberOff);
    }

    private void setLabelTopLayer(){
            setLabelNumberHiScore();
            setLabelNumberScore();
            setLabelLevelNumber();
            setLabelSpeedNumber();
            setLabelPause();
            setLabelGameOver();
            setLabelSound();
    }

    private void setLabelNumberHiScore(){

        labelNumberHiScore.setFont(fontNumberLabelAffine);
        labelNumberHiScore.setForeground(Style.ACTIVE_COLOR);
        labelNumberHiScore.setHorizontalAlignment(JLabel.RIGHT);
        labelNumberHiScore.setText(String.valueOf(MapGamePanel.getHiScore()));
        labelNumberHiScore.setSize(80, 30);
        labelNumberHiScore.setLocation(CellSize.getSizeCell()  / 2, CellSize.getSizeCell()  + CellSize.getSizeCell()  / 9);
        add(labelNumberHiScore);
        if(!ControlPanel.isPressedButtonOnOff) {
            remove(labelNumberHiScore);
        }
    }

    private void setLabelNumberScore(){

        labelNumberScore.setFont(fontNumberLabelAffine);
        labelNumberScore.setForeground(Style.ACTIVE_COLOR);
        labelNumberScore.setHorizontalAlignment(JLabel.RIGHT);
        labelNumberScore.setText(String.valueOf(MapGamePanel.getScore()));
        labelNumberScore.setSize(80,30);
        labelNumberScore.setLocation(CellSize.getSizeCell()  /2,CellSize.getSizeCell()  * 3 + CellSize.getSizeCell()  /9);
        add(labelNumberScore);
        if(!ControlPanel.isPressedButtonOnOff) {
            remove(labelNumberScore);
        }

    }

    private void setLabelLevelNumber(){
        labelLevelNumber.setFont(fontNumberLabelAffine);
        labelLevelNumber.setForeground(Style.ACTIVE_COLOR);
        labelLevelNumber.setHorizontalAlignment(JLabel.RIGHT);
        labelLevelNumber.setText(String.valueOf(MapGamePanel.getNumberLevel()));
        labelLevelNumber.setSize(80,30);
        labelLevelNumber.setLocation(CellSize.getSizeCell()  /2,CellSize.getSizeCell()  * 11 - CellSize.getSizeCell()  /2);
        add(labelLevelNumber);
        if(!ControlPanel.isPressedButtonOnOff) {
            remove(labelLevelNumber);
        }
    }

    private void setLabelSpeedNumber(){

        labelSpeedNumber.setFont(fontNumberLabelAffine);
        labelSpeedNumber.setForeground(Style.ACTIVE_COLOR);
        labelSpeedNumber.setHorizontalAlignment(JLabel.RIGHT);
        labelSpeedNumber.setText(String.valueOf(MapGamePanel.getNumberSpeed()));
        labelSpeedNumber.setSize(80,30);
        labelSpeedNumber.setLocation(CellSize.getSizeCell()  /2,CellSize.getSizeCell()  * 13 - CellSize.getSizeCell()  /5);
        add(labelSpeedNumber);
        if(!ControlPanel.isPressedButtonOnOff) {
            remove(labelSpeedNumber);
        }
    }

    private void setLabelPause() {
        labelPause.setFont(fontTextLabelAffine);
        labelPause.setForeground(Style.NO_ACTIVE_COLOR);
        if (!MapGamePanel.isGameOver) {
            if (ControlPanel.isPressedButtonPause) {
                delayAnimationPause++;
                if (delayAnimationPause < MAX_DELAY_ANIMATION_PAUSE/2) {
                    labelPause.setForeground(Style.ACTIVE_COLOR);
                }
                if (delayAnimationPause > MAX_DELAY_ANIMATION_PAUSE/2) {
                    labelPause.setForeground(Style.NO_ACTIVE_COLOR);
                }
                if (delayAnimationPause > MAX_DELAY_ANIMATION_PAUSE) {
                    delayAnimationPause = MIN_DELAY_ANIMATION_PAUSE;
                }
            }
        }

        labelPause.setText("Pause");
        labelPause.setSize(100, 20);
        labelPause.setLocation(CellSize.getSizeCell()  + CellSize.getSizeCell()  / 2 + 6, CellSize.getSizeCell()  * 14 + CellSize.getSizeCell()  / 3);
        add(labelPause);
    }

     private void setLabelGameOver(){
        labelGameOver.setFont(fontTextLabelAffine);
        if(!ControlPanel.isPressedButtonOnOff||!MapGamePanel.isGameOver) {
            labelGameOver.setForeground(Style.NO_ACTIVE_COLOR);
        }else {
            labelGameOver.setForeground(Style.ACTIVE_COLOR);
        }
        labelGameOver.setText("<html>GAME<br>OVER</html>");
        labelGameOver.setSize(100,40);
        labelGameOver.setLocation(CellSize.getSizeCell()  + CellSize.getSizeCell()  /2 + 6,CellSize.getSizeCell()  *16-CellSize.getSizeCell()  /2);
        add(labelGameOver);
    }

     private void setLabelSound(){
        labelSound.setFont(fontTextLabelAffine);
        if(!ControlPanel.isPressedButtonOnOff||!ControlPanel.isPressedButtonSound) {
            labelSound.setForeground(Style.NO_ACTIVE_COLOR);
        }else {
            labelSound.setForeground(Style.ACTIVE_COLOR);
        }
        labelSound.setText("<html>&#9835</html>");
        labelSound.setSize(100,40);
        labelSound.setLocation(CellSize.getSizeCell()  + CellSize.getSizeCell() /2 + 40,CellSize.getSizeCell()  *18-CellSize.getSizeCell()  /2);
        add(labelSound);
    }
}
