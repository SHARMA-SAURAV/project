package filehandle;
	import java.io.FileOutputStream;
	import java.io.ObjectOutputStream;
	public class ObjectOutput {
		public static void main(String[]args) {
			Student s = new Student("Gojo", 26, "Mechanical", "satorougojo69@gmail.com");
			Student s2 = new Student("Goku", 30, "CSE","goku6969@gmail.com");
			Student s3 = new Student("Luffy", 30, "SunGod","piratekingluffy123@gmail.com");
			try {
				FileOutputStream fout = new FileOutputStream("C:\\Users\\admin\\Desktop\\Java1.txt");
				ObjectOutputStream sout = new ObjectOutputStream(fout);
				sout.writeObject(s);
				sout.writeObject(s2);
				sout.writeObject(s3);
				System.out.println("Data written successfully");
			}
			catch(Exception e) {
			}
		}
	

}

