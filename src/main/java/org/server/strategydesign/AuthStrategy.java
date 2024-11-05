package org.server.strategydesign;

import org.person.PersonService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class AuthStrategy implements  Strategy {

    private Socket socket = new Socket("localhost",123456);
    private PrintWriter dataOut ;
    private PersonService personService ;
    public AuthStrategy() throws IOException {
        dataOut = new PrintWriter(socket.getOutputStream());
        personService =new PersonService();
    }

    @Override
    public void execute() {


    }

}
