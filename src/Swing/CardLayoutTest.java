package Swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardLayoutTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayoutTest frame = new CardLayoutTest();
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
	public CardLayoutTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 10, 195, 240);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "A");
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A");
		lblNewLabel.setBounds(47, 9, 7, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("A pannel button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)panel.getLayout();
				card.show(panel, "B");
			}
		});
		btnNewButton.setBounds(22, 89, 151, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "B");	
		
		JButton btnNewButton_1 = new JButton("B Panel Button");
		btnNewButton_1.setBounds(10, 78, 175, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card=(CardLayout)panel.getLayout();
				card.show(panel, "A");
			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("B");
		lblNewLabel_1.setBounds(88, 11, 6, 14);
		panel_2.add(lblNewLabel_1);
	}
}


/*
 * 
 * 
 */



