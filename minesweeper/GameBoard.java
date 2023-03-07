import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class GameBoard extends JFrame {
  JPanel grid = new JPanel();
  JPanel sidebar = new JPanel();
  JPanel stuff = new JPanel();
  JPanel inventory = new JPanel();

  // private ImageIcon head = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon easy = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon mid = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon hard = new ImageIcon(getClass().getResource(".png"));
  
  int x = 0;
  int y = 0;
  
  public GameBoard() {
    super("Minesweeper++");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    this.add(grid, BorderLayout.CENTER);
    this.add(sidebar, BorderLayout.EAST);

    this.getContentPane().setBackground(Color.yellow);

    grid.setLayout(new GridLayout(9,9));
    grid.setPreferredSize(new Dimension(600, 600));
    grid.setAlignmentY(Component.LEFT_ALIGNMENT);

    sidebar.setLayout(new BorderLayout());
    sidebar.add(stuff, BorderLayout.NORTH);
    sidebar.add(stuff, BorderLayout.CENTER);
    

    this.setSize(800, 600);

    this.pack();
  }
}
