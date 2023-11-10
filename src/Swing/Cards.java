package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Cards extends JFrame implements ActionListener 	 {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cards frame = new Cards();
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
	public Cards() {
		setTitle("CARDS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 122, 261);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("This is my new slide");
//		panel.add(lblNewLabel);
		
		CardLayout crd = new CardLayout();
		Container cPane = getContentPane(); 
		cPane.setLayout(crd);
		JButton btnNewButton = new JButton("new slide");
		panel.add(btnNewButton);
		cPane.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.next(cPane); 
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(121, 0, 313, 261);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
