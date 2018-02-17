package my.project.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

    class ControlPanel extends JPanel{

    static boolean isPressedButtonLeft = false;
    static boolean isPressedButtonRight = false;
    static boolean isPressedButtonDown = false;
    static boolean isPressedButtonRotate = false;
    static boolean isPressedButtonPause = false;
    static boolean isPressedButtonSound = true;
    static boolean isPressedButtonStart = false;
    static boolean isPressedButtonOnOff = false;

    private static Sound  soundClicButonIfGameOver = new Sound(0.9f, "src\\res\\clicButonIfGameOver.wav");
    static  Sound  soundResetGame = new Sound(0.7f, "src\\res\\resetGame.wav");
    private static Sound  soundNewGame = new Sound(0.9f, "src\\res\\newGame.wav");

    private CanvasPanel canvasPanel = new CanvasPanel();
    private BodyPanelColumn bodyPanelColumn = new BodyPanelColumn();
    private final static int ROW = 9;
    int controlPanelHight = CellSize.getSizeCell() *ROW;
    private int controlPanelWight = canvasPanel.canvasPanelSizeWight + bodyPanelColumn.bodyPanelWight*2;
    private Style style = new Style();
    private int speedGame = 0;
    private int levelGame = 0;
    private int nextGame = 0;

    ControlPanel(){
        setPreferredSize(new Dimension(controlPanelWight, controlPanelHight));
        setButtonAndLabel();
        setBackground(Style.BODY_COLOR);
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
        setLayout(null);
        setVisible(true);

    }

    private class MyKeyAdapter extends KeyAdapter{

        @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();

            if(key == KeyEvent.VK_ENTER ) {
                if(isPressedButtonOnOff) {
                    isPressedButtonStart = true;
                    new MapGamePanel();
                    if( isPressedButtonSound) {
                        soundNewGame.stopPlay();
                        soundNewGame.sound();
                        soundNewGame.playSound(true);
                    }
                    isPressedButtonPause = false;
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                    }
                    if (MapGamePanel.isInitGame) {
                        MapGamePanel.setCountShotGameOver(0);
                        MapGamePanel.setCountScoreForSpeedUp(0);
                        MapGamePanel.setScore(0);
                        MapGamePanel.isGameOver = false;
                        MapGamePanel.isDrowDemoAnimation = false;
                        MapGamePanel.isDrowAnimationGo = true;

                    }
                }
            }

            if(key == KeyEvent.VK_CONTROL ) {

                soundClicButonIfGameOver.stopPlay();
                soundClicButonIfGameOver.sound();
                soundClicButonIfGameOver.playSound();

                if(!isPressedButtonOnOff){
                    isPressedButtonOnOff = true;
                    isPressedButtonSound = true;
                    soundNewGame.stopPlay();

                    soundResetGame.stopPlay();
                    soundResetGame.sound();
                    soundResetGame.playSound(true);
                }else {
                    soundResetGame.stopPlay();
                    soundNewGame.stopPlay();
                    isPressedButtonOnOff = false;
                    MapGamePanel.isGameOver=true;
                    MapGamePanel.isDrowAnimationResetField = false;
                    MapGamePanel.isDrowDemoAnimation = false;
                    MapGamePanel.setNumberSpeed(0);
                    speedGame = 0;
                    MapGamePanel.setScore(0);
                    MapGamePanel.setNumberLevel(0);
                    levelGame = 0;
                    MapGamePanel.setNextGame(0);
                    nextGame = 0;
                }
            }

            if(key == KeyEvent.VK_SPACE ) {
                if(isPressedButtonOnOff) {
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                    }
                    if (!isPressedButtonPause) {
                        isPressedButtonPause = true;
                    } else {
                        isPressedButtonPause = false;
                    }
                }
            }

            if(key == KeyEvent.VK_S ) {
                if(isPressedButtonOnOff) {
                    soundClicButonIfGameOver.stopPlay();
                    soundClicButonIfGameOver.sound();
                    soundClicButonIfGameOver.playSound();
                    if (!isPressedButtonSound) {
                        isPressedButtonSound = true;
                        soundNewGame.stopPlay();
                        if(MapGamePanel.isGameOver) {
                            MapGamePanel.soundDemo.stopPlay();
                            MapGamePanel.soundDemo.sound();
                            MapGamePanel.soundDemo.playSound(true);
                            MapGamePanel.soundDemo.setLoop();
                        }

                    } else {
                        isPressedButtonSound = false;
                        soundNewGame.stopPlay();
                        soundResetGame.stopPlay();
                        MapGamePanel.soundDemo.stopPlay();
                    }
                }

            }

            if(key == KeyEvent.VK_LEFT) {
                if(isPressedButtonOnOff) {
                    isPressedButtonLeft = true;
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                        levelGame++;
                        if (levelGame > 10) {
                            levelGame = 0;
                        }
                        MapGamePanel.setNumberLevel(levelGame);
                    }
                }
            }

            if(key == KeyEvent.VK_RIGHT) {
                if(isPressedButtonOnOff) {
                    isPressedButtonRight = true;
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                        speedGame++;
                        if (speedGame > 10) {
                            speedGame = 0;
                        }
                        MapGamePanel.setNumberSpeed(speedGame);
                    }
                }
            }

            if(key == KeyEvent.VK_DOWN) {
                if(isPressedButtonOnOff) {
                    isPressedButtonDown = true;
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                    }

                }
                if(MapGamePanel.isGameOver &&MapGamePanel.isDrowDemoAnimation){
                    nextGame++;
                    if(nextGame>7){nextGame=0;}
                    MapGamePanel.setNextGame(nextGame);}
            }

            if(key == KeyEvent.VK_UP) {
                if(isPressedButtonOnOff) {
                    isPressedButtonRotate = true;
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                    }
                }
            }

        }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                int key = e.getKeyCode();

                if(key == KeyEvent.VK_ENTER ) {

                }

                if(key == KeyEvent.VK_CONTROL ) {

                }

                if(key == KeyEvent.VK_SPACE ) {

                }

                if(key == KeyEvent.VK_S ) {

                }

                if(key == KeyEvent.VK_LEFT) {
                    isPressedButtonLeft = false;
                }

                if(key == KeyEvent.VK_RIGHT) {
                    isPressedButtonRight = false;
                }

                if(key == KeyEvent.VK_DOWN) {
                    isPressedButtonDown = false;
                }

                if(key == KeyEvent.VK_UP) {
                    isPressedButtonRotate = false;
                }

            }

    }

    private void setButtonAndLabel(){
        setButtonStart();
        setButtonOnOff();
        setButtonPause();
        setButtonSound();
        setButtonLeft();
        setButtonRight();
        setButtonDown();
        setButtonRotate();
    }


   private void setButtonStart(){
        Button buttonStart = new Button(20);
        buttonStart.setLocation(CellSize.getSizeCell() * 4,CellSize.getSizeCell());
        buttonStart.setSize(22,22);
        add(buttonStart);
        JLabel labelButtonStat = new JLabel();
        labelButtonStat.setFont(style.bodyTextLabel);
        labelButtonStat.setForeground(Style.BODY_LABEL);
        labelButtonStat.setText("<html>START/RESET<br>&nbsp;&nbsp;&nbsp;&nbsp;(ENTER)</html>");
        labelButtonStat.setSize(100,20);
        labelButtonStat.setLocation(CellSize.getSizeCell() * 3 ,CellSize.getSizeCell() * 2 - 2);
        add(labelButtonStat);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(isPressedButtonOnOff) {
                isPressedButtonStart = true;
                     new MapGamePanel();
                   if( isPressedButtonSound) {
                       soundNewGame.stopPlay();
                       soundNewGame.sound();
                       soundNewGame.playSound(true);
                   }
                isPressedButtonPause = false;
                if (MapGamePanel.isGameOver) {
                    if (isPressedButtonSound) {
                        soundClicButonIfGameOver.stopPlay();
                        soundClicButonIfGameOver.sound();
                        soundClicButonIfGameOver.playSound();
                    }
                }
                if (MapGamePanel.isInitGame) {
                    MapGamePanel.setCountShotGameOver(0);
                    MapGamePanel.setCountScoreForSpeedUp(0);
                    MapGamePanel.setScore(0);
                    MapGamePanel.isGameOver = false;
                    MapGamePanel.isDrowDemoAnimation = false;
                    MapGamePanel.isDrowAnimationGo = true;

                }
                 }
                requestFocus();
            }
        });
    }
   private void setButtonOnOff(){
        Button buttonOnOff = new Button(20);
        buttonOnOff.setLocation(CellSize.getSizeCell() *7+10,CellSize.getSizeCell());
        buttonOnOff.setSize(22,22);
        add(buttonOnOff);
        JLabel labelButtonOnOff = new JLabel();
        labelButtonOnOff.setFont(new Style().bodyTextLabel);
        labelButtonOnOff.setForeground(Style.BODY_LABEL);
        labelButtonOnOff.setText("<html>ON/OFF<br>(CTRL)</html>");
        labelButtonOnOff.setSize(100,20);
        labelButtonOnOff.setLocation(CellSize.getSizeCell() * 7 + 1 ,CellSize.getSizeCell() * 2 - 2);
        add(labelButtonOnOff);
        buttonOnOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                soundClicButonIfGameOver.stopPlay();
                soundClicButonIfGameOver.sound();
                soundClicButonIfGameOver.playSound();

                if(!isPressedButtonOnOff){
                    isPressedButtonOnOff = true;
                    isPressedButtonSound = true;
                    soundNewGame.stopPlay();

                    soundResetGame.stopPlay();
                    soundResetGame.sound();
                    soundResetGame.playSound(true);
                }else {
                    soundResetGame.stopPlay();
                    soundNewGame.stopPlay();
                    isPressedButtonOnOff = false;
                    MapGamePanel.isGameOver=true;
                    MapGamePanel.isDrowAnimationResetField = false;
                    MapGamePanel.isDrowDemoAnimation = false;
                    MapGamePanel.setNumberSpeed(0);
                    speedGame = 0;
                    MapGamePanel.setScore(0);
                    MapGamePanel.setNumberLevel(0);
                    levelGame = 0;
                    MapGamePanel.setNextGame(0);
                    nextGame = 0;
                }
                requestFocus();
            }
        });
    }
   private void setButtonPause(){
        Button buttonPause = new Button(20);
        buttonPause.setLocation(CellSize.getSizeCell() *10+15, CellSize.getSizeCell());
        buttonPause.setSize(22,22);
        add(buttonPause);
        JLabel labelButtonPause = new JLabel();
        labelButtonPause.setFont(style.bodyTextLabel);
        labelButtonPause.setForeground(Style.BODY_LABEL);
        labelButtonPause.setText("<html>&nbsp;PAUSE<br>(SPACE)</html>");
        labelButtonPause.setSize(100,20);
        labelButtonPause.setLocation(CellSize.getSizeCell() * 10 + 5 ,CellSize.getSizeCell() * 2 - 2);
        add(labelButtonPause);
        buttonPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isPressedButtonOnOff) {
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                    }
                    if (!isPressedButtonPause) {
                        isPressedButtonPause = true;
                    } else {
                        isPressedButtonPause = false;
                    }
                }
                requestFocus();
            }
        });
    }
   private void setButtonSound(){
        Button buttonMuzic = new Button(20);
        buttonMuzic.setLocation(CellSize.getSizeCell() *14, CellSize.getSizeCell());
        buttonMuzic.setSize(22,22);
        add(buttonMuzic);
        JLabel labelButtonMuzic = new JLabel();
        labelButtonMuzic.setFont(style.bodyTextLabel);
        labelButtonMuzic.setForeground(Style.BODY_LABEL);
        labelButtonMuzic.setText("<html>SOUND<br>&nbsp;&nbsp;&nbsp;(S)</html>");
        labelButtonMuzic.setSize(100,20);
        labelButtonMuzic.setLocation(CellSize.getSizeCell() * 14-6 ,CellSize.getSizeCell() * 2 - 2);
        add(labelButtonMuzic);
        buttonMuzic.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isPressedButtonOnOff) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                    if (!isPressedButtonSound) {
                        isPressedButtonSound = true;
                        soundNewGame.stopPlay();
                         if(MapGamePanel.isGameOver) {
                             MapGamePanel.soundDemo.stopPlay();
                             MapGamePanel.soundDemo.sound();
                             MapGamePanel.soundDemo.playSound(true);
                             MapGamePanel.soundDemo.setLoop();
                         }

                    } else {
                        isPressedButtonSound = false;
                        soundNewGame.stopPlay();
                        soundResetGame.stopPlay();
                        MapGamePanel.soundDemo.stopPlay();
                    }
                }
                requestFocus();
            }

        });
    }
   private void setButtonLeft(){
        Button buttonLeft = new Button(40);
        buttonLeft.setLocation(CellSize.getSizeCell() *3 - 10, CellSize.getSizeCell() *3);
        buttonLeft.setSize(60,60);
        add(buttonLeft);
        JLabel labelButtonLeft = new JLabel();
        labelButtonLeft.setFont(style.bodyTextLabel);
        labelButtonLeft.setForeground(Style.BODY_LABEL);
        labelButtonLeft.setText("<html>&nbsp; LEFT<br>(LEVEL)</html>");
        labelButtonLeft.setSize(100,20);
        labelButtonLeft.setLocation(CellSize.getSizeCell() * 3-10 ,CellSize.getSizeCell() * 5 - 4);
        add(labelButtonLeft);
        buttonLeft.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

                if(isPressedButtonOnOff) {
                    isPressedButtonLeft = true;
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                        levelGame++;
                        if (levelGame > 10) {
                            levelGame = 0;
                        }
                        MapGamePanel.setNumberLevel(levelGame);
                    }
                }
                requestFocus();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressedButtonLeft = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
   private void setButtonRight(){
        Button buttonRight = new Button(40);
        buttonRight.setLocation(CellSize.getSizeCell() *7 - 10, CellSize.getSizeCell() *3);
        buttonRight.setSize(60,60);
        add(buttonRight);
        JLabel labelButtonRight = new JLabel();
        labelButtonRight.setFont(style.bodyTextLabel);
        labelButtonRight.setForeground(Style.BODY_LABEL);
        labelButtonRight.setText("<html>&nbsp;RIGHT<br>(SPEED)</html>");
        labelButtonRight.setSize(100,20);
        labelButtonRight.setLocation(CellSize.getSizeCell() * 7 - 7 ,CellSize.getSizeCell() * 5 - 4);
        add(labelButtonRight);
        buttonRight.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(isPressedButtonOnOff) {
                    isPressedButtonRight = true;
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                        speedGame++;
                        if (speedGame > 10) {
                            speedGame = 0;
                        }
                        MapGamePanel.setNumberSpeed(speedGame);
                    }
                }
                requestFocus();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressedButtonRight = false;

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
   private void setButtonDown(){
        Button buttonDown = new Button(40);
        buttonDown.setLocation(CellSize.getSizeCell()*5 - 10, CellSize.getSizeCell() *5);
        buttonDown.setSize(60,60);
        add(buttonDown);
        JLabel labelButtonDown = new JLabel();
        labelButtonDown.setFont(style.bodyTextLabel);
        labelButtonDown.setForeground(Style.BODY_LABEL);
        labelButtonDown.setText("<html>&nbsp;DOWN<br>(GAME)</html>");
        labelButtonDown.setSize(40,50);
        labelButtonDown.setLocation(CellSize.getSizeCell() * 5- 10 ,CellSize.getSizeCell() * 6+4  );
        add(labelButtonDown);
        buttonDown.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(isPressedButtonOnOff) {
                    isPressedButtonDown = true;
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                    }

                    if (MapGamePanel.isGameOver && MapGamePanel.isDrowDemoAnimation) {
                        nextGame++;
                        if (nextGame > 7) {
                            nextGame = 0;
                        }

                        MapGamePanel.setNextGame(nextGame);
                    }
                }
                requestFocus();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressedButtonDown = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
   private void setButtonRotate(){

        Button buttonRotate = new Button(70);
        buttonRotate.setLocation(CellSize.getSizeCell() *13+10, CellSize.getSizeCell() *3 + 10);
        buttonRotate.setSize(80,80);
        add(buttonRotate);
        JLabel labelButtonRotate = new JLabel();
        labelButtonRotate.setFont(style.bodyTextLabel);
        labelButtonRotate.setForeground(Style.BODY_LABEL);
        labelButtonRotate.setText("<html>ROTATE<br>&nbsp;&nbsp;(UP)</html>");
        labelButtonRotate.setSize(100,20);
        labelButtonRotate.setLocation(CellSize.getSizeCell() * 15 - 22 ,CellSize.getSizeCell() * 7-12);
        add(labelButtonRotate);
        buttonRotate.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(isPressedButtonOnOff) {
                    isPressedButtonRotate = true;
                    if (MapGamePanel.isGameOver) {
                        if (isPressedButtonSound) {
                            soundClicButonIfGameOver.stopPlay();
                            soundClicButonIfGameOver.sound();
                            soundClicButonIfGameOver.playSound();
                        }
                    }
                }
                requestFocus();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressedButtonRotate = false;

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
