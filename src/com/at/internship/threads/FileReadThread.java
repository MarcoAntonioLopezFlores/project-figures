package com.at.internship.threads;

import com.at.internship.services.DirectoryService;
import com.at.internship.services.FileService;

public class FileReadThread implements Runnable{
    @Override
    public void run() {
        FileService service = new FileService();
        service.openFiles();
    }
}
