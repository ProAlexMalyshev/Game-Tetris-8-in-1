package my.project.game;

import java.awt.*;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */
   class Tetramino {

    private Graphics g;
    private static final int SIZE_ARR = 4;
    static int [][] tetramino;
    private int positionX = 3;
    private int positionY = -4;
    private float speedFall = 0;
    private float speedRotate = 0;
    private float speedX = 0;
    private float delaySoundDown = 0;
    private float delaySpeedFall = 0;

    Tetramino(){
       setSpeedFall();
       ControlPanel.isPressedButtonDown = false;
    }
    int getPositionX(){return positionX;}
    int getPositionY(){return positionY;}
    int [][] getTetramino(){return tetramino;}
    private void setSpeedFall(){
        switch (MapGamePanel.getNumberSpeed()){
            case 0:{
                speedFall=110;
                break;
            }
            case 1:{
                speedFall=100;
                break;
            }
            case 2:{
                speedFall=90;
                break;
            }
            case 3:{
                speedFall=80;
                break;
            }
            case 4:{
                speedFall=70;
                break;
            }
            case 5:{
                speedFall=60;
                break;
            }
            case 6:{
                speedFall=50;
                break;
            }
            case 7:{
                speedFall=40;
                break;
            }
            case 8:{
                speedFall=30;
                break;
            }
            case 9:{
                speedFall=20;
                break;
            }
            case 10:{
                speedFall=10;
                break;
            }
        }
    }

    void update(){

       tetramino();
        if (!ControlPanel.isPressedButtonPause && !isTouchBottomFloor()){
      fall();}
      if(!ControlPanel.isPressedButtonPause&&ControlPanel.isPressedButtonLeft && isTouchTheWall()) {
          left();
      }
      if(!ControlPanel.isPressedButtonPause&&ControlPanel.isPressedButtonRight && isTouchTheWall()) {
            right();
        }
       if (!ControlPanel.isPressedButtonPause&&ControlPanel.isPressedButtonDown && !isTouchBottomFloor()){
          down();
       }
       if (!ControlPanel.isPressedButtonPause&&ControlPanel.isPressedButtonRotate && isPossibleToTurn()){
           rotate();
       }
        if(positionY > MapGamePanel.HIGHT_MAP - sizeTetraminoHight()){
           up();
       }

    }
    void render (Graphics g){
        this.g=g;
        renderTetramino();
    }
    private void fall() {
         delaySpeedFall++;
        if(delaySpeedFall == speedFall){
            positionY++;
            delaySpeedFall = 0;
        }
    }
    private void up() {
            positionY--;
    }
    private void left () {
        speedX++;
        if(speedX == 3){
            if(ControlPanel.isPressedButtonSound) {
                MapGamePanel.move.stopPlay();
                MapGamePanel.move.sound();
                MapGamePanel.move.playSound();
            }
            positionX--;
            speedX = 0;
        }
    }
    private void right () {
        speedX++;
        if(speedX == 3){
            if(ControlPanel.isPressedButtonSound) {
                MapGamePanel.move.stopPlay();
                MapGamePanel.move.sound();
                MapGamePanel.move.playSound();
            }
            positionX++;
            speedX = 0;
        }
    }
    private void down () {
        delaySoundDown++;
        if(delaySoundDown==3){
            if(ControlPanel.isPressedButtonSound) {
                MapGamePanel.move.stopPlay();
                MapGamePanel.move.sound();
                MapGamePanel.move.playSound();
            }
            delaySoundDown = 0;
        }
            positionY++;
    }
    private void rotate(){
        speedRotate++;
        if(speedRotate==4){
            if(ControlPanel.isPressedButtonSound) {
                MapGamePanel.rotate.stopPlay();
                MapGamePanel.rotate.sound();
                MapGamePanel.rotate.playSound();
            }
        for (int i=0; i<SIZE_ARR/2; i++)
        {
            for (int j=i; j<SIZE_ARR-1-i; j++)
            {
                int  rotateTetramino         = tetramino[i][j];
                tetramino[i][j]         = tetramino[j][SIZE_ARR-1-i];
                tetramino[j][SIZE_ARR-1-i]     = tetramino[SIZE_ARR-1-i][SIZE_ARR-1-j];
                tetramino[SIZE_ARR-1-i][SIZE_ARR-1-j] = tetramino[SIZE_ARR-1-j][i];
                tetramino[SIZE_ARR-1-j][i]     = rotateTetramino;
            }
        }
            speedRotate=0;
        }
    }
    private boolean isPossibleToTurn(){
        int [][] tet=new int[SIZE_ARR][SIZE_ARR];
             for (int i = 0; i < tetramino.length; i++) {
                for (int j = 0; j < tetramino[i].length; j++) {
                    tet[i][j] = tetramino[i][j];
                }
             }
            for (int i=0; i<SIZE_ARR/2; i++)
            {
                for (int j=i; j<SIZE_ARR-1-i; j++)
                {
                    int  rotateTetramino         = tet[i][j];
                    tet[i][j]         = tet[j][SIZE_ARR-1-i];
                    tet[j][SIZE_ARR-1-i]     = tet[SIZE_ARR-1-i][SIZE_ARR-1-j];
                    tet[SIZE_ARR-1-i][SIZE_ARR-1-j] = tet[SIZE_ARR-1-j][i];
                    tet[SIZE_ARR-1-j][i]     = rotateTetramino;
                }
            }
        for (int i = 0; i <MapGamePanel.fieldGame.length ; i++) {
            for (int j = 0; j <MapGamePanel.fieldGame[i].length ; j++) {
                    for (int k = 0; k < tet.length; k++) {
                        for (int l = 0; l < tet[k].length; l++) {
                            if (tet[k][l] == 1) {
                                 if((positionX+l)<0 || positionX+l >MapGamePanel.WIDTH_MAP-1){return false;}
                            }
                        }
                    }
                if(MapGamePanel.fieldGame[i][j]==1) {
                    for (int k = 0; k < tet.length; k++) {
                        for (int l = 0; l < tet[k].length; l++) {
                            if (tet[k][l] == 1) {
                                if((positionY+k)==i&&(positionX+l)==j) { return false; }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    private void tetramino(){
            if (tetramino !=null){return;}
            tetramino = new int[SIZE_ARR][SIZE_ARR];
    }
    boolean isTouchBottomFloor(){
        for (int i = 0; i <MapGamePanel.fieldGame.length ; i++) {
            for (int j = 0; j <MapGamePanel.fieldGame[i].length ; j++) {
                if(MapGamePanel.fieldGame[i][j]==1) {
                    for (int k = 0; k < tetramino.length; k++) {
                        for (int l = 0; l < tetramino[k].length; l++) {
                            if (tetramino[k][l] == 1) {
                                if((positionY+k)+1==i&&positionX+l==j) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }

        for ( int i=0; i<tetramino.length; i++) {
            for (int j = 0; j < tetramino[i].length; j++) {
                if(tetramino [i][j] == 1){
                    if (positionY+i < MapGamePanel.HIGHT_MAP - sizeTetraminoHight()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean isTouchTheWall(){
        for (int i = 0; i <MapGamePanel.fieldGame.length ; i++) {
            for (int j = 0; j <MapGamePanel.fieldGame[i].length ; j++) {
                if(MapGamePanel.fieldGame[i][j]==1) {
                    for (int k = 0; k < tetramino.length; k++) {
                        for (int l = 0; l < tetramino[k].length; l++) {
                            if (tetramino[k][l] == 1) {
                                if(positionY+k==i&&(positionX+l)-1==j&&ControlPanel.isPressedButtonLeft||positionY+k==i&&(positionX+l)+1==j&&ControlPanel.isPressedButtonRight) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }

        for ( int i=0; i<tetramino.length; i++) {
            for (int j = 0; j < tetramino[i].length; j++) {
                if(tetramino [i][j] == 1){
                    if (positionX+j <= 0 && ControlPanel.isPressedButtonLeft ||positionX+j > MapGamePanel.WIDTH_MAP-2 && ControlPanel.isPressedButtonRight){return false;}
                }
            }
        }
        return true;
    }
    int sizeTetraminoHight(){
        int sizeTetraminoHight=0;
        for ( int i=0; i<tetramino.length; i++) {
            for (int j = 0; j < tetramino[i].length; j++) {
                if(tetramino [i][j] == 1){
                    sizeTetraminoHight = sizeTetraminoHight + 1;
                    break;
                }
            }
        }
        return sizeTetraminoHight;
    }
    private void renderTetramino (){
           for ( int i=0; i<tetramino.length; i++) {
               for (int j = 0; j < tetramino[i].length; j++) {
                   if(tetramino [i][j] == 1){
                       new Part( positionX + j, positionY + i, g,true);
                   }
               }
           }
       }

}
