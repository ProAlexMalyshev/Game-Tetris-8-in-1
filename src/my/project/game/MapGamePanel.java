package my.project.game;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

public class MapGamePanel extends JPanel {

    static Sound soundDemo = new Sound(0.5f, "src\\res\\demo.wav");
    static Sound move = new Sound(0.8f, "src\\res\\move.wav");
    static Sound rotate = new Sound(0.8f, "src\\res\\rotate.wav");
    private static Sound touchFloor = new Sound(0.6f, "src\\res\\touchBottomFloor.wav");

    private static final int COUNT_TOUCH_FLOOR_MIN = 0;
    private static final int COUNT_TOUCH_FLOOR_MAX = 1;
    private static int countTouchFloor = COUNT_TOUCH_FLOOR_MIN;
    private boolean isPlaySoundTouchFloor = false;

    private static Sound soundDelRow = new Sound(0.9f, "src\\res\\delRow.wav");

    private Animation animation;
    private int delayShotResetField = 0;
    private static final int DELAY_SHOT_RESET_FIELD_MAX = 2;
    private static final int DELAY_SHOT_RESET_FIELD_MIN = 0;
    private boolean isDrowAnimationResetFieldUp = false;
    static boolean isDrowAnimationResetField = false;
    static int numberShotAnimationResetField =0;

    static boolean isDrowDemoAnimation = false;
    private static final int DELAY_SHOT_ANIMATION_DEMO_GAME_MIN = 0;
    private static final int DELAY_SHOT_ANIMATION_DEMO_GAME_MAX = 30;
    private int delayShotAnimationDemoGame = DELAY_SHOT_ANIMATION_DEMO_GAME_MIN;
    private static final int NUMBER_SHOT_ANIMATION_DEMO_GAME_MIN = 0;
    private static final int NUMBER_SHOT_ANIMATION_DEMO_GAME_MAX = 5;
    static int numberShotAnimationDemoGame = NUMBER_SHOT_ANIMATION_DEMO_GAME_MIN;

    static boolean isDrowAnimationGo=false;
    private static final int DELAY_SHOT_ANIMATION_GO_MIN = 0;
    private static final int DELAY_SHOT_ANIMATION_GO_MAX = 30;
    private int delayShotAnimationGo = DELAY_SHOT_ANIMATION_GO_MIN;
    private static final int NUMBER_SHOT_ANIMATION_GO_MIN = 0;
    private static final int NUMBER_SHOT_ANIMATION_GO_MAX = 3;
    static int numberShotAnimationGo = NUMBER_SHOT_ANIMATION_GO_MIN;

    private static final int DELAY_ANIMATION_DELETE_ROW_MIN = 0;
    private static final int DELAY_ANIMATION_DELETE_ROW_MAX = 3;
    private int delayAnimationDeleteRow = DELAY_ANIMATION_DELETE_ROW_MIN;
    private static boolean isAnimationDeleteRow = false;
    private static boolean isStartCountDalayDeleteRow = false;
    private static final int DELAY_DELETE_ROW_MIN = 0;
    private static final int DELAY_DELETE_ROW_MAX = 60;
    private static final int DELAY_DELETE_ROW_HALF = DELAY_DELETE_ROW_MAX / 2;
    private int delayDeleteRow = DELAY_DELETE_ROW_MIN;
    private boolean isDeleteRow = false;
    private static int colDelRow = 0;
    private int countDeleteRow = 0;

    private static final int DELAY_SHOT_ANIMATION_GAME_OVER_MIN = 0;
    private static final int DELAY_SHOT_ANIMATION_GAME_OVER_MAX = 2;
    private int delayShotAnimationGameOver = DELAY_SHOT_ANIMATION_GAME_OVER_MIN;

    private static final int COUNT_SHOT_ANIMATION_GAME_OVER_MAX = 65;
    private static final int COUNT_SHOT_ANIMATION_PLAY_SOUND_RESET_GAME = 40;
    static int countShotAnimationGameOver = COUNT_SHOT_ANIMATION_GAME_OVER_MAX;
    boolean isAnimationGameOver = false;

    private final static int ROW = 22;
    private final static int COLUMN = 11;
    int mapPanelHight = CellSize.getSizeCell()  * ROW-3;
    int mapPanelWight = CellSize.getSizeCell() * COLUMN;

    private final static int MIN_MAP = 0;
    final static int HIGHT_MAP = 20;
    final static int WIDTH_MAP = 10;
    static int [][] fieldGame = new int[HIGHT_MAP][WIDTH_MAP];

    private GenerateTetramino generateTetramino;
    private Tetramino tetramino;

    private static int nextGame = 0;

    private static int numberLevel = 0;
    private final static int MAX_LEVEL = 10;
    private final static int MIN_LEVEL = 0;

    private int [][] level = new int[HIGHT_MAP][WIDTH_MAP];
    private static final int RANDOM_BOUND = 2;
    private Random random = new Random();
    private int levelGame=(HIGHT_MAP-1)-getNumberLevel();


    private final static int MAX_SCORE_FOR_SPEED_UP = 8000;
    private final static int ZERO_SCORE = 0;
    private final static int MAX_SPEED = 10;
    private final static int MIN_SPEED = 0;
    private static int numberSpeed = 0;
    private static int countScoreForSpeedUp =0;

    private static int score = 0;

    private final static String HI_SCORE = new File("src\\res\\HiScore.txt").getAbsolutePath();
    private static int hiScore=0;
    private int inputScore=0;

    private static final int SIZE_ARR_TETRAMINO = 4;
    private int[][] tetraminoNext;
    private int [][] tetraminoStart;
    private int [][] tetraminoLast;
    private int positionX;
    private int positionY;
    private boolean isSetColor = true;
    static boolean isGameOver = true;
    static boolean isInitGame = false;

    private boolean isResetDelayCompletedDownTetramino = false;
    private  static boolean isCompletedDownTetramino = false;
    private final static int DELAY_COMPLETED_DOWN_TETRAMINO_MIN = 0;
    private final static int DELAY_COMPLETED_DOWN_TETRAMINO_MAX = 30;
    private int delayCompletedDownTetramino = DELAY_COMPLETED_DOWN_TETRAMINO_MIN;


    MapGamePanel(){
        setPreferredSize(new Dimension( mapPanelWight,  mapPanelHight));
        setBackground(Style.CANVAS_COLOR);
        initLevelGame();
        setVisible(true);
    }

    static int getNumberLevel(){return numberLevel;}
    static void setNumberLevel(int inNumberLevel){numberLevel = inNumberLevel;}

    static int getHiScore(){return hiScore;}

    static int getNumberSpeed(){ return numberSpeed;}
    static void setNumberSpeed(int inNumberSpeedLevel){ numberSpeed =inNumberSpeedLevel;}

    static int getCountScoreForSpeedUp(){return countScoreForSpeedUp;}
    static void setCountScoreForSpeedUp(int inputCountScoreForSpeedUp){countScoreForSpeedUp = inputCountScoreForSpeedUp;}

    static int getScore(){return score;}
    static void setScore(int inputScore){ score=inputScore;}

    static void setCountShotGameOver (int setCountShotGameOver){countShotAnimationGameOver = setCountShotGameOver;}

    static void setNextGame(int setNextGame){nextGame=setNextGame;}
    static int getNumberGame(){return nextGame;}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        BasicStroke pint1 = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2D.setStroke(pint1);
        g2D.setColor(Style.ACTIVE_COLOR);
        g2D.drawRect(3, 3, getWidth() - 6, getHeight() - 6);

        update();
        render(g);

        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
        isInitGame = true;
    }

    private void update (){

        if(!ControlPanel.isPressedButtonOnOff){
            soundDemo.stopPlay();
            numberShotAnimationResetField = MIN_MAP - 1;
            isAnimationGameOver = false;
            isDrowAnimationGo = false;
            isDrowAnimationResetField = false;
            tetraminoLast = null;
            tetraminoNext = null;
            tetraminoStart = null;
            tetramino = null;
            resetField();
            ControlPanel.isPressedButtonStart = false;
        }

        if(ControlPanel.isPressedButtonOnOff) {
            if (!isDrowAnimationResetField && ControlPanel.soundResetGame.getFramePosition() > 152900 && ControlPanel.soundResetGame.getFramePosition() < 154900) {
                soundDemo.stopPlay();
                soundDemo.sound();
                soundDemo.playSound(true);
                soundDemo.setLoop();
            }
            GenerateTetramino.setNextGame(getNumberGame());
            setLevelGame();
            speedGame();
            hiScore();
            if(ControlPanel.isPressedButtonStart){
                ControlPanel.soundResetGame.stopPlay();
                soundDemo.stopPlay();
                ControlPanel.isPressedButtonStart = false;
            }

         if(!isGameOver && !isDrowAnimationGo) {
             initNextTetramino();
             if (isCompletedDownTetramino) {
                 initCompletedMap();
                 newTetramino();
                 isCompletedDownTetramino = false;
                 countTouchFloor = COUNT_TOUCH_FLOOR_MIN;
             }
             if(isPlaySoundTouchFloor){
                 soundTouchFloor();
                 isPlaySoundTouchFloor = false;
             }
             if(tetramino!=null) {
                 tetramino.update();
             }

             if(isDeleteRow) {
                 deleteRow();
                 isDeleteRow = false;
             }
              setDelayCompletedDownTetramino();
              countScore();
         }
        }
    }


    private void render (Graphics g){
        drawBackgroundMap(g);

        if(ControlPanel.isPressedButtonOnOff) {
            if(isGameOver) {
                if (!isDrowDemoAnimation) {
                    isDrowAnimationResetField = true;
                }

                if (isDrowAnimationResetField) {
                    if(!isAnimationGameOver) {
                        animationResetField(g);
                    }
                }

                if (isDrowDemoAnimation) {
                    if (nextGame == 0) {
                        demoAnimationOne(g);
                    } else if(nextGame == 1){
                        demoAnimationOne(g);
                    } else {
                        demoAnimationTwo(g);
                    }
                    animationSelectionGame(g);
                }
            }
            if (isDrowAnimationGo) {
                animationGo(g);

            }
            if(!isDrowAnimationGo) {
                drawCompletedMap(g);
            }
            if (!isGameOver && !isDrowAnimationGo) {
                if (tetramino != null) {
                    tetramino.render(g);
                }
                animationDeleteRow(g);
            }
            if (isGameOver && tetraminoLast != null) {
                drawLastTetramino(g);
                isAnimationGameOver = true;
            }
            if(isAnimationGameOver){
                animationDrawGameOver(g);
            }
        }
        if(!ControlPanel.isPressedButtonOnOff) {

               TextAutor.textAutor(g);
        }
    }

    private void initLevelGame(){

     for (int i = 0; i <HIGHT_MAP ; i++) {
         for (int j = 0; j < WIDTH_MAP; j++) {
             int zeroOneRandom = random.nextInt(RANDOM_BOUND);
             if(i > levelGame){
                 level[i][j] = zeroOneRandom;
             }
         }
     }
     fieldGame = level;
 }

    private void setLevelGame(){
        if(numberLevel > MAX_LEVEL){
            numberLevel = MIN_LEVEL;
        }
    }

    private void speedGame(){
        if(getCountScoreForSpeedUp() >= MAX_SCORE_FOR_SPEED_UP){
            numberSpeed++;
            setCountScoreForSpeedUp(ZERO_SCORE);
        }
        if(numberSpeed > MAX_SPEED){
            numberSpeed = MIN_SPEED;
        }
    }

    private void initNextTetramino(){
     generateTetramino = new GenerateTetramino();
     if(generateTetramino.getTetramino()!=null) {
         if(tetraminoNext==null) {
             tetraminoNext = new int[SIZE_ARR_TETRAMINO][SIZE_ARR_TETRAMINO];
             tetraminoNext = generateTetramino.getTetramino();
             PreviewPanel.fieldPreview = tetraminoNext;
         }
     }
     if(tetraminoStart==null) {
         tetraminoStart = new int[SIZE_ARR_TETRAMINO][SIZE_ARR_TETRAMINO];
         tetraminoStart = tetraminoNext;
         Tetramino.tetramino = tetraminoStart;
         tetraminoNext=null;
     }
 }

    private void initCompletedMap(){
        if(tetramino!=null){
            positionX=tetramino.getPositionX();
            positionY=tetramino.getPositionY();
            isGameOver();
            if (tetramino.isTouchBottomFloor() && !isGameOver) {
                for (int i = 0; i < tetramino.getTetramino().length; i++) {
                    for (int j = 0; j < tetramino.getTetramino()[i].length; j++) {
                        try {
                            if (tetramino.getTetramino()[i][j] == 1) {
                                fieldGame[tetramino.getPositionY() + i][tetramino.getPositionX() + j] = 1;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

        }
    }

    private void isGameOver (){
        for (int i = 0; i <fieldGame.length ; i++) {
            for (int j = 0; j <fieldGame[i].length ; j++) {
                if(i<=tetramino.sizeTetraminoHight()&&fieldGame[i][j]==1){
                    if(tetramino.isTouchBottomFloor()&&(tetramino.getPositionY()+1)<=0||tetramino.isTouchBottomFloor()&&(tetramino.getPositionY())<=0){
                        isGameOver = true;}
                }
            }
        }
        if(isGameOver) {
            for (int i = 5; i < fieldGame.length - 6; i++) {
                for (int j = 0; j < fieldGame[i].length; j++) {
                    if (fieldGame[i][j] == 1) {
                        fieldGame[i][j] = 0;
                    }
                }
            }
        }
    }

    private void newTetramino(){

        if (tetramino == null || tetramino.isTouchBottomFloor()) {
            if (tetraminoStart != null) {
                tetraminoLast = tetraminoStart;
            }
            tetraminoStart = null;
            tetramino = new Tetramino();
        }
    }

    private void deleteRow(){
        boolean rowDel = false;
        int nRow=0;
        for (int i=0; i<fieldGame.length; i++){
            for (int j = 0; j < fieldGame[i].length; j++) {
                if(fieldGame[i][j]==0) {
                    break;
                }else{
                    if(j==WIDTH_MAP-1){
                        rowDel=true;
                    }
                }
            }
            if(rowDel){
                nRow=i;
                countDeleteRow++;
                break;
            }
            if(i==fieldGame.length-1){
                colDelRow = countDeleteRow;
                countDeleteRow =0;
            }
        }
        for (int i = 0; i <fieldGame.length ; i++) {
            for (int j = 0; j <fieldGame[i].length ; j++) {
                if(i==nRow){
                    fieldGame[i][j]=0;
                }
            }
        }
        for (int i = 0; i < fieldGame.length; i++) {
            for (int j = 0; j < fieldGame[i].length; j++) {
                if (i == nRow && i > 0) {
                    for (int k = 0; k <nRow ; k++) {
                        fieldGame[i-k][j] = fieldGame[i-(k+1)][j];
                    }
                }
            }
        }
    }

    private void countScore(){
        switch (colDelRow){
            case 1:{
                countScoreForSpeedUp = countScoreForSpeedUp +100;
                score=score+100;
                if(ControlPanel.isPressedButtonSound) {
                    soundDelRow.stopPlay();
                    soundDelRow.sound();
                    soundDelRow.playSound(true);
                }

                break;
            }
            case 2:{
                countScoreForSpeedUp = countScoreForSpeedUp +200;
                score=score+200;
                if(ControlPanel.isPressedButtonSound) {
                    soundDelRow.stopPlay();
                    soundDelRow.sound();
                    soundDelRow.playSound(true);
                }
                break;
            }
            case 3:{
                countScoreForSpeedUp = countScoreForSpeedUp +300;
                score=score+300;
                if(ControlPanel.isPressedButtonSound) {
                    soundDelRow.stopPlay();
                    soundDelRow.sound();
                    soundDelRow.playSound(true);
                }
                break;
            }
            case 4:{
                countScoreForSpeedUp = countScoreForSpeedUp +400;
                score=score+400;
                if(ControlPanel.isPressedButtonSound) {
                    soundDelRow.stopPlay();
                    soundDelRow.sound();
                    soundDelRow.playSound(true);
                }
                break;
            }
            default:{
                colDelRow = 0;

            }
        }
    }

    private void hiScore(){
        if(hiScore!=0 || !(new File(HI_SCORE)).exists()) {
            try (FileWriter writer = new FileWriter(HI_SCORE)) {
                String text = String.valueOf(hiScore);
                writer.write(text);
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try (Scanner scanner = new Scanner(new FileInputStream(HI_SCORE))) {
            while (scanner.hasNext()) {
                inputScore = Integer.parseInt(scanner.next());
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(inputScore > hiScore){
            hiScore = inputScore;
        }

        if(getScore() > hiScore){
            hiScore = getScore();
        }
    }

    private void setDelayCompletedDownTetramino(){

        delayCompletedDownTetramino++;
        if (delayCompletedDownTetramino == DELAY_COMPLETED_DOWN_TETRAMINO_MAX) {
            isCompletedDownTetramino = true;
            isResetDelayCompletedDownTetramino = false;
            delayCompletedDownTetramino = DELAY_COMPLETED_DOWN_TETRAMINO_MIN;
        }

        if(tetramino!=null&&tetramino.isTouchBottomFloor()&&!isResetDelayCompletedDownTetramino) {
            isResetDelayCompletedDownTetramino = true;
            delayCompletedDownTetramino = DELAY_COMPLETED_DOWN_TETRAMINO_MIN;
            countTouchFloor++;
            if (countTouchFloor == COUNT_TOUCH_FLOOR_MAX) {
                isPlaySoundTouchFloor = true;
            }
        }
    }

    private void drawBackgroundMap(Graphics g){
         for (int i = 0; i<HIGHT_MAP; i++){
             for (int j = 0; j < WIDTH_MAP; j++) {
                 new Part( j, i, g, !isSetColor);
             }
         }
    }

    private void drawCompletedMap(Graphics g){
        for (int i=0; i<HIGHT_MAP; i++){
            for (int j = 0; j < WIDTH_MAP; j++) {
                if(fieldGame[i][j]==1) {
                    new Part(j, i, g, isSetColor);
                }
            }
        }
    }

    private void animationDeleteRow(Graphics g) {

        delayAnimationDeleteRow++;
        if(delayAnimationDeleteRow > DELAY_ANIMATION_DELETE_ROW_MAX){
            if(isAnimationDeleteRow) {
                isAnimationDeleteRow = false;
            }else {
                isAnimationDeleteRow = true;
            }
            delayAnimationDeleteRow = DELAY_ANIMATION_DELETE_ROW_MIN;

        }

        for (int i=0; i<fieldGame.length; i++){
            for (int j = 0; j < fieldGame[i].length; j++) {
                if(fieldGame[i][j]==0) {
                    break;
                }else{
                    if(j==WIDTH_MAP-1){
                        int  nRowAnim=i;
                        for (int k = 0; k <fieldGame.length ; k++) {
                            for (int l = 0; l <fieldGame[k].length ; l++) {
                                if (k == nRowAnim) {
                                    new Part(l, k, g, isAnimationDeleteRow);
                                }
                            }
                        }
                        isStartCountDalayDeleteRow = true;
                    }
                }
            }
        }
        if(isStartCountDalayDeleteRow) {
            delayDeleteRow++;
        }
        if (delayDeleteRow < DELAY_DELETE_ROW_HALF) {
            isDeleteRow = false;
        }
        if (delayDeleteRow > DELAY_DELETE_ROW_HALF){
            isDeleteRow = true;
        }
        if(delayDeleteRow > DELAY_DELETE_ROW_MAX){
            isStartCountDalayDeleteRow = false;
            delayDeleteRow = DELAY_DELETE_ROW_MIN;

        }

    }

    private void drawLastTetramino(Graphics g){
        if(!isDrowDemoAnimation){
            for (int i = 0; i < tetraminoLast.length; i++) {
                for (int j = 0; j < tetraminoLast[i].length; j++) {
                    if (tetraminoLast[i][j] == 1) {
                        new Part(positionX + j, positionY + i, g, isSetColor);

                    }
                }
            }
        }

    }

    private void animationDrawGameOver(Graphics g){
        animation = new Animation();
        if(animation.getAnimationGameOver()!=null) {
            for (int i = 0; i < animation.getAnimationGameOver().length; i++) {
                for (int j = 0; j < animation.getAnimationGameOver()[i].length; j++) {
                    if (animation.getAnimationGameOver()[i][j] == 1) {
                        new Part(animation.getPositionShotGameOverX() + j, Animation.POSITION_SHOT_GAME_OVER_Y + i, g, isSetColor);
                    }
                }
            }
        }
        delayShotAnimationGameOver++;
        if(delayShotAnimationGameOver == DELAY_SHOT_ANIMATION_GAME_OVER_MAX){
            countShotAnimationGameOver++;
            delayShotAnimationGameOver = DELAY_SHOT_ANIMATION_GAME_OVER_MIN;
        }

        if(countShotAnimationGameOver > COUNT_SHOT_ANIMATION_GAME_OVER_MAX){
            isAnimationGameOver = false;
        }
    }

    private void animationResetField(Graphics g){
        animation = new Animation();
        if(animation.getAnimationResetField()!=null) {
            for (int i = 0; i < animation.getAnimationResetField().length; i++) {
                for (int j = 0; j < animation.getAnimationResetField()[i].length; j++) {
                    if(animation.getAnimationResetField()[i][j] == 1) {
                        new Part(Animation.POSITION_RESET_FIELD_X + j, Animation.POSITION_RESET_FIELD_Y + i, g, isSetColor);
                    }
                }
            }
        }

        delayShotResetField++;
        if(delayShotResetField == DELAY_SHOT_RESET_FIELD_MAX){
            if(!isDrowAnimationResetFieldUp) {
                numberShotAnimationResetField++;
            }else {
                numberShotAnimationResetField--;
            }
            delayShotResetField = DELAY_SHOT_RESET_FIELD_MIN;
        }

        if(numberShotAnimationResetField <= MIN_MAP  && !isDrowAnimationResetFieldUp){
            if(countShotAnimationGameOver > COUNT_SHOT_ANIMATION_PLAY_SOUND_RESET_GAME) {
               ControlPanel.soundResetGame.stopPlay();
                ControlPanel.soundResetGame.sound();
                ControlPanel.soundResetGame.playSound(true);
            }
        }

        if(numberShotAnimationResetField == HIGHT_MAP){
            isDrowDemoAnimation = true;
            isDrowAnimationResetFieldUp = true;
            tetraminoLast = null;
            resetField();
        }

        if(numberShotAnimationResetField == MIN_MAP - 1){
            isDrowAnimationResetFieldUp = false;
            isDrowAnimationResetField = false;
        }
    }

    private void resetField(){
        for (int i = 0; i < fieldGame.length; i++) {
            for (int j = 0; j < fieldGame[i].length; j++) {
                if (fieldGame[i][j] == 1) {
                    fieldGame[i][j] = 0;
                }
            }
        }
    }

    private void demoAnimationOne (Graphics g){
        animation = new Animation();
        if(animation.getShotAnimationDemoGameOne()!=null) {
            for (int i = 0; i < animation.getShotAnimationDemoGameOne().length; i++) {
                for (int j = 0; j < animation.getShotAnimationDemoGameOne()[i].length; j++) {
                    if(animation.getShotAnimationDemoGameOne()[i][j]==1) {
                        new Part(Animation.POSITION_SHOT_X + j, Animation.POSITION_SHOT_Y + i, g, isSetColor);
                    }
                }

            }
        }
        delayShotAnimationDemoGame++;
        if(delayShotAnimationDemoGame == DELAY_SHOT_ANIMATION_DEMO_GAME_MAX){
            numberShotAnimationDemoGame++;
            delayShotAnimationDemoGame = DELAY_SHOT_ANIMATION_DEMO_GAME_MIN;
        }
        if(numberShotAnimationDemoGame > NUMBER_SHOT_ANIMATION_DEMO_GAME_MAX){
            numberShotAnimationDemoGame = NUMBER_SHOT_ANIMATION_DEMO_GAME_MIN;
        }
    }

    private void demoAnimationTwo(Graphics g){
        animation = new Animation();
        if(animation.getShotAnimationDemoGameTwo()!=null) {
            for (int i = 0; i < animation.getShotAnimationDemoGameTwo().length; i++) {
                for (int j = 0; j < animation.getShotAnimationDemoGameTwo()[i].length; j++) {
                    if(animation.getShotAnimationDemoGameTwo()[i][j]==1) {
                        new Part(Animation.POSITION_SHOT_DEMO_TWO_X + j, Animation.POSITION_SHOT_DEMO_TWO_Y + i, g, isSetColor);
                    }
                }
            }
        }
        delayShotAnimationDemoGame++;
        if(delayShotAnimationDemoGame == DELAY_SHOT_ANIMATION_DEMO_GAME_MAX){
            numberShotAnimationDemoGame++;
            delayShotAnimationDemoGame = DELAY_SHOT_ANIMATION_DEMO_GAME_MIN;
        }
        if(numberShotAnimationDemoGame > NUMBER_SHOT_ANIMATION_DEMO_GAME_MAX){
            numberShotAnimationDemoGame = NUMBER_SHOT_ANIMATION_DEMO_GAME_MIN;}
    }

    private void animationSelectionGame(Graphics g){
        animation = new Animation();
        if(animation.getShotAnimationSelectionGame()!=null) {
            for (int i = 0; i < animation.getShotAnimationSelectionGame().length; i++) {
                for (int j = 0; j < animation.getShotAnimationSelectionGame()[i].length; j++) {
                    if (animation.getShotAnimationSelectionGame()[i][j] == 1) {
                        new Part(Animation.POSITION_SHOT_SELECTION_GAME_X + j, Animation.POSITION_SHOT_SELECTION_GAME_Y + i, g, isSetColor);
                    }
                }
            }
        }
    }

    private void animationGo(Graphics g){
        animation = new Animation();
        if(animation.getShotAnimationGo()!=null) {
            for (int i = 0; i < animation.getShotAnimationGo().length; i++) {
                for (int j = 0; j < animation.getShotAnimationGo()[i].length; j++) {
                    if(animation.getShotAnimationGo()[i][j]==1) {
                        new Part(Animation.POSITION_SHOT_ONE_GO_X+ j, Animation.POSITION_SHOT_ONE_GO_Y + i, g, isSetColor);
                    }
                }
            }
        }
        delayShotAnimationGo++;
        if(delayShotAnimationGo == DELAY_SHOT_ANIMATION_GO_MAX){
            numberShotAnimationGo++;
            delayShotAnimationGo = DELAY_SHOT_ANIMATION_GO_MIN;
        }

        if(numberShotAnimationGo > NUMBER_SHOT_ANIMATION_GO_MAX){
            numberShotAnimationGo = NUMBER_SHOT_ANIMATION_GO_MIN;
            isDrowAnimationGo = false;
            tetramino = null;
            tetraminoNext = null;
        }
    }

    void soundTouchFloor(){
        if(ControlPanel.isPressedButtonSound) {
             touchFloor.stopPlay();
             touchFloor.sound();
             touchFloor.playSound(true);
        }
    }

}