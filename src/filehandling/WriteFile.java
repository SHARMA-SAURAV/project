package filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 	String text="Aryson technologies hemlo hue hue";
		 	 try {
		            BufferedWriter f_writer
		                = new BufferedWriter(new FileWriter(
		                    "C:\\Users\\admin\\eclipse-workspace\\filehandling\\src\\filehandling\\filehandlingaryson.txt"));
		            f_writer.write(text);
		            System.out.print(text);
		            System.out.print(
		                "File is created successfully with the content.");
		            f_writer.close();
		        }
		        catch (IOException e) {
		            System.out.print(e.getMessage());
		        }
		    

	}

}
