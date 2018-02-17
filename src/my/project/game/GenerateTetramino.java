package my.project.game;

import java.util.Random;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */
    class GenerateTetramino {
    private static final int [][] TETRAMINO_I = {{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_O = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_L = {{0,0,0,0},{0,0,1,0},{1,1,1,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_J = {{0,0,0,0},{1,1,1,0},{0,0,1,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_T = {{0,0,0,0},{1,1,1,0},{0,1,0,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_Z = {{0,0,0,0},{1,1,0,0},{0,1,1,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_S = {{0,0,0,0},{0,1,1,0},{1,1,0,0},{0,0,0,0}};

    private static final int [][] TETRAMINO_DOT = {{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_DOT2 = {{0,0,0,0},{0,1,1,0},{0,0,0,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_L2 = {{0,0,0,0},{1,0,0,0},{1,1,1,1},{0,0,0,0}};
    private static final int [][] TETRAMINO_L3 = {{0,0,0,0},{0,0,0,1},{1,1,1,1},{0,0,0,0}};
    private static final int [][] TETRAMINO_T2 = {{0,0,0,0},{0,0,0,1},{0,1,1,1},{0,0,0,1}};
    private static final int [][] TETRAMINO_P = {{0,0,1,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_P2 = {{0,1,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_V = {{0,0,0,0},{0,1,1,1},{0,1,0,0},{0,1,0,0}};
    private static final int [][] TETRAMINO_V2 = {{0,0,0,0},{0,1,1,0},{0,1,0,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_Z2 = {{0,0,0,0},{1,1,0,0},{0,1,0,0},{0,1,1,0}};
    private static final int [][] TETRAMINO_Z3 = {{0,0,0,0},{0,0,1,1},{0,0,1,0},{0,1,1,0}};
    private static final int [][] TETRAMINO_X = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_U = {{0,0,0,0},{0,1,1,1},{0,1,0,1},{0,0,0,0}};
    private static final int [][] TETRAMINO_W = {{0,0,1,0},{0,1,1,0},{1,1,0,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_F = {{0,1,0,0},{0,1,1,1},{0,0,1,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_F2 = {{0,0,1,0},{1,1,1,0},{0,1,0,0},{0,0,0,0}};
    private static final int [][] TETRAMINO_Y = {{0,0,0,0},{0,0,1,0},{1,1,1,1},{0,0,0,0}};
    private static final int [][] TETRAMINO_Y2 = {{0,0,0,0},{0,1,0,0},{1,1,1,1},{0,0,0,0}};
    private static final int [][] TETRAMINO_N = {{0,0,0,0},{1,1,0,0},{0,1,1,1},{0,0,0,0}};
    private static final int [][] TETRAMINO_N2 = {{0,0,0,0},{0,0,1,1},{1,1,1,0},{0,0,0,0}};

    private static final int[][][] TETRAMINOS = {TETRAMINO_I, TETRAMINO_O, TETRAMINO_L,  TETRAMINO_J, TETRAMINO_S, TETRAMINO_T,
           TETRAMINO_Z, TETRAMINO_DOT, TETRAMINO_DOT2, TETRAMINO_L2, TETRAMINO_L3, TETRAMINO_T2,
   TETRAMINO_P, TETRAMINO_P2, TETRAMINO_V, TETRAMINO_V2, TETRAMINO_Z2, TETRAMINO_Z3, TETRAMINO_X, TETRAMINO_U, TETRAMINO_W,
   TETRAMINO_F, TETRAMINO_F2, TETRAMINO_Y, TETRAMINO_Y2, TETRAMINO_N, TETRAMINO_N2};

    private Random random = new Random();
    private static int nextGame=7;
    private int tetraminoType = random.nextInt(nextGame);
    private int [][] tetramino;
    private static final int SIZE_ARR = 4;

    GenerateTetramino(){
        tetramino();
    }

    int [][] getTetramino(){return tetramino;}

    static void setNextGame(int setNextGame){
        if(setNextGame==0){nextGame=7;}
        if(setNextGame==1){nextGame=4;}
        if(setNextGame==2){nextGame=12;}
        if(setNextGame==3){nextGame=16;}
        if(setNextGame==4){nextGame=19;}
        if(setNextGame==5){nextGame=21;}
        if(setNextGame==6){nextGame=24;}
        if(setNextGame==7){nextGame=27;}
    }

    private void tetramino (){
        if (tetramino !=null){return;}
        tetramino = new int[SIZE_ARR][SIZE_ARR];
        for ( int i=0; i<TETRAMINOS[tetraminoType].length; i++) {
            for (int j = 0; j < TETRAMINOS[tetraminoType].length; j++) {
                tetramino[i][j]= TETRAMINOS [tetraminoType] [i][j];
            }
        }
    }

}
