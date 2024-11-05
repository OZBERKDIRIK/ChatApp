package org.server.strategydesign;

import org.person.PersonService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class RegisterStrategy implements Strategy  {

    private Socket socket = new Socket("localhost",123456);
    private PrintWriter dataOut ;
    private PersonService personService ;

    public RegisterStrategy() throws IOException {
        dataOut = new PrintWriter(socket.getOutputStream());
        personService =new PersonService();
    }

    @Override
    public void execute(String name, String surname) {
        boolean isSignUp = personService.isLogin(name,surname);
        if(isSignUp){
            dataOut.write("REGISTER SUCCESS");
        }else{
            dataOut.write("REGISTER FAIL");
        }
    }
}
