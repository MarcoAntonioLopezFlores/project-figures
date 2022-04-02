package com.at.internship.threads;
import com.at.internship.services.FileService;

import java.io.File;

public class FileReadThread implements Runnable{

    private File directory;
    private String[] nameFiles;

    public FileReadThread(File directory, String[] nameFiles){
        this.directory=directory;
        this.nameFiles=nameFiles;
    }

    @Override
    public void run() {
        FileService service = new FileService();
        service.openFiles(directory,nameFiles);
    }
}
