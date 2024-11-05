package org.server;

import org.client.MessageClient;
import org.client.MessageClientHandler;
import org.message.Message;
import org.message.MessageService;
import org.person.Person;
import org.person.PersonService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageServer {
    private static final int PORT = 12345;
    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Sunucu " + PORT + " portunda başlatıldı");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Yeni bağlantı kabul edildi: " + clientSocket.getInetAddress());
                threadPool.execute(new MessageClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
