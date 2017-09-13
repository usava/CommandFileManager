package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by andrey on 11.08.2017.
 */
public class TextPanel extends JPanel {



    private JTextArea display = null;
    private JScrollPane scroll = null;

    public TextPanel() {
        init();
    }
    public JTextArea getDisplay() {
        return display;
    }

    public void setDisplay(JTextArea display) {
        this.display = display;
    }
    private void init() {
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);
        display = new JTextArea();
        display.setEditable(true);
// добавляем скролл
        scroll = new JScrollPane(display);
        scroll.setPreferredSize(new Dimension(600, 400));
        scroll.setMinimumSize(new Dimension(500,400));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll, makeGbc(0,0));
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

    public String setText(String text){
        display.setText(text);
        System.out.println(text+"TextPanel setText()");
        return text;
    }
}
