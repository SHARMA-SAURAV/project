package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class New_Design extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTree tree;
	String path="";
	File f;
	JsonObject jsonObject;
	TreePath[] node;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_Design frame = new New_Design();
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
	public New_Design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 628, 386);
		contentPane.add(panel);
		panel.setLayout(null);
		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 208, 235);
		panel.add(scrollPane);
		
//		JTree tree = new JTree() ;
		
		 DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

         DefaultTreeModel model = new DefaultTreeModel(root);
	
		scrollPane.setColumnHeaderView(tree);
		JButton btnNewButton = new JButton("Select File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser=new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.showOpenDialog(null);
				
				File fi=chooser.getSelectedFile();
				f=fi;
				String name=fi.getName();
				path=fi.getAbsolutePath();
				textPane.setText(name);
				 
		           
//				node=tree.getSelectionPaths();
//				System.out.println(node);
//				node=select;
		           
				
				try {
					jsonObject = JsonParser.parseReader(new FileReader(path)).getAsJsonObject();
//		            JsonElement jsonElement = JsonParser.parseReader(new FileReader(path));
//		            System.out.println(jsonElement);
		            addJsonObjectToTree( jsonObject, root, model);
//		            DefaultMutableTreeNode root = createTreeNode(jsonElement);
//		            System.out.println(root);
//		            JTree tree = new JTree(root);
//		        	tree.setModel(new DefaultTreeModel(
//		        			new DefaultMutableTreeNode("root") {
//		        				{
//		        				}
//		        			}
//		        		));
		            tree = new JTree(model);
		           
		        	scrollPane.setColumnHeaderView(tree);
		            
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
				
				
				
			}
			
			
			
			
			 private static void addJsonObjectToTree(JsonObject jsonObject, DefaultMutableTreeNode root, DefaultTreeModel model) {
			        for (String key : jsonObject.keySet()) {
			            DefaultMutableTreeNode keyNode = new DefaultMutableTreeNode(key);

			            if (jsonObject.get(key).isJsonObject()) {
			                root.add(keyNode);
			                addJsonObjectToTree(jsonObject.get(key).getAsJsonObject(), keyNode, model);
			            }
			                else {
			                DefaultMutableTreeNode valueNode = new DefaultMutableTreeNode(jsonObject.get(key).getAsString());
			                
			                keyNode.add(valueNode);
			                model.insertNodeInto(keyNode, root, root.getChildCount());
			            }
			        }
			    }
			
			
			 
			 
			 
			 
			 
			 
			 
			
			
		});
		btnNewButton.setBounds(36, 32, 125, 23);
		panel.add(btnNewButton);
		
	
		
		
		textPane.setBounds(321, 32, 255, 23);
		panel.add(textPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(240, 101, 362, 235);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Key", "value"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
//				System.out.println(selectedElement);
				String key=selectedElement.toString();
			
//					object.
				 String value = getValueFromJson(jsonObject, selectedElement);
				 String data[]= {key,value};
//				 System.out.println(value);
				 DefaultTableModel model=(DefaultTableModel)table.getModel();
//					System.out.println("hello");
					model.addRow(data);

				
				
				
				
//		        Object[] row = {selectedElement};
				
				
				
				
			}

			
			  private static String getValueFromJson(JsonObject jsonObject, DefaultMutableTreeNode selectedElement) {
				  String hue="";
////					System.out.println(jsonObject.get(key).getAsJsonObject());
//					JsonObject  object = 	jsonObject.get(key).getAsJsonObject();
//					for(String atr : object.keySet()) {
//						hue+=atr;	
//					}
				  Object userObject=selectedElement.getUserObject();
//				  System.out.println(userObject.toString());
				  int child=selectedElement.getChildCount();
				  for(int i=0;i<child;i++) {
					  DefaultMutableTreeNode childnode=(DefaultMutableTreeNode) selectedElement.getChildAt(i);
					  Object userObject1=childnode.getUserObject();
//					  System.out.println(userObject1.toString());
					  hue+=userObject1.toString()+" ";
					  
				  }
					 
					return hue;}
			        
			        
			        
			        
			        
			      
		
			
			
			
		});
		btnNewButton_1.setBounds(390, 352, 89, 23);
		panel.add(btnNewButton_1);
	}
}
