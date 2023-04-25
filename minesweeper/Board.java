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

  JButton selected;

  GameView display;
  
  public Board(int s, Game g, String d) {
    size = s;
    game = g;
    diff = d;

    Border blackline = BorderFactory.createLineBorder(Color.black);

    board = new ArrayList<>();
    buttonGrid = new JButton[size][size];

    display = new GameView(size, this);
    display.setVisible(true);

    for(int i=0; i < size; i++) {
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

  }
   
  public int getSize () {
    return size;
  }

  public void writeBoard () {
    for (int y = 0; y < size; y++) {
      for (int x = 0; x < size; x++) {
        Tile tile = board.get(y).get(x);

        JButton cell = buttonGrid[y][x];

        if (tile.flag) {
          cell.setText("flag");
        }
        
        if (tile.getDigState()) {
          if (tile.getType() == "mine") {
            // cell.setIcon("minesweeper/imgs/mine.png");
          } else if (tile.getType() == "safe") {
            cell.setText(Integer.toString(tile.getNum()));
            // cell.setIcon("minesweeper/imgs/" + tile.getNum() + ".png");
          }

        }
      }
    }
    }
   public void selection(String s) {
      if (s.equals("D")) {
        board.get(selectedY).get(selectedX).dig();
        writeBoard();
      } else if (s.equals("F")) {
        board.get(selectedY).get(selectedX).flagTile();
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