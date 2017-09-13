package gui;

import logic.Command;
import logic.CommandImage;

import javax.swing.*;
import java.awt.*;


/**
 * Created by andrey on 11.08.2017.
 */
public class MyFrame extends JFrame {
    TextPanel textPanel;

    public MyFrame() {
        init();

    }

    private void init() {
        Command cmd = new Command(this);
        setLayout(new BorderLayout());
        setTitle("File Manager");
        setBounds(100, 100, 800, 500);
        add(new ButtonPanel(cmd), BorderLayout.WEST);
        add(new MyMenu(cmd), BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


}
