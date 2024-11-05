package org.messagerfile;

import java.io.File;

public class MessagerFile {
   private static String desktopPath = System.getProperty("user.home") + "/Desktop";

    private static File desktop = new File(desktopPath);

    protected static File messagerAppFile = new File(desktop,"MessagerApp");



}
