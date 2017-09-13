package gui;

import javafx.scene.control.Separator;
import logic.Command;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by andrey on 11.08.2017.
 */
public class ButtonPanel extends JPanel {

    Command cmd = null;

    public ButtonPanel(Command cmd) {
        this.cmd = cmd;
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());
        setBackground(Color.CYAN);
        addMyButton(makeGbc(0, 0), "TextPanel", cmd.getTextPanel());
        addMyButton(makeGbc(0, 1), "PhotoPanel",cmd.getImagePanel());
        addMyButton(makeGbc(0, 2), "SoundPanel", cmd);
        addMyButton(makeGbc(0, 3), "Save", cmd);
        addMyButton(makeGbc(0, 4), "Open", cmd);
        addMyButton(makeGbc(0, 5), "Clear", cmd.clearPanel());
    }

    private GridBagConstraints makeGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = x;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.VERTICAL;
        return gbc;
    }

    private void addMyButton(GridBagConstraints gbc, String name, ActionListener command) {
        JButton button = new JButton(name);
        button.setPreferredSize(new Dimension(150, 50));
        button.setMinimumSize(new Dimension(100, 50));
        add(button, gbc);
        button.addActionListener(command);
    }
}
