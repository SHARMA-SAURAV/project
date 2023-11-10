import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CreateCSVFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try { 
	        // create FileWriter object with file as parameter 
	        FileWriter outputfile = new FileWriter("E:\\Aryson EXE\\test.CSV"); 
	        CSVWriter writer = new CSVWriter(outputfile); 
	  
	        // create a List which contains String array 
	        List<String[]> data = new ArrayList<String[]>(); 
	        data.add(new String[] { "Name", "Class", "Marks" }); 
	        data.add(new String[] { "Aman", "10", "620" }); 
	        data.add(new String[] { "Suraj", "2", "666" }); 
	        data.add(new String[] { "Amit", "3", "554" });
	        data.add(new String[] { "Shubham", "5", "345" });
	        data.add(new String[] { "Saurav", "12", "999" });
	        data.add(new String[] { "Daksh", "11", "567" });
	        writer.writeAll(data); 
	  
	        // closing writer connection 
	        writer.close(); 
	    } 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
