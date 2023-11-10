package filehandle;
	import java.io.*;
	public class ReadObject {
		public static void main(String[]args) {
			try {
				FileInputStream fin = new FileInputStream("C:\\Users\\admin\\Desktop\\Java1.txt");
				ObjectInputStream in = new ObjectInputStream(fin);
				Student s = (Student) in.readObject();
				System.out.println("Student name "+s.name);
				Student s2 = (Student) in.readObject();
				System.out.println("Student name "+s2.name+" "+s2.email);
				Student s3 = (Student) in.readObject();
				System.out.println("Student name "+s3.name+" "+"Email Id "+s3.email);
			}
			catch(Exception e) {
			}
		}
	}
	
