import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JFrame;

public class InfoScreen extends JFrame implements ActionListener {
  JFrame main;
  
  JPanel panel = new JPanel();
  JPanel buttons = new JPanel();
  
  JLabel label = new JLabel();
  JButton button = new JButton("Close");

  private ImageIcon info = new ImageIcon(MainScreen.class.getResource("minesweeper/imgs/info.png"));

  public InfoScreen(JFrame m) {
    super("Information");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(800, 600);
    this.setVisible(true);
    this.add(panel, BorderLayout.NORTH);
    this.add(buttons, BorderLayout.SOUTH);

    main = m;

    label.setPreferredSize(new Dimension(666, 500));
    label.setIcon(info);
    panel.add(label);

    button.setPreferredSize(new Dimension(100, 50));
    button.addActionListener(this);
    buttons.add(button);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {
      this.dispose();
      main.setEnabled(true);
    }
  }
}