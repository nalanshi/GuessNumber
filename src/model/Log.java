package model;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public static FileReader fr;
    static{
        filePath = "log.txt";
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
        char read[] = null;
        try {
            read = new char[fr.read()];
            fr = new FileReader(filePath);
            fr.read(read);
            fr.close();
        } catch (Exception e) {
        }
        assert read != null;
        return String.copyValueOf(read);
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
