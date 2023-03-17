import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Color;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

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

  Border blackline = BorderFactory.createLineBorder(Color.black);
  
  public GameBoard(int size) {
    super("Minesweeper++");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(800, 600);

    this.add(grid, BorderLayout.CENTER);
    this.add(sidebar, BorderLayout.EAST);

    this.getContentPane().setBackground(Color.yellow);

    grid.setLayout(new GridLayout(9,9));
    grid.setPreferredSize(new Dimension(600, 600));
    grid.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    // for (int i = 0; i < size; i++) {
    //   for (int j = 0; j < size; j++) {
        
    //     tile.setPreferredSize(new Dimension(65, 65));
    //     grid.add(tile);
    //     tile.setBorder(blackline);
    //   }
    // }

    sidebar.setLayout(new BorderLayout());
    sidebar.add(stuff, BorderLayout.NORTH);
    sidebar.add(inventory, BorderLayout.CENTER);
    sidebar.setPreferredSize(new Dimension(200, 600));


    JLabel hardness = new JLabel("Easy");
    stuff.setPreferredSize(new Dimension(200, 200));
    stuff.setLayout(new BorderLayout());
    stuff.add(hardness, BorderLayout.NORTH);
    hardness.setAlignmentX(Component.CENTER_ALIGNMENT);
    hardness.setAlignmentY(Component.CENTER_ALIGNMENT);
    
    inventory.setPreferredSize(new Dimension(200, 400));
  }

}
