package Homework;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Symbol_manage implements ActionListener {

    ImageIcon x_icon = new ImageIcon("Images/x-icon.png");
    ImageIcon default_icon = new ImageIcon("Images/default-icon.png");
    Com_game com_game = new Com_game();
    Shadow_logic game_logic = new Shadow_logic();

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            JButton button= (JButton)actionEvent.getSource();
            if (button.getIcon().toString().equals(default_icon.toString())) {
                if (Game_gui.getFrameTitle().equals("Your turn")) {
                    button.setIcon(x_icon);
                    game_logic.fill_matrix();
                    game_logic.execute_checks();
                    if(!Game_gui.getFrameTitle().equals("You Won")) {
                        Game_gui.setFrameTitle("Com's turn");
                        com_game.ComTurn();
                    }
                }
            }
        } catch (NullPointerException npe ) {
            Game_gui.setFrameTitle("Press PLAY to game");
        }
    }
}
