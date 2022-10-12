package Homework;

import javax.swing.*;
import java.util.Random;

public class Com_game {

    ImageIcon default_icon = new ImageIcon("Images/default-icon.png");
    Shadow_logic game_logic = new Shadow_logic();
    Random com_move = new Random();

   public void ComTurn() {
       game_logic.fill_matrix();
       game_logic.execute_checks();
       if(!game_logic.check_full_matrix()) {
           if(game_logic.getMatrixCounter()<3) {
               casualMove();
           }
           else {
               int extracted_box_row=Game_field.getRowDoubleSymbolNumber(game_logic.x_icon);
               int winner_move_row=Game_field.getRowDoubleSymbolNumber(game_logic.o_icon);
               int extracted_box_column=Game_field.getColumnDoubleSymbolNumber(game_logic.x_icon);
               int winner_move_column = Game_field.getColumnDoubleSymbolNumber(game_logic.o_icon);
               int extracted_box_firstDiagonal = Game_field.getFirstDiagonalDoubleSymbolNumber(game_logic.x_icon);
               int winner_move_firstDiagonal = Game_field.getFirstDiagonalDoubleSymbolNumber(game_logic.o_icon);
               int extracted_box_secondDiagonal = Game_field.getSecondDiagonalDoubleSymbolNumber(game_logic.x_icon);
               int winner_move_secondDiagonal = Game_field.getSecondDiagonalDoubleSymbolNumber(game_logic.o_icon);
               if(winner_move_row!=3 || winner_move_column!=3 || winner_move_firstDiagonal!=3 || winner_move_secondDiagonal!=3) {
                   if(winner_move_row!=3) {
                   while (check_box_number(winner_move_row)) {
                       winner_move_row--;
                   }
                      executeMove(winner_move_row);
                   }
                   else if(winner_move_column!=3) {
                       while (check_box_number(winner_move_column)) {
                           winner_move_column+=3;
                       }
                       executeMove(winner_move_column);
                   }
                   else if(winner_move_firstDiagonal!=3) {
                       while (check_box_number(winner_move_firstDiagonal)) {
                           winner_move_firstDiagonal+=4;
                       }
                       executeMove(winner_move_firstDiagonal);
                   }
                   else {
                       while (check_box_number(winner_move_secondDiagonal)) {
                           winner_move_secondDiagonal+=2;
                       }
                       executeMove(winner_move_secondDiagonal);
                   }
               }
               else if(extracted_box_row!=3 || extracted_box_column!=3 || extracted_box_firstDiagonal!=3 || extracted_box_secondDiagonal!=3) {
                   if(extracted_box_row!=3) {
                       while (check_box_number(extracted_box_row)) {
                           extracted_box_row--;
                       }
                       executeMove(extracted_box_row);
                   }
                   else if(extracted_box_column!=3) {
                       while (check_box_number(extracted_box_column)) {
                           extracted_box_column+=3;
                       }
                       executeMove(extracted_box_column);
                   }
                   else if(extracted_box_firstDiagonal!=3) {
                       while (check_box_number(extracted_box_firstDiagonal)) {
                           extracted_box_firstDiagonal+=4;
                       }
                       executeMove(extracted_box_firstDiagonal);
                   }
                   else {
                       while (check_box_number(extracted_box_secondDiagonal)) {
                           extracted_box_secondDiagonal+=2;
                       }
                       executeMove(extracted_box_secondDiagonal);
                   }
               }
               else {
                   casualMove();
               }
           }
       }
   }
   public boolean check_box_number(int extracted_box) {
        JButton chosen_button=(JButton) Game_gui.getButton_panel().getComponent(extracted_box);
        return !chosen_button.getIcon().toString().equals(default_icon.toString());
   }
   private void executeMove(int extracted_box) {
       JButton chosen_button = (JButton) Game_gui.getButton_panel().getComponent(extracted_box);
       chosen_button.addActionListener(new Execute_Com_Moves());
       chosen_button.doClick();
   }
   private void casualMove() {
       int extracted_box = (int) Math.round(com_move.nextDouble() * 8);
       while (check_box_number(extracted_box)) {
           extracted_box = (int) Math.round(com_move.nextDouble() * 8);
       }
       executeMove(extracted_box);
   }
}