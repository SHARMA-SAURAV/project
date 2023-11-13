
package Swing;



import java.awt.EventQueue;



import javax.swing.JFrame;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JTree;

import javax.swing.JScrollPane;

import javax.swing.tree.DefaultTreeModel;

import javax.swing.tree.TreePath;



import com.opencsv.CSVReader;

import com.opencsv.CSVReaderBuilder;



import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.DefaultCheckboxTreeCellRenderer;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;



import javax.swing.tree.DefaultMutableTreeNode;

import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;

import javax.swing.JFileChooser;



import java.awt.event.ActionListener;

import java.io.File;

import java.io.FileReader;

import java.awt.event.ActionEvent;

import javax.swing.JTextPane;



public class New_GUI_Design extends JFrame {

static String fname="";

File brr[];



static String fpath="";

File f;

private static final long serialVersionUID = 1L;

private JPanel contentPane;

private JTable table;



/**

* Launch the application.

*/

public static void main(String[] args) {

EventQueue.invokeLater(new Runnable() {

public void run() {

try {

New_GUI_Design frame = new New_GUI_Design();

frame.setVisible(true);

} catch (Exception e) {

e.printStackTrace();

}

}

});

}



/**

* Create the frame.

*/

public New_GUI_Design() {

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setBounds(100, 100, 751, 445);

contentPane = new JPanel();

contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));



setContentPane(contentPane);

contentPane.setLayout(null);



JPanel panel = new JPanel();

panel.setBounds(0, 0, 735, 406);

contentPane.add(panel);

panel.setLayout(null);



JScrollPane scrollPane = new JScrollPane();

scrollPane.setBounds(10, 11, 318, 253);

panel.add(scrollPane);



CheckboxTree tree = new CheckboxTree();

tree.setModel(new DefaultTreeModel(

new DefaultMutableTreeNode("Root") {

{

}

}

));

tree.setRootVisible(true);

   tree.setShowsRootHandles(true);

scrollPane.setViewportView(tree);



JScrollPane scrollPane_1 = new JScrollPane();

scrollPane_1.setBounds(10, 273, 692, 122);

panel.add(scrollPane_1);

panel.setLayout(null);

//table.setModel(new DefaultTableModel(

//		new Object[][] {

//		},

//		new String[] {

//			"File Name", "Path"

//		}

//	));

table = new JTable();





scrollPane_1.setViewportView(table);



JTextPane txtpnHello = new JTextPane();



txtpnHello.setBounds(408, 149, 227, 20);

panel.add(txtpnHello);



JButton btnNewButton = new JButton("Add Folder");

btnNewButton.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {



JFileChooser chooser = new JFileChooser();

      chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

chooser.showOpenDialog(null);

// int i=0;

File fi=chooser.getSelectedFile();

File arr[] = fi.listFiles();

// brr=arr;

f=fi;

setFname(fi.getName());

setFpath(fi.getAbsolutePath());

// txtpnHello.se

txtpnHello.setText(getFpath());



}











});

btnNewButton.setBounds(456, 30, 131, 23);

panel.add(btnNewButton);



JButton btnNewButton_1 = new JButton("Load");

btnNewButton_1.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {



File rootFile = new File(getFname());

DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootFile);

DefaultTreeModel model = new DefaultTreeModel(root);

DefaultMutableTreeNode r = (DefaultMutableTreeNode) model.getRoot();

// File[] subItems = rootFile.listFiles();

//        for (File file : subItems) {

//            r.add(new DefaultMutableTreeNode(file));

//        }



tree.setModel(model);

     root.removeAllChildren();

     model.reload();

//      File f = (File) r.getUserObject();

     addFiles(f, model, r);

     DefaultTreeModel model1 = (DefaultTreeModel) tree.getModel();

     tree.expandPath(new TreePath(r));

     

     

     

//      tree.expandPath(new TreePath(r));

     



}



protected void addFiles(File rootFile, DefaultTreeModel model,

     DefaultMutableTreeNode root) {

//System.out.println(rootFile.getName());

//System.out.println(rootFile.getAbsolutePath());

   for (File file : rootFile.listFiles()) {

//     System.out.println(file.getName());

    DefaultMutableTreeNode child = new DefaultMutableTreeNode(file.getName());

    String fname=rootFile.getName();

   

   

    if(file.isDirectory()) {

//     System.out.println(txtpnHello.getText().toString().trim());

//     System.out.println(getFpath());

    if(txtpnHello.getText().toString().trim().equals(getFpath())) {

    model.insertNodeInto(child, root, root.getChildCount());

   

  addFiles(file, model, child);

    }

    else {

    JOptionPane.showMessageDialog(null, "Entred Path is Worng !");

    break;

    }

   

     }

//    if (file.isFile()) {

    	String name=file.getName();

    	if(name.endsWith(".csv")|| name.endsWith(".CSV")) {

    		model.insertNodeInto(child, root, root.getChildCount());

//    	}

    	

    }

   }

 }

});

btnNewButton_1.setBounds(456, 83, 131, 23);

panel.add(btnNewButton_1);



JButton btnNewButton_3 = new JButton("ADD");



btnNewButton_3.addActionListener(new ActionListener() {

	

public void actionPerformed(ActionEvent e) {

TreePath[] node=tree.getCheckingPaths();

// String s=tree.getse

// TreePath[] sss=tree.getCheckingPaths();

// System.out.println(sss[0]);



// TreePath[] node1=tree.getCheckingRoots();

//DefaultCheckboxTreeCellRenderer node = (DefaultCheckboxTreeCellRenderer) tree.getLastSelectedPathComponent();



for(int i=0;i<node.length;i++) {

String str=node[i].toString();

// System.out.println(str);

Object [] bob = node[i].getPath();

// System.out.println(bob[i]);

// System.out.println(node[i]);

String path=f.getAbsolutePath();



for(int j=1;j<bob.length;j++) {



path+="\\"+bob[j];

}

// System.out.println(path);



try {

	FileReader fileReader=new FileReader(path);

	

	CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(0).build(); 

	String[] data;

	

	int start=0;

	while ((data = csvReader.readNext()) != null) {

		

		if(start==0) {

			start=1;

			table.setModel(new DefaultTableModel(

					new Object[][] {

					},

					data

				));

//			table.setModel(model);

		}

		

		else	{

			DefaultTableModel model=(DefaultTableModel)table.getModel();

//			System.out.println("hello");

			model.addRow(data);

		}

			

		

		

    }

}

	

catch (Exception e1) {

	// TODO Auto-generated catch block

	e1.printStackTrace();

}



}









}



//private void recursiveDirectry(String path) {

//// TODO Auto-generated method stub

//File f=new File(path);

//File arr[]=f.listFiles();

//for (File ff : arr) {

//if (ff.isFile()) {

//

//String fipath=ff.getAbsolutePath();

//String finame=ff.getName();

//long size=ff.length();

//String ss=size/1000+"KB";

//String data[]= {finame,fipath,ss};

//DefaultTableModel model=(DefaultTableModel)table.getModel();

//model.addRow(data);

//

//}

//}







});

btnNewButton_3.setBounds(589, 230, 89, 23);

panel.add(btnNewButton_3);



JButton btnNewButton_2 = new JButton("Remove All");

btnNewButton_2.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {

DefaultTableModel model = (DefaultTableModel) table.getModel();

model.setRowCount(0);

}

});

btnNewButton_2.setBounds(409, 230, 113, 23);

panel.add(btnNewButton_2);









}

public static String getFname() {

return fname;

}



public static void setFname(String fname) {

New_GUI_Design.fname = fname;

}



public static String getFpath() {

return fpath;

}



public static void setFpath(String fpath) {

New_GUI_Design.fpath = fpath;

}

}

