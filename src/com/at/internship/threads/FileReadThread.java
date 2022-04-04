package com.at.internship.threads;
import com.at.internship.services.FileService;

import java.io.File;

public class FileReadThread implements Runnable{

    private final File directory;
    private final String nameFile;

    public FileReadThread(File directory, String nameFile){
        this.directory=directory;
        this.nameFile=nameFile;
    }

    @Override
    public void run() {
        FileService service = new FileService();
        service.openFiles(directory,nameFile);
    }
}
