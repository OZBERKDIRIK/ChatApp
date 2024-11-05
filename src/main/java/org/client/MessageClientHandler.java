package org.client;

import org.server.strategydesign.Strategy;
import org.server.strategydesign.StrategyContext;
import org.server.strategydesign.StrategySelector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;

public class MessageClientHandler implements Runnable {

    private Socket socket;
    private PrintWriter dataOut;  //Stream'e yazmak için kullanıyoruz
    private BufferedReader dataIn;  //Stream'den okumak için kullanıyoruz
    public MessageClientHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        //dataOut , dataIn bağlantılarını yap
        //While döngüsünde Streamdne dataIn kullanarak oku
        try{
            dataOut = new PrintWriter(socket.getOutputStream() ,true); //Socket üzerinden okuyacağız
            dataIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input ;

            while((input=dataIn.readLine())!=null){
                String[] clientInput; //Command windowdan okunan değerleri bir String arrayi olarak tutuyoruz
                clientInput = input.split(" ",3); //Boşlukları base alarak 3 paraçaya böldük
                String keyword = clientInput[0]; //clientInputun 1 elemanı keyword olarak belirledik

                //Keyword strategy uygun olarak tüm harfleri büyük olacak şekilde değiştirildi
                keyword= keyword.toLowerCase(Locale.ROOT);

                //İlgili Strategy seçildi
                StrategySelector strategySelector = new StrategySelector();
                Strategy strategy = strategySelector.getStrategy(keyword);

                //Seçilen strategy uygulandı
                StrategyContext commandStrategy = new StrategyContext(strategy);
                commandStrategy.executeStrategy(clientInput[1], clientInput[2]);
            }
        } catch (IOException e) {
            throw new RuntimeException("Socket I/O hatası " +e );
        }
    }
}
