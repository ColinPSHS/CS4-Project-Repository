import java.util.ArrayList;

import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Color;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Board {
  protected final int size;
  protected Game game;
  protected final String diff;
  
  ArrayList<ArrayList<Tile>> board;
  JButton[][] buttonGrid;
  
  public Board(int s, Game g, String d) {
    size = s;
    game = g;
    diff = d;

    Border blackline = BorderFactory.createLineBorder(Color.black);

    board = new ArrayList<>();
    buttonGrid = new JButton[size][size];

    GameBoard display = new GameBoard(size, this);
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
        // cell.setPreferredSize(new Dimension(65, 65));
        display.grid.add(cell);
        buttonGrid[y][x] == cell;
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
        Tile tile = board.get(i).get(j);

        JButton cell = buttonGrid[y][x];
        
        if (tile.getDigState()) {
          if (tile.getType() == "mine") {
            cell.setIcon();
          } else if (tile.getType() == "safe") {
            cell.setIcon("minesweeper/imgs/" + tile.getNum() + ".png");
          }
        }
      }
    }
  }
}