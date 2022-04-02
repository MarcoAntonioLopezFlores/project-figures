package com.at.internship.services;

import com.at.internship.constants.Constants;
import com.at.internship.constants.Messages;
import com.at.internship.domain.*;
import com.at.internship.enums.FiguresEnum;
import com.at.internship.enums.OperationsEnum;
import com.at.internship.exceptions.ProcessAbortedException;
import com.at.internship.interfaces.IFigure;
import com.at.internship.threads.FileWriteThread;
import com.at.internship.utils.BuilderMenu;
import com.at.internship.utils.InputPane;

import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static com.at.internship.constants.Constants.NUMBER_FORMAT;

public class FigureService {

    public void calculateMeasures() throws ProcessAbortedException {
        try{
            InputPane input = new InputPane();
            IFigure measures = null;
            FiguresEnum figure = chooseFigure();
            switch(figure){
                case CIRCLE:
                    double radio = input.readJPaneDouble(null,String.format(Messages.INGRESO_RADIO, Constants.UNITY_MEASURE));
                    measures = new Circle(radio);
                    break;
                case SQUARE:
                    double side = input.readJPaneDouble(null,String.format(Messages.INGRESO_LADO, Constants.UNITY_MEASURE));
                    measures = new Square(side);
                    break;
                case RECTANGLE:
                    double base = input.readJPaneDouble(null,String.format(Messages.INGRESO_BASE, Constants.UNITY_MEASURE));
                    double height = input.readJPaneDouble(null,String.format(Messages.INGRESO_ALTURA, Constants.UNITY_MEASURE));
                    measures = new Rectangle(base, height);
                    break;
                case ISOSCELES_TRIANGLE:
                    double sideI = input.readJPaneDouble(null,String.format(Messages.INGRESO_LADO, Constants.UNITY_MEASURE));
                    double baseI= input.readJPaneDouble(null,String.format(Messages.INGRESO_BASE, Constants.UNITY_MEASURE));
                    measures = new IsoscelesTriangle(sideI, baseI);
                    break;
                case EQUILATERAL_TRIANGLE:
                    double sideE = input.readJPaneDouble(null,String.format(Messages.INGRESO_LADO, Constants.UNITY_MEASURE));
                    measures = new EquilateralTriangle(sideE);
                    break;
            }

            if( measures != null){
                String message = String.format(Messages.MENSAJE_FINAL,
                        figure.getName(),
                        measures.readAttributes(),
                        NUMBER_FORMAT.format(measures.calculatePerimeter()),
                        NUMBER_FORMAT.format(measures.calculateArea()));
                JOptionPane.showMessageDialog(null,message);
                JOptionPane.showMessageDialog(null,Messages.AVISO_REGISTRO_RESULTADOS);
                Thread thread = new Thread(new FileWriteThread(message));
                thread.start();

            }
        }catch (NoSuchElementException | NumberFormatException e){
            throw new ProcessAbortedException(Messages.OPCION_INVALIDA,OperationsEnum.REGISTER_CALCULATE);
        }

    }

    private FiguresEnum chooseFigure() throws ProcessAbortedException {
        try{
            InputPane input = new InputPane();
            BuilderMenu builderMenu = new BuilderMenu();
            String menu = builderMenu.makeMenuFigures(Messages.INGRESO_OPCION_FIGURA);
            int option = input.readJPaneInteger(null,menu);
            return Stream.of(FiguresEnum.values()).filter(f -> f.getOption() == option).findFirst().orElseThrow(NoSuchElementException::new);
        }catch (NoSuchElementException | NumberFormatException e ) {
            throw new ProcessAbortedException(Messages.OPCION_INVALIDA,OperationsEnum.REGISTER_CALCULATE);
        }

    }
}
