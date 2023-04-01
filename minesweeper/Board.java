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
  
  public Board(int s, Game g, String d) {
    size = s;
    game = g;
    diff = d;

    Border blackline = BorderFactory.createLineBorder(Color.black);

    board = new ArrayList<>();

    GameBoard display = new GameBoard(size, this);
    display.setVisible(true);

    for(int i=0; i < size; i++) {
      board.add(new ArrayList<Tile>());
    }

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        ArrayList<ArrayList<Tile>> get = game.getGridMatrix();
        Tile tile = get.get(i).get(j);;
        board.get(i).add(tile);

        JButton cell = new JButton(tile.getType()); 
        // cell.setPreferredSize(new Dimension(65, 65));
        display.grid.add(cell);
        cell.setBorder(blackline);
      }
    }

  }
   
  public int getSize () {
    return size;
  }

  public void writeBoard () {
    
  }
}