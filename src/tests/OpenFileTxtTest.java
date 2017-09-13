package tests;

import file.FileManager;
import file.OpenFileTxt;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class OpenFileTxtTest {
    @Test
    void openFile() {

        String etalonText = "Hello, world!" +System.lineSeparator()+
                "Привет, мир!" +System.lineSeparator()+
                "Привіт, світ!";

        File file = new File("c:\\Users\\Svyatoslav\\IdeaProjects\\ComFileMan\\src\\tests\\etalon.txt");
        FileManager fm = new FileManager(file);
        OpenFileTxt openFileTxt = new OpenFileTxt(file);
        openFileTxt.openFile();

        String result = openFileTxt.text;
        assertEquals(result, etalonText);
    }

}