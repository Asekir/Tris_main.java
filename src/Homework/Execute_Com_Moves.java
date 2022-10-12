package Homework;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Execute_Com_Moves implements ActionListener {

    Shadow_logic game_logic = new Shadow_logic();
    ImageIcon o_icon = new ImageIcon("Images/o-icon.png");

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button =(JButton) actionEvent.getSource();
        if(Game_gui.getFrameTitle().equals("Com's turn")) {
            button.setIcon(o_icon);
            game_logic.fill_matrix();
            game_logic.execute_checks();
             if(!Game_gui.getFrameTitle().equals("Com Won")&&game_logic.getMatrixCounter()<9) {
                 Game_gui.setFrameTitle("Your turn");
             }
        }
    }
}
