package zimbra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

import com.aspose.email.MailMessage;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class ZimbraExtracterTool extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	String name="";
	String path="";
	String messageText="";
//	JTextPane txtpn ;
	JTextArea txtrSdvfdsafgvfr ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZimbraExtracterTool frame = new ZimbraExtracterTool();
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
	public ZimbraExtracterTool() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 59, 758, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 196, 391);
		panel.add(scrollPane);
		
		CheckboxTree tree = new CheckboxTree();
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TreePath[] node=tree.getCheckingPaths();
				for(int i=0;i<node.length;i++) {

					String str=node[i].toString();

					// System.out.println(str);

					Object [] bob = node[i].getPath();

					// System.out.println(bob[i]);

					// System.out.println(node[i]);

//					String path=.getAbsolutePath();
					


					for(int j=1;j<bob.length;j++) {


						
					path+="\\"+bob[j];

					}
					
				}
//				System.out.println(path);
				File ff=new File(path);
				File[] arr=ff.listFiles();
				for(File f: arr) {
					if(f.isFile() && f.getName().toString().endsWith(".EML")) {
						String emlFilePath = f.getAbsolutePath();
				        String outputFilePath = "E:\\Saurav\\output.txt.txt";

//				        try {
				            MailMessage mailMessage = MailMessage.load(emlFilePath);

				            // Extract the text content from the EML message
				            messageText = mailMessage.getBody().toString();
				            String from=mailMessage.getFrom().toString();
				            String subject=mailMessage.getSubject().toString();
				            String date=mailMessage.getDate().toString();
				            String size=f.getTotalSpace()/1000+"KB";
				            String data[]= {from,subject,date,size};
//				            System.out.println(from);
				            // Write the text content to a text file
				            DefaultTableModel model=(DefaultTableModel)table.getModel();
				            model.addRow(data);
//				            contentPane.add(messageText);
//				            try (FileWriter writer = new FileWriter(outputFilePath)) {
//				                writer.write(messageText);
//				            }
//
//				            System.out.println("Conversion from EML to TXT completed successfully.");
//
//				        } catch (IOException e1) {
//				            e1.printStackTrace();
//				        }
//				        }
					}
				}
				
			}
		});
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
				}
			}
		));
		scrollPane.setViewportView(tree);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				AbstractButton txtpn = null;
//				txtpn.setText(messageText);
				txtrSdvfdsafgvfr.setText(messageText);
				
				
			}
		});
		scrollPane_1.setBounds(196, 0, 552, 186);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"From", "Subject", "Date", "Size"
			}
		));
		scrollPane_1.setViewportView(table);
		
//	    new JTextPane();
//		txtpnErgse.setText("ergse");
//		txtpnErgse.setContentType("");
//		txtpn.setBounds(198, 214, 550, 175);
//		panel.add(txtpn);
		
		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setBounds(208, 189, 100, 25);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(196, 211, 562, 169);
		panel.add(scrollPane_2);
		
		 new JTextArea();
		scrollPane_2.setViewportView(txtrSdvfdsafgvfr);
		
		JButton btnNewButton = new JButton("Open");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser=new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.showOpenDialog(null);
				File fi=chooser.getSelectedFile();
				 String path1=fi.getAbsolutePath();
				 String tgzFilePath = path1;
				  name=fi.getName();
				 String destinationDirectory = "E:\\Saurav";
				 path=destinationDirectory;
				 
				 try {
			            FileInputStream fis = new FileInputStream(tgzFilePath);
			            GzipCompressorInputStream gzis = new GzipCompressorInputStream(fis);
			            TarArchiveInputStream taris = new TarArchiveInputStream(gzis);

			            TarArchiveEntry entry;
			            while ((entry = taris.getNextTarEntry()) != null) {
			                if (entry.isDirectory()) {
			                    continue;
			                }
			                
			                File outFile = new File(destinationDirectory, entry.getName());
//			                System.out.println();
			                File parent = outFile.getParentFile();
			                if (!parent.exists() && !parent.mkdirs()) {
			                    throw new IllegalStateException("Couldn't create dir: " + parent);
			                }

			                try (OutputStream fos = new FileOutputStream(outFile)) {
			                    byte[] buffer = new byte[1024];
			                    int length;
			                    while ((length = taris.read(buffer)) != -1) {
			                        fos.write(buffer, 0, length);
			                    }
			                }
			            }

			            taris.close();
			            gzis.close();
			            fis.close();

			            System.out.println("Extraction completed successfully.");
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
				 
				 
				 
				 File rootFile = new File(destinationDirectory);
				 DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootFile);
				 DefaultTreeModel model = new DefaultTreeModel(root);
				 DefaultMutableTreeNode r = (DefaultMutableTreeNode) model.getRoot();
				 // File[] subItems = rootFile.listFiles();
//				         for (File file : subItems) {
//				             r.add(new DefaultMutableTreeNode(file));
//				         }

				 tree.setModel(model);
				      root.removeAllChildren();
				      model.reload();
//				       File f = (File) r.getUserObject();
				      addFiles(rootFile, model, r);
				      DefaultTreeModel model1 = (DefaultTreeModel) tree.getModel();
				      tree.expandPath(new TreePath(r));
			}
			
			
			protected void addFiles(File rootFile, DefaultTreeModel model,

				     DefaultMutableTreeNode root) {

				//System.out.println(rootFile.getName());

				//System.out.println(rootFile.getAbsolutePath());

				   for (File file : rootFile.listFiles()) {

//				     System.out.println(file.getName());

				    DefaultMutableTreeNode child = new DefaultMutableTreeNode(file.getName());

				    String fname=rootFile.getName();

				   

				   

				    if(file.isDirectory()) {

//				     System.out.println(txtpnHello.getText().toString().trim());

//				     System.out.println(getFpath());

//				    if(txtpnHello.getText().toString().trim().equals(getFpath())) {

				    model.insertNodeInto(child, root, root.getChildCount());

				   

//				  addFiles(file, model, child);

//				    }

				  

				   

				     }

//				    if (file.isFile()) {

//				    	String name=file.getName();
//
//				    	
//
//				    		model.insertNodeInto(child, root, root.getChildCount());

//				    	}

				    	

				    

				   }

				 }
			
			
				 
		});
		btnNewButton.setBounds(10, 11, 70, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(105, 11, 70, 37);
		contentPane.add(btnNewButton_1);
	}
}

