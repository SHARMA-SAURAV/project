package filehandle;
import java.io.Serializable;
public class Student implements Serializable{
	String name;
	int age;
	String branch;
	String email;
	Student(String name, int age, String branch, String email){
		this.name = name;
		this.age = age;
		this.branch = branch;
		this.email = email;
	}
}
