package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.tree.DefaultMutableTreeNode;

public class GUI_Design_Tree extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Design_Tree frame = new GUI_Design_Tree();
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
	public GUI_Design_Tree() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 112, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Choose Folder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f=chooser.getCurrentDirectory();
				File arr[] = f.listFiles();
				RecursiveDirectory(arr, 0);
				
				
			}
			
			private void RecursiveDirectory(File[] arr, int i) {
				// TODO Auto-generated method stub
				for (File f : arr) {
					
					if (f.isFile()) {
						String filepath=f.getAbsolutePath();
						String filename=f.getName();
						String data[]= {"1",filename,filepath};
//						scrollPane_1.
//						DefaultTreeModel model=(DefaultTreeModel)tree.;
//						model.addRow(data);

					}
						
						

					else if (f.isDirectory()) {
//						System.out.println( f.getAbsolutePath());
						RecursiveDirectory(f.listFiles(), i + 1);
					}
				}
			}
			
		});
		btnNewButton.setBounds(0, 56, 108, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(132, 0, 302, 261);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("root") {
				{
					add(new DefaultMutableTreeNode(""));
				}
			}
		));
		scrollPane.setViewportView(tree);
		
	}
}
