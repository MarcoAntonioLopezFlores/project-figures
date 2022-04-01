package com.at.internship.threads;

import com.at.internship.services.FileService;

public class FileWriteThread implements Runnable{

    private final String data;

    public FileWriteThread(String data){
        this.data=data;
    }

    @Override
    public void run() {
        FileService fileService = new FileService();
        String filePath = fileService.createFile();
        fileService.writeFile(data,filePath);
    }

}
