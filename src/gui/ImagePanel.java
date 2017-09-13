package gui;

import logic.CommandImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by andrey on 11.08.2017.
 */
public class ImagePanel extends JPanel {

    private JPanel display = null;
    private JPanel buttonPanel = null;
    private CommandImage commandImage = null;

    public ImagePanel(CommandImage cmdImg) {
        this.commandImage = cmdImg;
        init();

    }

    public JPanel getDisplay() {
        return display;
    }

    public void setDisplay(JPanel display) {
        this.display = display;
    }

    private void init() {
        setLayout(new GridBagLayout());
        setBackground(Color.BLUE);
        display = new JPanel();
        display.setBorder(BorderFactory.createEtchedBorder());
        display.setPreferredSize(new Dimension(600, 400));
        display.setMinimumSize(new Dimension(600, 400));
        display.setMaximumSize(new Dimension(600,400));
        add(display, makeGbc(0, 0,3));
        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEtchedBorder());
        buttonPanel.setPreferredSize(new Dimension(600, 100));
        buttonPanel.setMinimumSize(new Dimension(500, 50));
        buttonPanel.add(addMyButton("Camera", commandImage));
        buttonPanel.add(addMyButton("Photo",commandImage));
        add(buttonPanel, makeGbc(0, 1,2));

    }

    private GridBagConstraints makeGbc(int x, int y, int flag) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = x;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = (x == 0) ? GridBagConstraints.LINE_START : GridBagConstraints.LINE_END;
        if (flag==3){
        gbc.fill = GridBagConstraints.VERTICAL;
        }
        if (flag==2){
            gbc.fill = GridBagConstraints.HORIZONTAL;
        }
        return gbc;
    }

    private JButton addMyButton(String name, ActionListener command) {
        JButton button = new JButton(name);
        button.setPreferredSize(new Dimension(150, 30));
        button.setMinimumSize(new Dimension(100, 30));
        button.addActionListener(command);
        return button;
    }
}
