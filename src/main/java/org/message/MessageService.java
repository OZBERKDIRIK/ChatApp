package org.message;

import java.util.*;

public class MessageService implements MessageOperations{

    private Map<Integer , Message> sentMessage;

    public MessageService(){
        sentMessage=new HashMap<Integer, Message>();
    }

    public Map<Integer , Message> getSentMessage(){
        return sentMessage;
    }
    public void sendMessage(Message message) {
            sentMessage.put(Message.getMessageID(),message);
    }

    public Message readMessage(int messageId) {
        Message message = null;
        try{
            for(Map.Entry<Integer, Message> entry :sentMessage.entrySet()){
                if(entry.getKey().equals(messageId)){
                    message= entry.getValue();
                }
            }
        }catch(Exception e){
            System.out.println("Mesaj Bulunamadı");
            message= null;
        }
        return message;
    }

    public List<Message> getListMessage() {
        return (List<Message>) sentMessage.values();
    }
}
