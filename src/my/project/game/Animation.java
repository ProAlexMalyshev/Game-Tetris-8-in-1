package my.project.game;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

 class Animation {


    private static final int SHOT_GO_1 [][] = {{0,0,0,0,0,1,0,0,0},
                                               {0,0,0,0,1,1,0,0,0},
                                               {0,0,0,0,0,1,0,0,0},
                                               {0,0,0,0,0,1,0,0,0},
                                               {0,0,0,0,1,1,1,0,0}};

    private static final int SHOT_GO_2 [][] = {{0,0,0,0,1,1,1,0,0},
                                               {0,0,0,0,0,0,1,0,0},
                                               {0,0,0,0,1,1,1,0,0},
                                               {0,0,0,0,1,0,0,0,0},
                                               {0,0,0,0,1,1,1,0,0}};

    private static final int SHOT_GO_3 [][] = {{0,0,0,0,1,1,1,0,0},
                                               {0,0,0,0,0,0,1,0,0},
                                               {0,0,0,0,0,1,1,0,0},
                                               {0,0,0,0,0,0,1,0,0},
                                               {0,0,0,0,1,1,1,0,0}};

    private static final int SHOT_GO [][] = {{0,1,1,1,0,0,1,1,0},
                                             {1,0,0,0,0,1,0,0,1},
                                             {1,0,1,1,0,1,0,0,1},
                                             {1,0,0,1,0,1,0,0,1},
                                             {0,1,1,0,0,0,1,1,0}};

    private static final int ANIMATION_GO [][][] = {SHOT_GO_3, SHOT_GO_2, SHOT_GO_1, SHOT_GO};



    private static final int G1 [][] = {{0,1,1,1,0,0,1,0},
                                        {1,0,0,0,0,1,1,0},
                                        {1,0,1,1,0,0,1,0},
                                        {1,0,0,1,0,0,1,0},
                                        {0,1,1,0,0,1,1,1}};

    private static final int G2 [][] = {{0,1,1,1,0,1,1,1},
                                        {1,0,0,0,0,0,0,1},
                                        {1,0,1,1,0,1,1,1},
                                        {1,0,0,1,0,1,0,0},
                                        {0,1,1,0,0,1,1,1}};

    private static final int G3 [][] = {{0,1,1,1,0,1,1,1},
                                        {1,0,0,0,0,0,0,1},
                                        {1,0,1,1,0,1,1,1},
                                        {1,0,0,1,0,0,0,1},
                                        {0,1,1,0,0,1,1,1}};

    private static final int G4 [][] = {{0,1,1,1,0,1,0,1},
                                        {1,0,0,0,0,1,0,1},
                                        {1,0,1,1,0,1,1,1},
                                        {1,0,0,1,0,0,0,1},
                                        {0,1,1,0,0,0,0,1}};

    private static final int G5 [][] = {{0,1,1,1,0,1,1,1},
                                        {1,0,0,0,0,1,0,0},
                                        {1,0,1,1,0,1,1,1},
                                        {1,0,0,1,0,0,0,1},
                                        {0,1,1,0,0,1,1,1}};

    private static final int G6 [][] = {{0,1,1,1,0,1,1,1},
                                        {1,0,0,0,0,1,0,0},
                                        {1,0,1,1,0,1,1,1},
                                        {1,0,0,1,0,1,0,1},
                                        {0,1,1,0,0,1,1,1}};

    private static final int G7 [][] = {{0,1,1,1,0,1,1,1},
                                        {1,0,0,0,0,0,0,1},
                                        {1,0,1,1,0,0,1,0},
                                        {1,0,0,1,0,1,0,0},
                                        {0,1,1,0,0,1,0,0}};

    private static final int G8 [][] = {{0,1,1,1,0,1,1,1},
                                        {1,0,0,0,0,1,0,1},
                                        {1,0,1,1,0,1,1,1},
                                        {1,0,0,1,0,1,0,1},
                                        {0,1,1,0,0,1,1,1}};

    private static final int ANIMATION_SELECTION_GAME [][][] = {G1, G2, G3, G4, G5, G6, G7, G8};



   private static final int DEMO_GAME_ONE_SHOT_ONE [][] = {{0,0,0,0,0,0,0,0,0,0},
                                                           {0,0,0,0,0,0,0,0,0,0},
                                                           {0,0,0,0,0,0,0,0,0,0},
                                                           {0,0,0,0,0,0,0,0,0,0},
                                                           {0,0,0,0,1,0,0,0,0,0},
                                                           {0,1,0,1,1,1,0,1,0,0},
                                                           {1,1,1,1,1,1,0,1,1,1}};

    private static final int DEMO_GAME_ONE_SHOT_TWO [][] = {{0,0,0,1,0,0,0,0,0,0},
                                                            {0,0,1,1,0,0,0,0,0,0},
                                                            {0,0,1,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,1,0,0,0,0,0},
                                                            {0,1,0,1,1,1,0,1,0,0},
                                                            {1,1,1,1,1,1,0,1,1,1}};

   private static final int DEMO_GAME_ONE_SHOT_THREE [][] = {{0,0,0,0,0,0,0,0,0,0},
                                                             {0,0,0,0,0,0,0,0,0,0},
                                                             {0,0,0,0,0,0,0,0,0,0},
                                                             {0,0,0,1,0,0,0,0,0,0},
                                                             {0,0,1,1,1,0,0,0,0,0},
                                                             {0,1,1,1,1,1,0,1,0,0},
                                                             {1,1,1,1,1,1,0,1,1,1}};

    private static final int DEMO_GAME_ONE_SHOT_FOUR [][] = {{0,0,0,0,0,0,1,1,0,0},
                                                             {0,0,0,0,0,0,1,0,0,0},
                                                             {0,0,0,0,0,0,1,0,0,0},
                                                             {0,0,0,1,0,0,0,0,0,0},
                                                             {0,0,1,1,1,0,0,0,0,0},
                                                             {0,1,1,1,1,1,0,1,0,0},
                                                             {1,1,1,1,1,1,0,1,1,1}};

    private static final int DEMO_GAME_ONE_SHOT_FIVE [][] = {{0,0,0,0,0,0,0,0,0,0},
                                                             {0,0,0,0,0,0,0,0,0,0},
                                                             {0,0,0,0,0,0,0,0,0,0},
                                                             {0,0,0,1,0,0,0,0,0,0},
                                                             {0,0,1,1,1,0,1,1,0,0},
                                                             {0,1,1,1,1,1,1,1,0,0},
                                                             {1,1,1,1,1,1,1,1,1,1}};

    private static final int DEMO_GAME_ONE_SHOT_SIX [][] = {{0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,1,0,0,0,0,0,0},
                                                            {0,0,1,1,1,0,1,1,0,0},
                                                            {0,1,1,1,1,1,1,1,0,0}};

    private static final int ANIMATION_DEMO_GAME_ONE [][][] = {DEMO_GAME_ONE_SHOT_ONE, DEMO_GAME_ONE_SHOT_TWO,
            DEMO_GAME_ONE_SHOT_THREE, DEMO_GAME_ONE_SHOT_FOUR, DEMO_GAME_ONE_SHOT_FIVE, DEMO_GAME_ONE_SHOT_SIX};



    private static final int DEMO_GAME_TWO_SHOT_ONE [][] = {{0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,1,0,0,0,0,0,0,0},
                                                            {0,1,1,1,0,1,1,0,0,0},
                                                            {1,1,1,1,1,1,1,1,1,0}};

    private static final int DEMO_GAME_TWO_SHOT_TWO [][] = {{0,0,0,0,0,1,0,0,0,0},
                                                            {0,0,0,1,1,1,0,0,0,0},
                                                            {0,0,0,0,1,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,1,0,0,0,0,0,0,0},
                                                            {0,1,1,1,0,1,1,0,0,0},
                                                            {1,1,1,1,1,1,1,1,1,0}};

    private static final int DEMO_GAME_TWO_SHOT_THREE [][] = {{0,0,0,0,0,0,0,0,0,0},
                                                              {0,0,0,0,0,0,0,0,0,0},
                                                              {0,0,0,0,0,0,0,0,0,0},
                                                              {0,0,0,0,0,1,0,0,0,0},
                                                              {0,0,1,1,1,1,0,0,0,0},
                                                              {0,1,1,1,1,1,1,0,0,0},
                                                              {1,1,1,1,1,1,1,1,1,0}};

    private static final int DEMO_GAME_TWO_SHOT_FOUR [][] = {{0,0,0,0,0,0,0,0,0,1},
                                                             {0,0,0,0,0,0,0,1,1,1},
                                                             {0,0,0,0,0,0,0,0,0,1},
                                                             {0,0,0,0,0,1,0,0,0,0},
                                                             {0,0,1,1,1,1,0,0,0,0},
                                                             {0,1,1,1,1,1,1,0,0,0},
                                                             {1,1,1,1,1,1,1,1,1,0}};

    private static final int DEMO_GAME_TWO_SHOT_FIVE [][] = {{0,0,0,0,0,0,0,0,0,0},
                                                             {0,0,0,0,0,0,0,0,0,0},
                                                             {0,0,0,0,0,0,0,0,0,0},
                                                             {0,0,0,0,0,1,0,0,0,0},
                                                             {0,0,1,1,1,1,0,0,0,1},
                                                             {0,1,1,1,1,1,1,1,1,1},
                                                             {1,1,1,1,1,1,1,1,1,1}};

    private static final int DEMO_GAME_TWO_SHOT_SIX [][] = {{0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,0,0,0,0,0},
                                                            {0,0,0,0,0,1,0,0,0,0},
                                                            {0,0,1,1,1,1,0,0,0,1},
                                                            {0,1,1,1,1,1,1,1,1,1}};

    private static final int ANIMATION_DEMO_GAME_TWO [][][] = {DEMO_GAME_TWO_SHOT_ONE, DEMO_GAME_TWO_SHOT_TWO,
            DEMO_GAME_TWO_SHOT_THREE, DEMO_GAME_TWO_SHOT_FOUR, DEMO_GAME_TWO_SHOT_FIVE, DEMO_GAME_TWO_SHOT_SIX};



    private final static int [][] ANIMATION_GAME_OVER = {
            {0,0,1,1,1,1,0,0,1,1,1,0,0,1,0,0,0,1,0,0,1,1,1,1,0,0,0,0,1,1,1,0,0,1,0,0,0,1,0,0,1,1,1,1,0,1,1,1,1,0,0},
            {0,1,0,0,0,0,0,1,0,0,0,1,0,1,1,0,1,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,1,0},
            {0,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,1,0,0},
            {0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0},
            {0,0,1,1,1,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,1,0,0,0,1,0}};

    private static final int SIZE_ANIMATION_RESET_GAME_FIELD_X = 10;
    private static final int SIZE_ANIMATION_RESET_GAME_FIELD_Y = 20;
    private static final int SIZE_SHOT_ANIMATION_DEMO_GAME_ONE_X = 10;
    private static final int SIZE_SHOT_ANIMATION_DEMO_GAME_ONE_Y = 7;
    private static final int SIZE_SHOT_ANIMATION_DEMO_GAME_TWO_X = 10;
    private static final int SIZE_SHOT_ANIMATION_DEMO_GAME_TWO_Y = 7;
    private static final int SIZE_SHOT_ANIMATION_SELECTION_GAME_X = 8;
    private static final int SIZE_SHOT_ANIMATION_SELECTION_GAME_Y = 5;
    private static final int SIZE_SHOT_ANIMATION_GO_X = 9;
    private static final int SIZE_SHOT_ANIMATION_GO_Y = 5;
    static final int POSITION_RESET_FIELD_X = 0;
    static final int POSITION_RESET_FIELD_Y = 0;
    static final int POSITION_SHOT_X = 0;
    static final int POSITION_SHOT_Y = 13;
    static final int POSITION_SHOT_DEMO_TWO_X = 0;
    static final int POSITION_SHOT_DEMO_TWO_Y = 13;
    static final int POSITION_SHOT_SELECTION_GAME_X = 1;
    static final int POSITION_SHOT_SELECTION_GAME_Y = 6;
    static final int POSITION_SHOT_ONE_GO_X = 0;
    static final int POSITION_SHOT_ONE_GO_Y = 7;
    private int positionShotGameOverX = 15 - MapGamePanel.countShotAnimationGameOver;
    static final int POSITION_SHOT_GAME_OVER_Y = 7;
    private int[][] shotAnimationDemoGameOne;
    private int[][] shotAnimationDemoGameTwo;
    private int[][] shotAnimationSelectionGame;
    private int[][] shotAnimationGo;
    private int[][] animationResetGame;


    Animation(){
        animationDemoGameOne();
        animationSelectionGame();
        animationGo();
        animationDemoGameTwo();
        animationResetGame();
    }

    int getPositionShotGameOverX(){return positionShotGameOverX;}
    int[][] getShotAnimationDemoGameOne() {
        return shotAnimationDemoGameOne;
    }
    int[][] getShotAnimationSelectionGame(){
        return shotAnimationSelectionGame;
    }
    int[][] getShotAnimationGo(){
        return shotAnimationGo;
    }
    int[][] getShotAnimationDemoGameTwo(){
        return shotAnimationDemoGameTwo;
    }
    int[][] getAnimationResetField(){return animationResetGame;}
    int[][] getAnimationGameOver(){return ANIMATION_GAME_OVER;}

    private void animationResetGame(){
        if(animationResetGame ==null){
          animationResetGame = new int[SIZE_ANIMATION_RESET_GAME_FIELD_Y][SIZE_ANIMATION_RESET_GAME_FIELD_X];
            for (int i = 0; i <MapGamePanel.numberShotAnimationResetField; i++) {
                for (int j = 0; j < SIZE_ANIMATION_RESET_GAME_FIELD_X; j++) {
                    animationResetGame[i][j] =1;
                }
            }
        }
    }

    private void animationDemoGameOne(){
        if(shotAnimationDemoGameOne == null){
            shotAnimationDemoGameOne = new int[SIZE_SHOT_ANIMATION_DEMO_GAME_ONE_Y][SIZE_SHOT_ANIMATION_DEMO_GAME_ONE_X];

            for (int i = 0; i < SIZE_SHOT_ANIMATION_DEMO_GAME_ONE_Y; i++) {
                for (int j = 0; j < SIZE_SHOT_ANIMATION_DEMO_GAME_ONE_X; j++) {
                    shotAnimationDemoGameOne[i][j] = ANIMATION_DEMO_GAME_ONE[MapGamePanel.numberShotAnimationDemoGame][i][j];
                }

            }

        }

    }

    private void animationDemoGameTwo(){

        if(shotAnimationDemoGameTwo == null){
            shotAnimationDemoGameTwo = new int[SIZE_SHOT_ANIMATION_DEMO_GAME_TWO_Y][SIZE_SHOT_ANIMATION_DEMO_GAME_TWO_X];

            for (int i = 0; i < SIZE_SHOT_ANIMATION_DEMO_GAME_TWO_Y; i++) {
                for (int j = 0; j < SIZE_SHOT_ANIMATION_DEMO_GAME_TWO_X; j++) {
                    shotAnimationDemoGameTwo[i][j] = ANIMATION_DEMO_GAME_TWO[MapGamePanel.numberShotAnimationDemoGame][i][j];
                }

            }

        }

    }

    private void animationSelectionGame(){
        if(shotAnimationSelectionGame ==null){
            shotAnimationSelectionGame = new int[SIZE_SHOT_ANIMATION_SELECTION_GAME_Y][SIZE_SHOT_ANIMATION_SELECTION_GAME_X];

            for (int i = 0; i < SIZE_SHOT_ANIMATION_SELECTION_GAME_Y; i++) {
                for (int j = 0; j < SIZE_SHOT_ANIMATION_SELECTION_GAME_X; j++) {
                    shotAnimationSelectionGame[i][j] = ANIMATION_SELECTION_GAME[MapGamePanel.getNumberGame()][i][j];
                }

            }

        }

    }

    private void animationGo(){
        if(shotAnimationGo ==null){
            shotAnimationGo = new int[SIZE_SHOT_ANIMATION_GO_Y][SIZE_SHOT_ANIMATION_GO_X];

            for (int i = 0; i < SIZE_SHOT_ANIMATION_GO_Y; i++) {
                for (int j = 0; j < SIZE_SHOT_ANIMATION_GO_X; j++) {
                    shotAnimationGo[i][j] = ANIMATION_GO [MapGamePanel.numberShotAnimationGo][i][j];
                }

            }

        }

    }

}
