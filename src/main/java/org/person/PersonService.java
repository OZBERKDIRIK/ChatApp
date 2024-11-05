package org.person;

import java.util.ArrayList;
import java.util.List;

public class PersonService implements PersonOperations {

    private  List<Person> registeredPerson;

    public PersonService(){
        registeredPerson=new ArrayList<>();
    }
    @Override
    public boolean login(String name, String surname) {
        boolean islogin=false;
        for(Person person :registeredPerson){
            if(person.getName().equals(name) && person.getSurname().equals(surname)) {
                islogin= true;
                break;
            }
        }
        return islogin;
    }

    @Override
    public boolean signUp(String name, String surname) {
        Person newPerson = new Person (name ,surname);
        boolean isRegisterd = registeredPerson.contains(newPerson);
        if(isRegisterd){
            System.out.println("Daha önce kayıt olmuştur");
            return false;
        }else{
            registeredPerson.add(newPerson);
            return true;
        }

    }

}
