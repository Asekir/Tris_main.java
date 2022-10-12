package Homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Start_game implements MouseListener {

    Random casual_extraction = new Random();
    ImageIcon default_icon = new ImageIcon("Images/default-icon.png");
    Com_game com_game = new Com_game();
    Shadow_logic game_logic = new Shadow_logic();
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        double extracted = casual_extraction.nextDouble();
        for (Component button:Game_gui.getButton_panel().getComponents()
             ) {
                ((JButton) button).setIcon(default_icon);
        }
        game_logic.fill_matrix();
        if(extracted<=0.5) {
            Game_gui.setFrameTitle("Your turn");
        }
        else {
            Game_gui.setFrameTitle("Com's turn");
            com_game.ComTurn();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
