package my.project.game;


import java.awt.*;

/**
 * Java. Swing game "Game Tetris 8 in 1"
 * @author Aleksey Malyshev
 * @version 1.0.1 dated February 11, 2018
 */

class TextAutor {

    private final static String TEXT_AUTOR_LINE_1 = "Game Tetris 8 in 1";
    private final static String TEXT_AUTOR_LINE_2 = "Версия V 1.0.1";
    private final static String TEXT_AUTOR_LINE_3 = "Дата 12.02,2018";
    private final static String TEXT_AUTOR_LINE_4 = "Автор проeкта: ";
    private final static String TEXT_AUTOR_LINE_5 = "Алексей Анатольевич Малышев";

    private final static String TEXT_AUTOR_LINE_6 = "О проекте.";
    private final static String TEXT_AUTOR_LINE_7 = "    Данный проект/игра посвящается моей";
    private final static String TEXT_AUTOR_LINE_8 = "семье и всем тем, кто поддерживал меня";
    private final static String TEXT_AUTOR_LINE_9 = "и верил на протяжении всего проекта.";

    private final static String TEXT_AUTOR_LINE_10 = "Условия использования и";
    private final static String TEXT_AUTOR_LINE_11 = "распостранения.";

    private final static String TEXT_AUTOR_LINE_12 = "    Игра распостраняется совершенно";
    private final static String TEXT_AUTOR_LINE_13 = "бесплатно и только автором, свободное";
    private final static String TEXT_AUTOR_LINE_14 = "распространение игры Game Tetris 8 in 1";
    private final static String TEXT_AUTOR_LINE_15 = "без согласия автора запрещены.";

    private final static String TEXT_AUTOR_LINE_16 = "    Копирование, распостранение, испо-";
    private final static String TEXT_AUTOR_LINE_17 = "зования кода, а также ссылки на код";
    private final static String TEXT_AUTOR_LINE_18 = "игры Game Tetris 8 in 1 без согласия";
    private final static String TEXT_AUTOR_LINE_19 = "автора запрещены.";

    private final static String TEXT_AUTOR_LINE_20 = "    По всем возникшим вопросам";
    private final static String TEXT_AUTOR_LINE_21 = "Вы можете связаться со мной написав на";
    private final static String TEXT_AUTOR_LINE_22 = "почту aleksey241980@mail.ru или же";
    private final static String TEXT_AUTOR_LINE_23 = "позвонить по телефону 8(926)587-78-77.";

    private final static String TEXT_AUTOR_LINE_24 = "Всем приятной игры!";
    private final static String TEXT_AUTOR_LINE_25 = "С уважением и наилучшими пожеланиями,";
    private final static String TEXT_AUTOR_LINE_26 = "автор проекта Алексей Малышев.";

    private final static String TEXT_AUTOR_LINE_27 = "         Все права принадлежат:";
    private final static String TEXT_AUTOR_LINE_28 = "      Алексею Анатольевичу Малышеву";
    private final static String TEXT_AUTOR_LINE_29 = "                       г.Москва 2018г.";

   static void textAutor (Graphics g){

        g.setColor(Style.BODY_COLOR);
        g.setFont(new Style().TextAutorH1);
        g.drawString( TEXT_AUTOR_LINE_1, CellSize.getSizeCell(), CellSize.getSizeCell() + g.getFontMetrics().getHeight());
        g.setFont(new Style().TextAutor);
        g.drawString( TEXT_AUTOR_LINE_2, CellSize.getSizeCell(), CellSize.getSizeCell() + g.getFontMetrics().getHeight()*2+4);
        g.drawString( TEXT_AUTOR_LINE_3, CellSize.getSizeCell(), CellSize.getSizeCell() + g.getFontMetrics().getHeight()*3+4);
        g.setFont(new Style().TextAutorH1);
        g.drawString( TEXT_AUTOR_LINE_4, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*4+4);
        g.setFont(new Style().TextAutor);
        g.drawString( TEXT_AUTOR_LINE_5, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*5+12);
        g.setFont(new Style().TextAutorH1);
        g.drawString( TEXT_AUTOR_LINE_6, CellSize.getSizeCell(), CellSize.getSizeCell() + g.getFontMetrics().getHeight()*7);
        g.setFont(new Style().TextAutor);
        g.drawString( TEXT_AUTOR_LINE_7, CellSize.getSizeCell(), CellSize.getSizeCell() + g.getFontMetrics().getHeight()*9);
        g.drawString( TEXT_AUTOR_LINE_8, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*10);
        g.drawString( TEXT_AUTOR_LINE_9, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*11);
        g.setFont(new Style().TextAutorH1);
        g.drawString( TEXT_AUTOR_LINE_10, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*11);
        g.drawString( TEXT_AUTOR_LINE_11, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*12);
        g.setFont(new Style().TextAutor);
        g.drawString( TEXT_AUTOR_LINE_12, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*15);
        g.drawString( TEXT_AUTOR_LINE_13, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*16);
        g.drawString( TEXT_AUTOR_LINE_14, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*17);
        g.drawString( TEXT_AUTOR_LINE_15, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*18);
        g.drawString( TEXT_AUTOR_LINE_16, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*19);
        g.drawString( TEXT_AUTOR_LINE_17, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*20);
        g.drawString( TEXT_AUTOR_LINE_18, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*21);
        g.drawString( TEXT_AUTOR_LINE_19, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*22);
        g.drawString( TEXT_AUTOR_LINE_20, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*23);
        g.drawString( TEXT_AUTOR_LINE_21, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*24);
        g.drawString( TEXT_AUTOR_LINE_22, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*25);
        g.drawString( TEXT_AUTOR_LINE_23, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*26);
        g.drawString( TEXT_AUTOR_LINE_25, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*27);
        g.drawString( TEXT_AUTOR_LINE_26, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*28);
        g.setFont(new Style().TextAutorH1);
        g.drawString( TEXT_AUTOR_LINE_24, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*25+4);
        g.drawString( TEXT_AUTOR_LINE_27, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*27);
        g.setFont(new Style().TextAutor);
        g.drawString( TEXT_AUTOR_LINE_28, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*32+6);
        g.drawString( TEXT_AUTOR_LINE_29, CellSize.getSizeCell(), CellSize.getSizeCell() +  g.getFontMetrics().getHeight()*34+4);
    }
}
