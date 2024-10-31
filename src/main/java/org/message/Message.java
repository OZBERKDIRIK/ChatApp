package org.message;

import org.person.Person;

import java.util.HashMap;
import java.util.Map;

public class Message
{
    //Message classı messageın sahip olması gereken özellikleri tutar
    //bir JavaBean classıdır.

    //Bir mesajın göndericisi , alıcı , mesaj konusu , mesaj içeriği olmalıdır

    //gönderici -> Person
    //alıcı -> Person

    //mesaj konusu -> String
    //mesaj içeriği -> String

    // Özelliklerin hepsi getter ve setter metoduna sahip olabilir.
    private Person sender;
    private Person reciver;

    private String messageTopic ;

    private String messageContet;

    private static int messageID=0;
    //Messsage Constructor
    public Message(Person sender , Person reciver , String messageTopic , String messageContent){
        this.sender=sender;
        this.reciver=reciver;
        this.messageTopic=messageTopic;
        this.messageContet=messageContent;
        messageID++;
    }


    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getReciver() {
        return reciver;
    }

    public void setReciver(Person reciver) {
        this.reciver = reciver;
    }

    public String getMessageTopic() {
        return messageTopic;
    }

    public void setMessageTopic(String messageTopic) {
        this.messageTopic = messageTopic;
    }

    public String getMessageContet() {
        return messageContet;
    }

    public void setMessageContet(String messageContet) {
        this.messageContet = messageContet;
    }

    public static int getMessageID(){
        return messageID;
    }
}
