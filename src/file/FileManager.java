package file;

import com.sun.media.sound.JavaSoundAudioClip;

import java.awt.*;
import java.io.File;

public class FileManager {
    private File file = null;
    private String text = null;
    private Image image = null;
    private JavaSoundAudioClip sound = null;

    public InterfaceSavable interfaceSavable = null;
    public InterfaceOpenable interfaceOpenable = null;

    public FileManager(File file) {
        this.file = file;
    }

    public void openFileTxt(){
        this.interfaceOpenable.openFile();
        this.interfaceOpenable.getText();
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setSound(JavaSoundAudioClip sound) {
        this.sound = sound;
    }

    public File getFile() {

        return file;
    }

    public String getText() {
        return text;
    }

    public Image getImage() {
        return image;
    }

    public JavaSoundAudioClip getSound() {
        return sound;
    }
}
