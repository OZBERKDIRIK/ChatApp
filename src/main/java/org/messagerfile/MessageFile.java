package org.messagerfile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.message.Message;
import org.message.MessageService;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MessageFile extends MessagerFile implements TxtFileOperations {
    private static File sentMessage = new File(messagerAppFile, "Gönderilen-Mesaj.txt");
    private static File receivedMessage = new File(messagerAppFile, "Alınan-Mesaj.txt");

    private MessageService messageService = new MessageService();
    private Gson gson = new Gson();

    @Override
    public List<Message> txtFileRead(File file) {
        String line = "";
        try (JsonReader reader = new JsonReader(new FileReader(file))) {
            Type listType = new TypeToken<ArrayList<Message>>() {
            }.getType();
            List<Message> messageJsonList = new Gson().fromJson(reader, listType);
            return messageJsonList;
        } catch (IOException e) {
            System.out.println("Dosyadan okuma başarılı olamadı ....");
            return null;
        }
    }
    @Override
    public void txtFileWrite(File file) {
        if (file.exists()) {
            try (BufferedWriter dataOut = new BufferedWriter(new FileWriter(file, true))) {
                Map<Integer, Message> messageMap = messageService.getSentMessage();
                String message = gson.toJson(messageMap);
                dataOut.write(message);
            } catch (IOException e) {
                System.out.println("Dosya yazma işlemi başarılı olamadı");
            }
        }else{
            file.mkdir();
            try (BufferedWriter dataOut = new BufferedWriter(new FileWriter(file, true))) {
                Map<Integer, Message> messageMap = messageService.getSentMessage();
                String message = gson.toJson(messageMap);
                dataOut.write(message);
            } catch (IOException e) {
                System.out.println("Dosya yazma işlemi başarılı olamadı");
            }
        }

    }
    public File getReceivedMessage(){
        return  receivedMessage;
    }
    public File getSentMessage(){
        return  sentMessage;
    }
}
