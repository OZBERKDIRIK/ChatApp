package org.messagerfile;

import com.google.gson.Gson;

import java.io.File;

public interface TxtFileOperations {
    Object txtFileRead(File file);

    void txtFileWrite(File file);
}
