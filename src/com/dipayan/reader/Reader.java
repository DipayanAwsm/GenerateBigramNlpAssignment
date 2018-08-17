/*
========================================
	Author:Dipayan Das
	Roll:CS1726
	NLP Project
	Guide:Utpal G
	Bhabatu Sarba Mangalam
========================================	
*/
package com.dipayan.reader;
import java.io.File;
import java.util.Scanner;
public class Reader {

	
	  public static void main(String[] args) throws Exception
	  {
	    // pass the path to the file as a parameter
		String fileLocation="";  
	    File file =   new File("src/doc/doc1.txt");
	    Scanner sc = new Scanner(file);
	    String tempData="";
	    String tempDataArray[];
	    int length;
	    while (sc.hasNextLine()) {
	    	tempData=sc.nextLine();
	    	tempData.trim();
	    	tempDataArray=tempData.split(" ");
	    	length=tempDataArray.length-1;
	    	for(int i=0;i<length;i++) {
	    		System.out.print(tempDataArray[i]+" "+tempDataArray[i+1]+"-\n");
	    	}
//	    	System.out.println(temp);
	 }
	}
}
