package filehandling;

import java.io.*;
import java.util.Scanner;

public class readFile {

	 public static void main(String[] args) throws Exception
	    {
	        File file = new File(
	            "C:\\Users\\admin\\eclipse-workspace\\filehandling\\src\\filehandling\\filehandlingaryson.txt");
	        Scanner sc = new Scanner(file);
	 
	        while (sc.hasNextLine())
	            System.out.println(sc.nextLine());
	    }
}
