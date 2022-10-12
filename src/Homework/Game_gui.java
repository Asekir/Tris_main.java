package Homework;
import javax.swing.*;
import java.awt.*;

public class Game_gui {
    private static final JFrame game_frame = new JFrame("TRIS");
    private static final JPanel main_game_panel = new JPanel(new BorderLayout());
    private static final JPanel north_panel = new JPanel();
    private static final JPanel button_panel = new JPanel(new GridLayout(3,3));
    private static final JButton play_button=new JButton("PLAY");
    private static final JButton exit_button=new JButton("EXIT");
    private static final JButton b1=new JButton();
    private static final JButton b2=new JButton();
    private static final JButton b3=new JButton();
    private static final JButton b4=new JButton();
    private static final JButton b5=new JButton();
    private static final JButton b6=new JButton();
    private static final JButton b7=new JButton();
    private static final JButton b8=new JButton();
    private static final JButton b9=new JButton();

    public void Display() {
        game_frame.add(main_game_panel);
        main_game_panel.add(north_panel,BorderLayout.NORTH);
        main_game_panel.add(button_panel);
        game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_frame.setResizable(false);
        north_panel.setBackground(new Color(255,255,0));
        play_button.setBackground(new Color(0,255,0));
        exit_button.setBackground(new Color(255,0,0));
        north_panel.add(play_button);
        north_panel.add(exit_button);
        button_panel.add(b1);
        button_panel.add(b2);
        button_panel.add(b3);
        button_panel.add(b4);
        button_panel.add(b5);
        button_panel.add(b6);
        button_panel.add(b7);
        button_panel.add(b8);
        button_panel.add(b9);
        play_button.addMouseListener(new Start_game());
        exit_button.addMouseListener(new Exit_game());
        for (Component button:button_panel.getComponents()
             ) {
                button.setBackground(new Color(255,255,0));
                ((JButton) button).addActionListener(new Symbol_manage());
        }
        game_frame.setPreferredSize(new Dimension(450,450));
        game_frame.pack();
        game_frame.setVisible(true);
    }
    public static String getFrameTitle() {
        return game_frame.getTitle();
    }
    public static void setFrameTitle(String new_title) {
        game_frame.setTitle(new_title);
    }
    public static JPanel getButton_panel() {
        return button_panel;
    }
}