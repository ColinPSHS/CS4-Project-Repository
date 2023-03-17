import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;

public class MainScreen extends JFrame {
  JPanel header = new JPanel();
  JPanel selection = new JPanel();

  // private ImageIcon head = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon easy = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon mid = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon hard = new ImageIcon(getClass().getResource(".png"));
  
  private JLabel title = new JLabel("minesweeper++"); //JLabel(head, JLabel.CENTER);
  private JLabel diff1 = new JLabel("easy");
  private JLabel diff2 = new JLabel("medium");
  private JLabel diff3 = new JLabel("hard");
  
  
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

    selection.setLayout(new BoxLayout(selection, BoxLayout.Y_AXIS));

    diff1.setAlignmentX(Component.CENTER_ALIGNMENT);
    diff2.setAlignmentX(Component.CENTER_ALIGNMENT);
    diff3.setAlignmentX(Component.CENTER_ALIGNMENT);
    diff1.setPreferredSize(new Dimension(700, 100));
    diff2.setPreferredSize(new Dimension(700, 100));
    diff3.setPreferredSize(new Dimension(700, 100));
    selection.add(diff1);
    selection.add(diff2);
    selection.add(diff3);
  }
}
