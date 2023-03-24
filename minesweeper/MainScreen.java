import javax.swing.*;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.*;


public class MainScreen extends JFrame implements ActionListener {
  JPanel header = new JPanel();
  JPanel selection = new JPanel();

  // private ImageIcon head = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon easy = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon mid = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon hard = new ImageIcon(getClass().getResource(".png"));
  
  private JLabel title = new JLabel("minesweeper++"); //JLabel(head, JLabel.CENTER);
  private JButton diff1 = new JButton("easy");
  private JButton diff2 = new JButton("medium");
  private JButton diff3 = new JButton("hard");
  
  
  public MainScreen() {
    super("Minesweeper++");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(800, 600);

    this.add(header, BorderLayout.NORTH);
    this.add(selection, BorderLayout.CENTER);

    this.getContentPane().setBackground(Color.yellow);

    header.setLayout(new FlowLayout());
    header.add(title);
    header.setPreferredSize(new Dimension(700, 100));
    header.setAlignmentY(Component.CENTER_ALIGNMENT);

    title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));

    selection.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 25));

    diff1.setAlignmentX(Component.CENTER_ALIGNMENT);
    diff2.setAlignmentX(Component.CENTER_ALIGNMENT);
    diff3.setAlignmentX(Component.CENTER_ALIGNMENT);
    diff1.setPreferredSize(new Dimension(700, 100));
    diff2.setPreferredSize(new Dimension(700, 100));
    diff3.setPreferredSize(new Dimension(700, 100));
    diff1.addActionListener(this);
    diff2.addActionListener(this);
    diff3.addActionListener(this);
    selection.add(diff1);
    selection.add(diff2);
    selection.add(diff3);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == diff1) {
      Game game = new EasyGame();
      this.setEnabled(false);
    }
    if (e.getSource() == diff2) {
      Game game = new MediumGame();
      this.setEnabled(false);
    }
    if (e.getSource() == diff3) {
      Game game = new HardGame();
      this.setEnabled(false);
    }
  }
}
