package Homework;

import javax.swing.*;

public class Game_field {
    private static final Icon[][] game_field = new Icon[3][3];

    public static Icon[][] getGameField() { return game_field;}

    public static Icon[] getFirstDiagonal() {
        Icon [] firstDiagonal = new Icon[3];
        for(int i=0; i<game_field.length;i++) {
            for(int j=0; j<game_field[i].length;j++) {
                if(i==j) {
                    firstDiagonal[i]=game_field[i][j];
                }
            }
        }
        return firstDiagonal;
    }

    public static Icon[] getSecondDiagonal() {
        Icon [] secondDiagonal = new Icon[3];
        for(int i=0; i<game_field.length;i++) {
            for(int j=0; j<game_field[i].length;j++) {
                if(i+j==2) {
                    secondDiagonal[i]=game_field[i][j];
                }
            }
        }
        return secondDiagonal;
    }
    public static int getRowDoubleSymbolNumber(Icon chosen_icon) {
        int row_counter=0;
        int counter_chosenIcon=0;
        int counter_defaultIcon=0;
        Shadow_logic game_logic = new Shadow_logic();
        for(Icon [] row : game_field) {
            for(Icon box : row) {
                if(box.toString().equals(chosen_icon.toString())) {
                    counter_chosenIcon++;
                }
                else if(box.toString().equals(game_logic.default_icon.toString()))
                {
                    counter_defaultIcon++;
                }
            }
            if(counter_chosenIcon==2 && counter_defaultIcon==1) {
                row_counter++;
                return 3*row_counter-1;
            }
            row_counter++;
            counter_defaultIcon=0;
            counter_chosenIcon=0;
        }
        return row_counter;
    }
    public static int getColumnDoubleSymbolNumber(Icon chosen_icon) {
        int column_counter=0;
        int counter_chosenIcon=0;
        int counter_defaultIcon=0;
        Shadow_logic game_logic = new Shadow_logic();
        for(int j=0; j<game_field[0].length;j++) {
            for (Icon[] box : game_field) {
                if (box[j].toString().equals(chosen_icon.toString())) {
                    counter_chosenIcon++;
                } else if (box[j].toString().equals(game_logic.default_icon.toString())) {
                    counter_defaultIcon++;
                }
            }
            if(counter_chosenIcon==2 && counter_defaultIcon==1) {
                return column_counter;
            }
            column_counter++;
            counter_defaultIcon=0;
            counter_chosenIcon=0;
        }
        return column_counter;
    }
    public static int getFirstDiagonalDoubleSymbolNumber(Icon chosen_icon) {
        Icon [] firstDiagonal = getFirstDiagonal();
        Shadow_logic game_logic = new Shadow_logic();
        int counter_chosenIcon=0;
        int counter_defaultIcon=0;
        for (Icon box : firstDiagonal) {
            if (box.toString().equals(chosen_icon.toString())) {
                counter_chosenIcon++;
            } else if (box.toString().equals(game_logic.default_icon.toString())) {
                counter_defaultIcon++;
            }
        }
        if(counter_chosenIcon==2 && counter_defaultIcon==1) {
            return 0;
        }
        else {
            return 3;
        }
    }
    public static int getSecondDiagonalDoubleSymbolNumber(Icon chosen_icon) {
        Icon [] secondDiagonal = getSecondDiagonal();
        Shadow_logic game_logic = new Shadow_logic();
        int counter_chosenIcon=0;
        int counter_defaultIcon=0;
        for (Icon box : secondDiagonal) {
            if (box.toString().equals(chosen_icon.toString())) {
                counter_chosenIcon++;
            } else if (box.toString().equals(game_logic.default_icon.toString())) {
                counter_defaultIcon++;
            }
        }
        if(counter_chosenIcon==2 && counter_defaultIcon==1) {
            return 2;
        }
        else {
            return 3;
        }
    }

}
