package com.at.internship.services;

import com.at.internship.constants.Constants;
import com.at.internship.constants.Messages;
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
            directory = new File(String.format(Constants.PATH_FILE_CREATE,nameDirectory));
            if (!directory.exists()) directoryCreated = directory.mkdir();
        }while(!directoryCreated);
        return directory;
    }

    public Map<Integer, File> readSubdirectories(){
        File directory = new File(Constants.PATH);
        int id=1;
        Map<Integer, File> directories = new HashMap<>();
        for (File file : Objects.requireNonNull(directory.listFiles(File::isDirectory))) {
            directories.put(id,file);
            id++;
        }
        return directories;
    }

    private File chooseDirectory(Map<Integer, String> directories, String menu){
        JFrame frame = new JFrame();
        frame.requestFocusInWindow();
        InputPane input = new InputPane();
        File directory;
        do{
            int option = input.readJPaneInteger(null,menu);
            directory = new File(String.format("./%s",nameDirectory));
            if(!(directory.exists() && directory.isDirectory())){
                JOptionPane.showMessageDialog(frame, String.format(Messages.CARPETA_NO_EXISTENTE, nameDirectory));
            }
        }while(!(directory.exists() && directory.isDirectory()));
        return directory;
    }
}
