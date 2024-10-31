package org.database;

import com.google.gson.Gson;

public interface TxtFileOperations {
    Gson txtFileRead();

    void txtFileWrite(Object objcet);
}
