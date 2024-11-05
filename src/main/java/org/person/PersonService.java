package org.person;

import org.messagerfile.PersonFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PersonService implements PersonOperations {

    private static List<Person> registeredPerson;
    private static PersonFile personFile ;
    public PersonService()
    {
        registeredPerson= new ArrayList<>();
        personFile = new PersonFile();

    }

    @Override
    public boolean isLogin(String name, String surname) {
        boolean islogin = false;
        File registerdFile =  personFile.getRegisteredPersonFile();
        List<Person> registerdPersonList = personFile.txtFileRead(registerdFile);
        for (Person person : registerdPersonList) {
            if (person.getName().equals(name) && person.getSurname().equals(surname)) {
                islogin = true;
                break;
            }
        }
        return islogin;
    }

    @Override
    public boolean isSignUp(String name, String surname) {
        Person newPerson = new Person(name, surname);
        File registerdFile =  personFile.getRegisteredPersonFile();
        List<Person> registerdPersonList = personFile.txtFileRead(registerdFile);
        boolean isRegisterd = registerdPersonList.contains(newPerson);
        if (isRegisterd) {
            System.out.println("Daha önce kayıt olmuştur");
            return false;
        } else {
            getRegisteredPerson().add(newPerson);
            return true;
        }
    }
    public static List<Person> getRegisteredPerson() {
        return registeredPerson;
    }
}
