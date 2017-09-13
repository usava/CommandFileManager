package file;

import java.io.*;

public class OpenFileTxt extends FileManager implements InterfaceOpenable{

   private File file;
   public String text;

    public OpenFileTxt(File file) {
        super(file);
        interfaceOpenable = this;
        this.file = file;

    }

    @Override
    public void openFile() {
        if(file != null){
            BufferedReader br = null;
            FileReader fr = null;

            try{
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                StringBuffer line = new StringBuffer();
                int data = -1;
                do{
                    data = br.read();
                    if(data != -1) {
                        line.append((char)data);
                    }
                }while(data != -1);

                setText(line.toString());
                this.text = line.toString();
            }catch (IOException ex){
                ex.printStackTrace();
            }finally{
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public String getText(){
//        return this.text;
//    }

}
