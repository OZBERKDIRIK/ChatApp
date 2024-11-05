package org.server.strategydesign;

import org.messagerfile.PersonFile;
import org.person.Person;
import org.person.PersonService;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class AuthStrategy implements  Strategy {

    private Socket socket = new Socket("localhost",123456);
    private PrintWriter dataOut ;
    private PersonService personService ;
    public AuthStrategy() throws IOException {
        dataOut = new PrintWriter(socket.getOutputStream());
        personService =new PersonService();
    }

    @Override
    public void execute(String name, String surname) {
        boolean isLogin = personService.isLogin(name,surname);
        if(isLogin){
            dataOut.write("AUTH SUCCESS");
        }else{
            dataOut.write("AUTH FAILURE");
        }
    }

}
