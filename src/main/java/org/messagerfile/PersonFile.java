package org.messagerfile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.message.Message;
import org.person.Person;
import org.person.PersonService;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonFile extends MessagerFile implements TxtFileOperations{

    private static File registerPersonFile  = new File(messagerAppFile,"KayıtlıKisiler.txt");
    private Gson gson = new Gson();

    @Override
    public void txtFileWrite(File file) {
        if (file.exists() && file.equals(registerPersonFile)) {
            try (BufferedWriter dataOut = new BufferedWriter(new FileWriter(file, true))) {
                List<Person> registredPersonList = PersonService.getRegisteredPerson();
                String registredPerson = gson.toJson(registredPersonList);
                dataOut.write(registredPerson);
            } catch (IOException e) {
                System.out.println("Dosya yazma işlemi başarılı olamadı");
            }
        }else{
            file.mkdir();
            try (BufferedWriter dataOut = new BufferedWriter(new FileWriter(file, true))) {
                List<Person> registredPersonList = PersonService.getRegisteredPerson();
                String registredPerson = gson.toJson(registredPersonList);
                dataOut.write(registredPerson);
            } catch (IOException e) {
                System.out.println("Dosya yazma işlemi başarılı olamadı");
            }
        }
    }
    @Override
    public List<Person> txtFileRead(File file) {
        try (JsonReader reader = new JsonReader(new FileReader(file))) {
            Type listType = new TypeToken<ArrayList<Person>>() {
            }.getType();
            List<Person> personJsonList = new Gson().fromJson(reader, listType);
            return personJsonList;
        } catch (IOException e) {
            System.out.println("Dosyadan okuma başarılı olamadı ....");
            return null;
        }
    }

    public File getRegisteredPersonFile(){
        return registerPersonFile;
    }
}
