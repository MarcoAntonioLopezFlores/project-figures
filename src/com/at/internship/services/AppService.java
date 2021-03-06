package com.at.internship.services;

import com.at.internship.constants.Messages;
import com.at.internship.enums.OperationsEnum;
import com.at.internship.exceptions.ProcessAbortedException;
import com.at.internship.utils.BuilderMenu;
import com.at.internship.utils.InputPane;

import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class AppService{

    public static void run(){
        InputPane input = new InputPane();
        BuilderMenu builderMenu = new BuilderMenu();
        String menu = builderMenu.makeMenuMain(Messages.SELECCIONAR_ACCION);
        OperationsEnum process = null;

        do{
            try{
                int option = input.readJPaneInteger(null,menu);
                process = Stream.of(OperationsEnum.values()).filter(p -> p.getOption() == option).findFirst().orElseThrow(NoSuchElementException::new);
                switch (process){
                    case REGISTER_CALCULATE:
                        FigureService figureService = new FigureService();
                        figureService.calculateMeasures();
                        break;
                    case OPEN_FILES:
                        FileService service = new FileService();
                        service.chooseFiles();
                        break;
                    case EXIT:
                        JOptionPane.showMessageDialog(null, Messages.FINALIZADO);
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, Messages.OPCION_INVALIDA);
                }
            }catch (ProcessAbortedException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.err.printf(Messages.MENSAJE_ERROR_PROCESO, e.getProcess());
            } catch (NoSuchElementException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, Messages.OPCION_INVALIDA);
            }
        }while(!Objects.equals(process, OperationsEnum.EXIT));
    }
}
