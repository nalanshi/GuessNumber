package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileOpen {
	private String[] lastData;
	private File myObj;
	private Scanner myReader;
	private int seek =0;
	private int Max = 0;
	public FileOpen(String address) {
		// TODO Auto-generated constructor stub
		try {	
		      myObj = new File(address);
		      myReader = new Scanner(myObj);
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	}
	public FileOpen(String address, String regex) {
		// TODO Auto-generated constructor stub
		int i=0;
		try {	
			Pattern pattern = Pattern.compile(regex);
		      myObj = new File(address);
		      myReader = new Scanner(myObj);
		      String data = "";
		      i = 0;
		      while(myReader.hasNextLine()) {
		      data += myReader.nextLine()+"\n";
		      }
		      lastData = pattern.split(data);
		      for(@SuppressWarnings("unused") String s : lastData)
		      {
		    	  i++;
		      }
			myReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

			Max = i;
	}

	public void setSeek(int seek) throws Exception{
		if(seek<0)throw new Exception("Must not be negative !!!!!");
		else this.seek = seek;
	}
	public int getSeek() {
		return seek;
	}
	public void calcMax(String regex) throws Exception{
		if(regex == null) throw new Exception("Error input!!!!!!");
		myReader = new Scanner(myObj);
		Pattern pattern = Pattern.compile(regex);
	      String data = "";
	      int i = 0;
	      while(myReader.hasNextLine()) {
	      data += myReader.nextLine()+"\n";
	      }
	      lastData = pattern.split(data);
	      for(@SuppressWarnings("unused") String s : lastData)
	      {
	    	  i++;
	      }
		Max = i;
		myReader.close();

	}
	public void setRegex(String regex) throws Exception {
		calcMax(regex);
	}
	public String nextLine() {
		if(Max == 0 || lastData == null)return "you have to configure using calcMax(regex)";
		else if(seek == Max) return "you have just reached the limit !!!!!";
		else 
		return lastData[seek++];
	}
	public String allFile(){
		try {
			myReader = new Scanner(myObj);
		} catch (FileNotFoundException e) {}
		String data = "";
		while(myReader.hasNextLine()) {
			data += myReader.nextLine() + "\n";
		}
		myReader.close();
		return data;

	}
	public static boolean isFile(String path){
		File file = new File(path);
		if(file.isFile()){
			return true;
		}
		return false;
	}
}
