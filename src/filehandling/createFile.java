package filehandling;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class createFile {
	public static void main(String args[])
	{
		createFile gfg = new createFile();
		gfg.newFile();
	}
	public void newFile()
	{
		String strPath = "", strName = "";
		try {
			BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
			System.out.println("Enter the file name:");
			strName = br.readLine();
			
			 
			System.out.println("Enter the file path:");
			strPath = br.readLine();
			File file1
				= new File(strPath + "" + strName + ".txt");
			file1.createNewFile();
			System.out.println("file created sucessfully");
		
		}
		catch (Exception ex1) {
		}
	}
}
