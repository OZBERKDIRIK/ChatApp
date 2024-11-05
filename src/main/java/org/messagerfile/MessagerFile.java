package org.messagerfile;

import java.io.File;

public class MessagerFile {
   private String desktopPath = System.getProperty("user.home") + "/Desktop";

    private File desktop = new File(desktopPath);

    protected File messagerAppFile = new File(desktop,"MessagerApp");



}
