package com.at.internship.utils;

import com.at.internship.constants.Messages;

import javax.swing.*;
import java.awt.*;

public class InputPane {
    public String readJPaneString(JFrame frame,String promp){

        String value = null;
        do{
            try{
                value = JOptionPane.showInputDialog(frame,promp);
                if(value==null){
                    int response = showConfirmDialog(Messages.TITULO_SELECCIONAR_OPCION, Messages.CANCELAR_ADVERTENCIA);
                    if (response == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, Messages.FINALIZADO);
                        System.exit(0);
                    }            }
            }catch (HeadlessException | NullPointerException e){
                System.err.println(e.getMessage());
            }
        }while(value == null);
        return value.trim().replace(" ","");
    }

    public double readJPaneDouble(JFrame frame,String promp){

        double value = 0;
        do{
            try{
                String valueString = JOptionPane.showInputDialog(frame,promp);
                if(valueString!=null){
                    value= Double.parseDouble(valueString);
                }else{
                    int response = showConfirmDialog(Messages.TITULO_SELECCIONAR_OPCION, Messages.CANCELAR_ADVERTENCIA);
                    if (response == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, Messages.FINALIZADO);
                        System.exit(0);
                    }
                }
            }catch (HeadlessException | NumberFormatException | NullPointerException e ){
                JOptionPane.showMessageDialog(null, Messages.INGRESO_NUM_VALIDO);
            }
        }while(value <= 0);
        return value;
    }

    public int readJPaneInteger(JFrame frame,String promp){

        int value = 0;
        do{
            try{
                String valueString = JOptionPane.showInputDialog(frame,promp);
                if(valueString!=null){
                    value= Integer.parseInt(valueString);
                }else{
                    int response = showConfirmDialog(Messages.TITULO_SELECCIONAR_OPCION, Messages.CANCELAR_ADVERTENCIA);
                    if (response == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, Messages.FINALIZADO);
                        System.exit(0);
                    }
                }
            }catch (HeadlessException | NumberFormatException | NullPointerException e ){
                JOptionPane.showMessageDialog(null, Messages.INGRESO_NUM_VALIDO);
            }
        }while(value <= 0);
        return value;
    }

    public int showConfirmDialog(String title, String description){
        return JOptionPane.showConfirmDialog(null,
                description,
                title,
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    }

}
