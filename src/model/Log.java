package model;

import com.sun.glass.ui.Size;

import javax.activation.FileDataSource;
import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Oniichan
 * @data 25/09/2021
 * @project GuessNumber
 */
public class Log {
    public static String filePath;
    public static FileWriter fw;
    public static FileOpen fr;
    static{
        filePath =  new SimpleDateFormat("dd_MM_yyyy").format(new Date().getTime()) + ".txt";
    }

    public static void logWrite(String row){
        String data = null;
        try {
            fw = new FileWriter(filePath,true);
            data = new SimpleDateFormat("[dd:MM:yyyy HH:mm:ss.SSSS]").format(new Date().getTime()) + " -> " + row +"\n";
            fw.write(data);
            fw.close();
        } catch (IOException e) {
        }
    }
    public static String logRead(){
        fr = new FileOpen(filePath);
        return fr.allFile();
    }
    public static void deleteLog(){
        try{
            fw = new FileWriter(filePath);
            fw.write("");
            fw.close();
        }catch(Exception e){
        }
    }
}
