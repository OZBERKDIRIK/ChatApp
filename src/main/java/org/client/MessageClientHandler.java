package org.client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageClientHandler implements Runnable {

    private Socket socket;
    private PrintWriter dataOut;  //Stream'e yazmak için kullanıyoruz
    private BufferedReader dataIn;  //Stream'den okumak için kullanıyoruz
    public MessageClientHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {

    }
}
