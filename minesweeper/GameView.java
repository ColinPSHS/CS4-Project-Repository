import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class GameView extends JFrame {
  JPanel grid = new JPanel();
  JPanel sidebar = new JPanel();
  JPanel stuff = new JPanel();
  JPanel inventory = new JPanel();

  Board board;

  // private ImageIcon head = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon easy = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon mid = new ImageIcon(getClass().getResource(".png"));
  // private ImageIcon hard = new ImageIcon(getClass().getResource(".png"));

  int x = 0;
  int y = 0;

  Border blackline = BorderFactory.createLineBorder(Color.black);
  
  public GameView(int size, Board b) {
    super("Minesweeper++");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(800, 600);

    board = b;

    this.add(grid, BorderLayout.CENTER);
    this.add(sidebar, BorderLayout.EAST);

    this.getContentPane().setBackground(Color.yellow);

    grid.setLayout(new GridLayout(size, size));
    grid.setPreferredSize(new Dimension(600, 600));
    grid.setAlignmentX(Component.LEFT_ALIGNMENT);

    inventory.setLayout(new GridLayout(3, 2));
    
    sidebar.setLayout(new BorderLayout());
    sidebar.add(stuff, BorderLayout.NORTH);
    sidebar.add(inventory, BorderLayout.CENTER);
    sidebar.setPreferredSize(new Dimension(200, 600));

    JLabel hardness = new JLabel(board.diff);
    stuff.setPreferredSize(new Dimension(200, 200));
    stuff.setLayout(new BorderLayout());
    stuff.add(hardness, BorderLayout.NORTH);
    hardness.setAlignmentX(Component.CENTER_ALIGNMENT);
    hardness.setAlignmentY(Component.CENTER_ALIGNMENT);
    
    inventory.setPreferredSize(new Dimension(200, 400));
  }
}
