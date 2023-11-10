package Swing;
import java.awt.*;

import javax.swing.*;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;

public class button {
	button() {
//		Frame f = new Frame();
//		
		JFrame f=new JFrame();
		
		String data[][]={ };    
		String column[]={"ID","NAME","SALARY"};         
		JTable jt=new JTable(data,column);    
		jt.setBounds(30,40,200,300);          
		JScrollPane sp=new JScrollPane(jt);  
		Button b1 = new Button("Add File");
		b1.setBounds(100, 50, 80, 50);
		f.add(b1);
		Button b2 = new Button("Add Folder");
		b2.setBounds(100, 150, 80, 50);
		f.add(b2);
		Button b3 = new Button("Remove");
		b3.setBounds(100, 250, 80, 50);
		f.add(b3);
		f.add(sp);          
		f.setSize(300,400);    
		f.setVisible(true);    
		
//		
//		 String column[]={"S.No","File Name","Path"};  
//	    JTable jt=new JTable(null,column);
//	    jt.setBounds(30, 40, 200, 300);
////	    JScrollPane sp = new JScrollPane(jt);
////        f.add(sp);
//	    f.add(jt);
//		
//		f.setSize(300,   400);
//		f.setLayout(null);
//		f.setVisible(true);
	}

	
	   
	  
	    
	public static void main(String a[]) {
		new button();   
	}
	}

