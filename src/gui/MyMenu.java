package gui;

import logic.Command;

import javax.swing.*;

public class MyMenu extends JMenuBar{

    private Command cmd = null;

    public MyMenu(Command cmd){
        this.cmd = cmd;
        init();
    }

    private void init() {
        JMenu menu = new JMenu("File");

        JMenu submenu = new JMenu("New");
        JMenuItem itemText = new JMenuItem("Text");
        itemText.addActionListener(cmd.getTextPanel());
        submenu.add(itemText);

        JMenuItem itemSound = new JMenuItem("Sound");
        itemSound.addActionListener(cmd.getSoundPanel());
        submenu.add(itemSound);

        menu.add(submenu);

        JMenuItem itemImage = new JMenuItem("Image");
        itemImage.addActionListener(cmd.getImagePanel());
        submenu.add(itemImage);

        JMenuItem itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(cmd.openFile());
        menu.add(itemOpen);

        JMenuItem itemSave = new JMenuItem("Save");
        itemSave.addActionListener(cmd.saveFile());
        menu.add(itemSave);



        add(menu);
    }


}
