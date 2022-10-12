package Homework;

import javax.swing.*;
import java.awt.*;

public class Shadow_logic {
    String outcome="";
    ImageIcon o_icon = new ImageIcon("Images/o-icon.png");
    ImageIcon x_icon = new ImageIcon("Images/x-icon.png");
    ImageIcon default_icon = new ImageIcon("Images/default-icon.png");
    Icon [][] game_field = Game_field.getGameField();


    public void fill_matrix() {
        int row_index =0;
        int column_index=0;
        for (Component button : Game_gui.getButton_panel().getComponents()) {
            if (column_index <= 2 && row_index <= 2) {
                game_field[row_index][column_index] = ((JButton) button).getIcon();
                column_index++;
                if (column_index == 3) {
                    row_index++;
                    column_index = 0;
                }
            }
        }
        //print_matrix();
    }
    /*private void print_matrix() {
        for (Icon[] icons : game_field) {
            for (Icon icon : icons) {
                if(icon.toString().equals(x_icon.toString())) {
                    System.out.print("x ");
                }
                else if(icon.toString().equals(o_icon.toString())) {
                    System.out.print("o ");
                }
                else {
                    System.out.print("N ");
                }
            }
            System.out.println();
        }
    }*/
    private int count_matrix_elements() {
        int element_counter=0;
        for (Icon[] icons : game_field) {
            for (Icon icon : icons) {
                if (!icon.toString().equals(default_icon.toString())) {
                    element_counter++;
                }
            }
        }
        return element_counter;
    }
    private void check_rows() {
        if(count_matrix_elements()>4) {
            for (Icon[] icons : game_field) {
                if (icons[0].toString().equals(icons[1].toString())) {
                    if (icons[0].toString().equals(icons[2].toString())) {
                        if (icons[0].toString().equals(x_icon.toString())) {
                            outcome="You Won";
                            Game_gui.setFrameTitle(outcome);
                            //System.out.println("You Won on Row");
                        } else if (icons[0].toString().equals(o_icon.toString())) {
                            outcome="Com Won";
                            Game_gui.setFrameTitle(outcome);
                            //System.out.println("Com Won on Row");
                        }
                    }
                }
            }
        }
        //return outcome;
    }
    private void check_columns() {
        if(count_matrix_elements()>4) {
            for(int l=0;l<game_field[0].length;l++) {
                if(game_field[0][l].toString().equals(game_field[1][l].toString())) {
                    if(game_field[0][l].toString().equals(game_field[2][l].toString())) {
                        if(game_field[0][l].toString().equals(x_icon.toString())) {
                            outcome="You Won";
                            Game_gui.setFrameTitle(outcome);
                            //System.out.println("You Won on Column");
                        } else if(game_field[0][l].toString().equals(o_icon.toString())) {
                            outcome="Com Won";
                            Game_gui.setFrameTitle(outcome);
                            //System.out.println("Com Won on Column");
                        }
                    }
                }
            }
        }
        //return outcome;
    }
    private void check_diagonals() {
        if(count_matrix_elements()>4) {
            Icon [] firstDiagonal = Game_field.getFirstDiagonal();
            Icon [] secondDiagonal = Game_field.getSecondDiagonal();
            if(firstDiagonal[0].toString().equals(firstDiagonal[1].toString())&&firstDiagonal[1].toString().equals(firstDiagonal[2].toString())&&!firstDiagonal[0].toString().equals(default_icon.toString())) {
                if(firstDiagonal[0].toString().equals(x_icon.toString())) {
                    outcome="You Won";
                }
                else {
                    outcome="Com Won";
                }
                Game_gui.setFrameTitle(outcome);
            }
            else if(secondDiagonal[0].toString().equals(secondDiagonal[1].toString())&&secondDiagonal[1].toString().equals(secondDiagonal[2].toString())&&!secondDiagonal[0].toString().equals(default_icon.toString())) {
                if(secondDiagonal[0].toString().equals(x_icon.toString())) {
                    outcome="You Won";
                }
                else {
                    outcome="Com Won";
                }
                Game_gui.setFrameTitle(outcome);
            }
        }
        //return outcome;
    }
    private void check_draw() {
        if(outcome.equals("")&&count_matrix_elements()==9) {
            //System.out.println("rows: "+check_rows()+"columns: "+check_columns()+"diagonals: "+check_diagonals()+"elements: "+count_matrix_elements());
            Game_gui.setFrameTitle("Draw");
        }
    }
    public boolean check_full_matrix() {
        for(Icon [] icons : game_field) {
            for(Icon icon : icons) {
                if(icon.toString().equals(default_icon.toString())) {
                    return false;
                }
            }
        }
        return true;
    }
    public void execute_checks() {
        count_matrix_elements();
        check_rows();
        check_columns();
        check_diagonals();
        check_draw();
    }
    public int getMatrixCounter() {
        return count_matrix_elements();
    }

}
