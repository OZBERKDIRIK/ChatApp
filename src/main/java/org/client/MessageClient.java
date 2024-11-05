package org.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MessageClient {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 12345;


        try (Socket socket = new Socket(host, port);
             PrintWriter dataOut = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader dataIn = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            String userInput;

            System.out.println("Bağlantı kuruldu. Komutlarınızı girebilirsiniz.");

            while (true) {
                System.out.print("> ");
                userInput = scanner.nextLine();
                dataOut.println(userInput);

                String serverResponse;
                while ((serverResponse = dataIn.readLine()) != null) {
                    System.out.println(serverResponse);
                    if (!dataIn.ready()) {
                        break;
                    }
                }
                if (userInput.equals("QUIT") || userInput.equals("quıt")) {
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println("Bağlantı Hatası ");
        }
    }
}
