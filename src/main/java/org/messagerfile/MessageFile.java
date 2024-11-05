package org.messagerfile;

import com.google.gson.Gson;
import org.message.Message;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MessageFile extends MessagerFile implements TxtFileOperations{
    private File sentMessage = new File(messagerAppFile,"GönderilenMesaj.txt");
    private File receivedMessage = new File(messagerAppFile,"AlınanMesaj.txt");
    private Gson gson = new Gson();
    @Override
    public List<Message> txtFileRead(File file) {
        try{
            String line="";
            List<Message> messageList = new ArrayList<>();
            BufferedReader filerReader = new BufferedReader(new FileReader(file));
            while((line = filerReader.readLine())!=null){

            }
            filerReader.close();
        }catch(IOException exception){
            System.out.println("Dosya okunamadı");
        }
        return null;
    }

    @Override
    public void txtFileWrite(Object objcet) {

    }
}
