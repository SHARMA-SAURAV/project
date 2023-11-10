package Swing;



import javax.swing.*;
import java.awt.*;

class Hello extends JFrame {

JButton jb1;
JLabel l1;

Hello() {

    l1 = new JLabel("This is my Second Page!");
    l1.setBounds(30, 50, 300, 50);
    l1.setFont(new Font("Serif", Font.PLAIN, 24));

    add(l1);

    setLayout(null);
    setSize(600, 500);
    setVisible(true);
}

}
