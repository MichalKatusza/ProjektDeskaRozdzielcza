package ui;

import javax.swing.*;

public class Board extends JFrame {

    public static final int HEIGHT = 500;
    public static final int WIDTH = 500;
    private JPanel mainPanel;
    private JButton jButton;
    private JTextArea jTextArea;

    public Board(){
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
    }
}
