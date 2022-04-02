package com.at.internship.services;

import com.at.internship.constants.Constants;
import com.at.internship.constants.Messages;
import com.at.internship.threads.FileReadThread;
import com.at.internship.utils.BuilderMenu;
import com.at.internship.utils.InputPane;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public void chooseFiles(){
        DirectoryService directoryService = new DirectoryService();
        BuilderMenu builderMenu = new BuilderMenu();
        InputPane inputPane = new InputPane();
        Map<Integer, File> directories = directoryService.readSubdirectories(Constants.PATH);
        if(!directories.isEmpty()){
            File directory = directoryService.chooseDirectory(directories);
            String menu = builderMenu.makeMenuDirectories(String.format(Messages.SELECCIONAR_ARCHIVOS, Constants.NAME_SEPARATOR, Constants.SEPARATOR_FILES),readFiles(directory.getPath()));
            String filesToOpen = inputPane.readJPaneString(null,menu);
            Thread thread = new Thread(new FileReadThread(directory,filesToOpen.split(Constants.SEPARATOR_FILES)));
            thread.start();
        }else{
            JOptionPane.showMessageDialog(null, Messages.DIRECTORIO_VACIO);
        }

    }

    public Map<Integer, File> readFiles(String path){
        File directory = new File(path);
        int id=1;
        Map<Integer, File> files = new HashMap<>();
        for (File file : Objects.requireNonNull(directory.listFiles(File::isFile))) {
            files.put(id,file);
            id++;
        }
        return files;
    }

    public void openFiles(File directory,String[] nameFiles){
        for (String nameFile : nameFiles) {
            File file = new File(String.format(Constants.FILE_INPUT, directory.getPath()+"/"+nameFile));
            if(file.exists()){
                if(!Desktop.isDesktopSupported()){
                    System.err.println("Desktop is not supported");
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else System.err.println(nameFile+" does not exist.");
        }
    }
}
