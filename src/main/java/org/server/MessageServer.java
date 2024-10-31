package org.server;

import org.message.Message;
import org.message.MessageService;
import org.person.Person;
import org.person.PersonService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class MessageServer {
    public static void main(String[] args) throws IOException {
        MessageService messageService = new MessageService();
        PersonService personService = new PersonService();
        ServerSocket serverSocket = new ServerSocket(5001);
        System.out.println("Server Listening on port 5001...");

        while (true) {
            Socket connectionSocket = serverSocket.accept();
            new Thread(() -> {
                try {
                    ObjectInputStream dataIn = new ObjectInputStream(connectionSocket.getInputStream());
                    ObjectOutputStream dataOut = new ObjectOutputStream(connectionSocket.getOutputStream());
                    String operator = dataIn.readUTF();
                    Message message = new Message();
                    Person person = null;
                    switch (operator.toLowerCase(Locale.forLanguageTag("TR"))) {
                        case "register":
                               break;
                        case "auth":
                                break;
                        case "send":

                            break;
                        case "read":
                            break;
                        case "list":
                            break;
                        case "quit":
                            break;
                    }
                    connectionSocket.close();
                } catch (IOException e) {
                    System.out.println("İstemci - Sunucu Bağlantı Hatası " +e.getMessage());
                }
            }).start();
        }
    }
}
