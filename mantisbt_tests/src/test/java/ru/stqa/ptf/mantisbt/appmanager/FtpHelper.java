package ru.stqa.ptf.mantisbt.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpHelper {
    private final ApplicationManager app;
    private FTPClient ftp;

    public FtpHelper(ApplicationManager app){
        this.app = app;
        ftp = new FTPClient();
    }

    public void upload(File file, String target,String backUp) throws IOException {
        ftp.connect(app.getProperty("ftp.host"));
        ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
        ftp.deleteFile(backUp);
        ftp.rename(target, backUp);
        ftp.enterLocalPassiveMode();
        ftp.storeFile(target, new FileInputStream(file));
        ftp.disconnect();
    }
     public void restore(String backUp, String target) throws IOException {
        ftp.connect(app.getProperty("ftp.host"));
         ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
         ftp.deleteFile(target);
         ftp.rename(backUp, target);
         ftp.disconnect();
     }
}
