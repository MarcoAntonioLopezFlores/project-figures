package com.at.internship.services;

import com.at.internship.constants.Constants;
import com.at.internship.constants.Messages;
import com.at.internship.utils.InputPane;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class FileService{

    public String createFile(){
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setFocusable(true);
        frame.setAutoRequestFocus(true);
        frame.requestFocusInWindow();
        DirectoryService directoryService = new DirectoryService();
        InputPane input = new InputPane();
        boolean fileCreated;
        String nameFile = null;
        File file = null;
        do{
            try{
                nameFile = input.readJPaneString(frame,Messages.INGRESAR_NOMBRE_ARCHIVO);
                LocalDate date = LocalDate.now();
                File directory = directoryService.createDirectory(date.toString());
                file = new File(directory,String.format(Constants.FILE_INPUT,nameFile));
                if(!file.exists()){
                    fileCreated=file.createNewFile();
                    if(fileCreated) JOptionPane.showMessageDialog(frame, String.format(Messages.ARCHIVO_CREADO, nameFile,directory.getName()));

                }else{
                    int response = input.showConfirmDialog(String.format(Messages.ARCHIVO_EXISTENTE, nameFile),String.format(Messages.PREGUNTA_REESCRIBIR, nameFile));
                    if(response==JOptionPane.YES_OPTION){
                        boolean fileDeleted = file.delete();
                        fileCreated=file.createNewFile();
                        if(fileDeleted && fileCreated) JOptionPane.showMessageDialog(frame, String.format(Messages.ARCHIVO_REESCRITO, nameFile,directory.getName()));
                    }else{
                        fileCreated=false;
                    }
                }
            }catch(NullPointerException | IOException e){
                JOptionPane.showMessageDialog(frame, String.format(Messages.ARCHIVO_NO_CREADO, nameFile));
                fileCreated=false;
            }
        }while(!fileCreated);
        return file.getPath();
    }

    public void writeFile(String data, String filePath){
        try {
            FileWriter file = new FileWriter(filePath);
            file.write(data);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFiles(){
        DirectoryService directoryService = new DirectoryService();
        File directory = directoryService.chooseDirectory(directoryService.readSubdirectories());

        System.out.println(Arrays.toString(directory.listFiles()));
    }
}
