package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Updated_GUI_Design extends JFrame {
	static String pName="";
	File hue;
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
					Updated_GUI_Design frame = new Updated_GUI_Design();
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
	public Updated_GUI_Design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 490, 257);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "A");
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Add File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
//				int i=0;
				File f=chooser.getSelectedFile();
				String filepath=f.getAbsolutePath();
				String filename=f.getName();
				String data[]= {filename,filepath};
				int n=filename.length();
				String fname=filename;
				DefaultTableModel model=(DefaultTableModel)table.getModel();
//				String s="";
				int flag=1;
				if(fname.endsWith(".pdf")) {
					String s = "";
				    boolean exists = false;
					for (int i = 0; i < table.getRowCount(); i++) {
				        s = table.getValueAt(i, 0).toString().trim();
				            if (fname.equals(s)) {
				                exists = true;
				                break;
				            }
				    } 
					
				    if (!exists) {
				        model.addRow(data);
				        
				    } else {
				    	if(flag==1) {
				    		JOptionPane.showMessageDialog(null, "Data Already Exist !");
				    		flag=0;
				    	}
				    	
				        
				    }
					
				}
			}
				
		});
		btnNewButton.setBounds(10, 33, 109, 23);
		panel_1.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Add Folder");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.showOpenDialog(null);
				int i=0;
				File f=chooser.getSelectedFile();
				File arr[] = f.listFiles();
				
				RecursiveDirectory(arr, 0);
//				String filepath=f.getAbsolutePath();
//				String filename=f.getName();
//				setpName(filepath);
//				System.out.println(pName);
//				String data[]= {filename,filepath};
//				DefaultTableModel model=(DefaultTableModel)table.getModel();
//				model.addRow(data);
			}
			
			
			private void RecursiveDirectory(File[] arr, int i) {
				// TODO Auto-generated method stub
				for (File f : arr) {
					
					if (f.isFile()) {
						String filepath=f.getAbsolutePath();
						String filename=f.getName();
						String data[]= {filename,filepath};
//						scrollPane_1.
						String fname=filename;
						int n=fname.length();
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						int flag=1;
						if(fname.endsWith(".pdf")) {
							String s = "";
						    boolean exists = false;
							for (int i1 = 0; i1 < table.getRowCount(); i1++) {
						        s = table.getValueAt(i1, 0).toString().trim();

						        
						            if (fname.equals(s)) {
						                exists = true;
						                break;
						        }
						    }
							
						    if (!exists) {
						        model.addRow(data);
						        
						    } else {
						    	
						    	if(flag==1) {
						    		JOptionPane.showMessageDialog(null, "Data Already Exist !");
						    		flag=0;
						    		break;
						    		
						    	}
//						    	flag=0;
//						        JOptionPane.showMessageDialog(null, "Data Already Exist.");
						    }
						}
					}

					else if (f.isDirectory()) {
//						System.out.println( f.getAbsolutePath());
//						String filepath=f.getAbsolutePath();
//						String filename=f.getName();
//						String data[]= {filename,filepath};
						RecursiveDirectory(f.listFiles(), i + 1);
//						DefaultTableModel model=(DefaultTableModel)table.getModel();
//						model.addRow(data);
					}
				}
			}
		});
		
		btnNewButton_1.setBounds(10, 77, 109, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int arr[]=table.getSelectedRows();
				if(table.getRowCount()==0) {
					JOptionPane.showMessageDialog(null,"Please add file/folder before continue");
				}

				for(int i=0;i<arr.length;i++) {
					model.removeRow(arr[i]);
				}
				
			}
		});
		btnNewButton_2.setBounds(10, 118, 109, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove All");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
		});
		btnNewButton_3.setBounds(10, 159, 109, 23);
		panel_1.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(129, 11, 351, 205);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"File Name", "Path"
			}
		));
		
		JButton btnNewButton_4 = new JButton("Change Card");
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)panel.getLayout();
				card.show(panel, "B");
				
				
				

			
			}
			
			
		});
		btnNewButton_4.setBounds(338, 227, 131, 23);
		panel_1.add(btnNewButton_4);
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "B");
		 
		   
		    JTree tree = new JTree();
		    tree.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		
		    		 if (e.getClickCount() == 2) {
		                 DefaultMutableTreeNode node = (DefaultMutableTreeNode)
		                        tree.getLastSelectedPathComponent();
		                 if (node == null) return;
		                 System.out.println(node);
//		                 Object nodeInfo = node.getUserObject();
		                 // Cast nodeInfo to your object and do whatever you want
		             }
		    	}
		    });
		    tree.setModel(new DefaultTreeModel(
		    	new DefaultMutableTreeNode("root") {
		    		{
		    		}
		    	}
		    ));
		   
		    tree.setRootVisible(true);
		    tree.setShowsRootHandles(true);
		    JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(tree);
			
			scrollPane_1.setBounds(28, 11, 312, 219);
			panel_2.add(scrollPane_1);
			panel_2.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("Load");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				File rootFile = new File(getpName());
				DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootFile);
				DefaultTreeModel model = new DefaultTreeModel(root);
				DefaultMutableTreeNode r = (DefaultMutableTreeNode) model.getRoot();
				 
				 tree.setModel(model);
			      root.removeAllChildren();
			      model.reload();
//			      JFileChooser chooser = new JFileChooser();
//			      	chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//					chooser.showOpenDialog(null);
//					int i=0;
//					File f=chooser.getSelectedFile();

			      File f = (File) r.getUserObject();
			      addFiles(f, model, r);
//			      int arr[]=table.getSelectedRows();
			      DefaultTreeModel model1 = (DefaultTreeModel) tree.getModel();
			      
			      
			      tree.expandPath(new TreePath(r));
				
			}
			
			
			protected void addFiles(File rootFile, DefaultTreeModel model,
				      DefaultMutableTreeNode root) {
				    for (File file : rootFile.listFiles()) {
				    	
				    	 DefaultMutableTreeNode child = new DefaultMutableTreeNode(file);
				    	 String fname=file.getName();
					    	int n=fname.length();
				    	if(fname.charAt(n-1)=='t' && fname.charAt(n-2)=='x' && fname.charAt(n-3)=='t') {
				    	
					      model.insertNodeInto(child, root, root.getChildCount());
				    	}
				     
				    	else if  (file.isDirectory()) {
				        addFiles(file, model, child);
				      }
				    }
				  }
		});
		panel_2.setLayout(null);
		btnNewButton_5.setBounds(344, 50, 120, 23);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card= (CardLayout) panel.getLayout();
				card.show(panel, "A");
				
			}
			
		});
		btnNewButton_6.setBounds(344, 141, 120, 23);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Print Console");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int arr[]=tree.getSelectionRows();
//				TreePath[] brr=tree.getSelectionPaths();
//				int j=0;
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
//				
				System.out.println(node);
//				System.out.println(node.getUserObject().toString()); 
//			      for(int i=0;i<brr.length;i++) {
//			    	  TreePath s=brr[i];  	  
//						System.out.println(s);
//					}
				
			}
		});
		btnNewButton_7.setBounds(343, 97, 137, 23);
		panel_2.add(btnNewButton_7);
		
		
		
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
}
