package Swing;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;

public class GUI_Design extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Design frame = new GUI_Design();
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
	public GUI_Design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 462, 411);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
//		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 124, 411);
		panel.add(panel_1, "name_92165319180400");
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Add File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				int i=0;
				File f=chooser.getSelectedFile();
				String filepath=f.getAbsolutePath();
				String filename=f.getName();
				String data[]= {"1",filename,filepath};
//				scrollPane_1.
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				model.addRow(data);
				
				
			}
		});
		btnNewButton.setBounds(10, 62, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Folder");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.showOpenDialog(null);
				int i=0;
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
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						model.addRow(data);

					}
						
						

					else if (f.isDirectory()) {
//						System.out.println( f.getAbsolutePath());
						RecursiveDirectory(f.listFiles(), i + 1);
					}
				}
			}
		});
		btnNewButton_1.setBounds(10, 124, 104, 23);
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
		btnNewButton_2.setBounds(10, 192, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove All");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
		});
		btnNewButton_3.setBounds(10, 265, 89, 23);
		panel_1.add(btnNewButton_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(123, 0, 339, 375);
		panel.add(scrollPane_1, "name_92165333404100");
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.No", "File Name", "Path"
			}
		));
		
		
		
		
		JButton btnNewButton_4 = new JButton("Next Card");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)panel.getLayout();
				card.show(panel, "B");
			}
		});
		btnNewButton_4.setBounds(348, 377, 89, 23);
		panel.add(btnNewButton_4, "name_92165349436600");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 394, 400);
		panel.add(panel_2, "name_92165363978400");
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 342, 389);
		panel_2.add(scrollPane);
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
