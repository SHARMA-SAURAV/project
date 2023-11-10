package filehandling;

import java.io.File;

public class DeleteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file
        = new File("C:\\Users\\admin\\eclipse-workspace\\filehandling\\src\\filehandling\\filehandlingaryson.txt");

    if (file.delete()) {
        System.out.println("File deleted successfully");
    }
    else {
        System.out.println("Failed to delete the file");
    }

	}

}
