package com.at.internship.services;

import com.at.internship.constants.Constants;
import com.at.internship.constants.Messages;
import com.at.internship.utils.BuilderMenu;
import com.at.internship.utils.InputPane;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DirectoryService {

    public File createDirectory(String nameDirectory){
        File directory;
        boolean directoryCreated=true;
        do{
            File mainDirectory = new File(Constants.PATH);
            if (!mainDirectory.exists()) mainDirectory.mkdir();
                directory = new File(String.format(Constants.PATH_FILE_CREATE,nameDirectory));
                if (!directory.exists()) directoryCreated = directory.mkdir();
        }while(!directoryCreated);
        return directory;
    }

    public Map<Integer, File> readSubdirectories(String path){

        int id=1;
        File directory = new File(path);
        Map<Integer, File> directories = new HashMap<>();
        for (File file : Objects.requireNonNull(directory.listFiles(File::isDirectory))) {
            directories.put(id,file);
            id++;
        }
        return directories;
    }

    public File chooseDirectory(Map<Integer, File> directories){
        BuilderMenu builderMenu = new BuilderMenu();
        InputPane input = new InputPane();
        String menu = builderMenu.makeMenuDirectories(Messages.TITULO_SELECCIONAR_OPCION, directories);
        File directory;
        do {
            int option = input.readJPaneInteger(null, menu);
            directory = directories.get(option);
            if (directory == null) JOptionPane.showMessageDialog(null, Messages.OPCION_INVALIDA);
        } while(directory==null);
        return directory;
    }
}
