package Swing;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Test extends JFrame implements ActionListener {

  JButton jb1;
  JLabel l1;

  Test() {

      l1 = new JLabel("This is my First Page!");
      l1.setBounds(30, 50, 300, 50);
      l1.setFont(new Font("Serif", Font.PLAIN, 24));

      add(l1);

      jb1 = new JButton("Go Second");
      jb1.setBounds(50, 200, 180, 30);
      add(jb1);

      jb1.addActionListener(this);

      setLayout(null);
      setSize(600, 500);
      setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
      if (e.getSource().equals(jb1)) {
          this.dispose();
          Hello hh = new Hello();
          hh.setVisible(true);

      }
  }

  public static void main(String args[]) {
      Test t = new Test();
  }
}

