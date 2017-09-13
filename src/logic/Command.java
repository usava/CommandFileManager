package logic;

import file.FileManager;
import file.OpenFileTxt;
import gui.ImagePanel;
import gui.MyFrame;
import gui.TextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by andrey on 14.08.2017.
 */
public class Command implements ActionListener {

    private MyFrame frame = null;
    private gui.TextPanel textPanel = null;

    public Command(MyFrame frame) {
        this.frame = frame;
    }

    // Интерфейс класса Command

    // Mетод создает во Фрейме текстовую панель для записи и чтения текстового файла
    public TextPanel getTextPanel() {
        return new TextPanel();
    }

    // Mетод создает во Фрейме Image Panel для записи и чтения текстового файла
    public ImagePanel getImagePanel(){
        return new ImagePanel();
    }
    public SoundPanel getSoundPanel(){
        return new SoundPanel();
    }

    // Метод очищает панель от содержимого
    public ClearPanel clearPanel() {
        return new ClearPanel();
    }

    public ActionListener openFile() { return new OpenFile(); }

    public ActionListener saveFile() { return new SaveFile(); }

    private class ClearPanel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (textPanel != null) {
                textPanel.getDisplay().setText("");
            }
//            gui.ImagePanel imagePanel = (gui.ImagePanel) findComponent(gui.ImagePanel.class);
//            if (imagePanel != null) {
//                // Написать логику очистки Дисплея от содержимого (удалить текущую фотографию, если она есть)
//            }
//            gui.SoundPanel soundPanel = (gui.SoundPanel) findComponent(gui.SoundPanel.class);
//            if (soundPanel != null) {
//                // Написать логику очистки Дисплея от информации о записи звукового файла
//            }
        }
    }

    // Класс TextPanel удаляет из GUI объекты классов ImagePanel или SoundPanel и добавляет TextPanel
    private class TextPanel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setTextPanel();
        }

    }

    private void setTextPanel(){
        if(textPanel == null) {
            textPanel = new gui.TextPanel();
        }

        removePanel(gui.ImagePanel.class, gui.SoundPanel.class);

        frame.add(textPanel, BorderLayout.CENTER);
        //textPanel.setText(this.text);
        frame.setVisible(true);
    }

    // Класс ImagePanel удаляет из GUI объекты классов TextPanel или SoundPanel и добавляет ImagePanel
    private class ImagePanel implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) {
            removePanel(gui.TextPanel.class, gui.SoundPanel.class);
            CommandImage commandImage = new CommandImage();
            frame.add(new gui.ImagePanel(commandImage), BorderLayout.CENTER);
            frame.setVisible(true);
        }
    }

    // Класс ImagePanel удаляет из GUI объекты классов TextPanel или SoundPanel и добавляет ImagePanel
    private class SoundPanel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            removePanel(gui.TextPanel.class, gui.ImagePanel.class);
            CommandSound commandSound = new CommandSound();
            frame.add(new gui.SoundPanel(commandSound), BorderLayout.CENTER);
            frame.setVisible(true);
        }
    }
    // Метод удаляет из Фрейма компонент Класса а или Класса б
    private void removePanel(Class a, Class b) {
        for (Component c : frame.getContentPane().getComponents()) {
            if (c.getClass().equals(a) || c.getClass().equals(b)) {
                frame.remove(c);
                frame.repaint();
            }
        }
    }

    // Метод находит и возвращает компонент из Фрейма соответствующий заданному классу
    private Component findComponent(Class a) {
        Component component = null;
        for (Component c : frame.getContentPane().getComponents()) {
            if (c.getClass().equals(a)) {
                component = c;
            }
        }
        return component;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class OpenFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            if( fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                String fileName = file.getName();
                String fileType = fileName.substring(fileName.lastIndexOf('.')+1);

                if(fileType.equals("txt") || fileType.equals("php")){
                    System.out.println("Invoke method to open file " + fileType);
                    FileManager fileManager = new OpenFileTxt(file);
                    fileManager.openFileTxt();

                    setTextPanel();

                    textPanel.setText(fileManager.getText());
                    System.out.println(fileManager.getText());
                }else if(fileType.equals("jpeg") || fileType.equals("jpg")){
                    System.out.println("Invoke method to open file " + fileType);
                }else if(fileType.equals("mp3") || fileType.equals("wav")){
                    System.out.println("Invoke method to open file " + fileType);
                }else{
                    JOptionPane message = new JOptionPane();
                    message.showMessageDialog(null,"Unable to open file "+fileName);
                }
            }
            System.out.println("Open File");
        }
    }

    private class SaveFile implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Save File");
        }
    }
}
