package org.messagerfile;

import com.google.gson.Gson;

import java.io.File;

public class PersonFile extends MessagerFile implements TxtFileOperations{

    private File registerPersonFile  = new File(messagerAppFile,"KayıtlıKisiler.txt");

    private File authPersonFile = new File(messagerAppFile,"GirisYapanKisiler.txt");

    @Override
    public Gson txtFileRead(File file) {
        return null;
    }

    @Override
    public void txtFileWrite(Object objcet) {

    }
}
