import java.util.ArrayList;

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

public class Board implements ActionListener, KeyListener {
  protected final int size;
  protected Game game;
  protected final String diff;
  int selectedX = 0;
  int selectedY = 0;
  
  ArrayList<ArrayList<Tile>> board;
  JButton[][] buttonGrid;
  ArrayList<JButton> sideButtons;
  ArrayList<JLabel> counters;
  ArrayList<ImageIcon> tilePics;

  JButton selected;

  GameView display;
  
  public Board(int s, Game g, String d) {
    size = s;
    game = g;
    diff = d;

    Border blackline = BorderFactory.createLineBorder(Color.black);

    board = new ArrayList<>();
    buttonGrid = new JButton[size][size];

    sideButtons = new ArrayList<>(3);
    counters = new ArrayList<>(3);
    

    display = new GameView(size, this);
    display.setVisible(true);

    for(int i=0; i < size; i++) {
      tilePics.add(new ImageIcon(Board.class.getResource("minesweeper/imgs/mines " + Integer.toString(i) + ".png")));
    }

    for(int i=0; i < 9; i++) {
      board.add(new ArrayList<Tile>());
    }

    for (int y = 0; y < size; y++) {
      for (int x = 0; x < size; x++) {
        ArrayList<ArrayList<Tile>> get = game.getGridMatrix();
        Tile tile = get.get(y).get(x);
        board.get(y).add(tile);

        JButton cell = new JButton(tile.getType()); 
        cell.addActionListener(this);
        cell.addKeyListener(this);
        cell.setFocusable(true);
        // cell.setPreferredSize(new Dimension(65, 65));
        display.grid.add(cell);
        buttonGrid[y][x] = cell;
        cell.setBorder(blackline);
      }
    }

    for (int i = 0; i < 3; i++) {
      JLabel num = new JLabel("0");
      JButton button = new JButton(Integer.toString(i));

      counters.add(num);
      sideButtons.add(button);
      
      display.inventory.add(counters.get(i));
      display.inventory.add(sideButtons.get(i));
    }

    sideButtons.get(0).setEnabled(false);

  }
   
  public int getSize () {
    return size;
  }

  public void writeBoard () {
    for (int y = 0; y < size; y++) {
      for (int x = 0; x < size; x++) {
        ArrayList<ArrayList<Tile>> get = game.getGridMatrix();
        Tile tile = get.get(y).get(x);
        board.get(y).set(x, tile);
      }
    }
    
    for (int y = 0; y < size; y++) {
      for (int x = 0; x < size; x++) {
        Tile tile = board.get(y).get(x);

        JButton cell = buttonGrid[y][x];

        
        
        
        if (tile.getDigState()) {
          if (tile.getType() == "mine") {
            // cell.setIcon("minesweeper/imgs/mine.png");
          } else if (tile.getType() == "safe") {
            // cell.setText(Integer.toString(tile.getNum()));
            cell.setIcon(tilePics.get(tile.getNum()));
          } else if (tile.getType() == "powerup") {
            cell.setText(Integer.toString(tile.getNum()));
          }

        } else {
          if (tile.flag) {
          cell.setText("flag");
        } else {
          cell.setText(tile.getType()); //tile.getType()
        }
        }
      }
    }

    int x = 0;
    int r = 0;
    int d = 0;
    
    for (int i = 0; i < game.inventory.size(); i++) {
      Powerup power = game.inventory.get(i);

      if (power.getType().equals("Xray")) {
        x++;
      } else if (power.getType().equals("Defuser")) {
        d++;
      } else if (power.getType().equals("ReverseMine")) {
        r++;
      }

      counters.get(0).setText(Integer.toString(d));
      counters.get(1).setText(Integer.toString(r));
      counters.get(2).setText(Integer.toString(x));
      
      if (r > 0) {
        sideButtons.get(1).setEnabled(true);
      } else {
        sideButtons.get(1).setEnabled(false);
      }

      if (x > 0) {
        sideButtons.get(2).setEnabled(true);
      } else {
        sideButtons.get(2).setEnabled(false);
      }
    }
    }
   public void selection(String s) {
      if (s.equals("D")) {
        board.get(selectedY).get(selectedX).dig();
        writeBoard();
      } else if (s.equals("F")) {
        board.get(selectedY).get(selectedX).flagTile();
        writeBoard();
      } else {
        System.out.println("null");
      }
   }

  @Override
public void actionPerformed(ActionEvent e) {
  selected = (JButton) e.getSource();

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (buttonGrid[i][j] == selected) {
          selectedY = i;
          selectedX = j;
        }
      }
    }

    System.out.println(selectedX);
    System.out.println(selectedY);
}

  public void keyTyped(KeyEvent e) {

  }

  public void keyPressed(KeyEvent e) {
// System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
//     selection(KeyEvent.getKeyText(e.getKeyCode()));
  }

  public void keyReleased(KeyEvent e) {
    System.out.println(KeyEvent.getKeyText(e.getKeyCode())); 
    selection((String) KeyEvent.getKeyText(e.getKeyCode()));
  }
}