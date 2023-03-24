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

public abstract class Game {
  protected final String difficulty;
  protected final int mines, powerUps, size, tiles;

  ArrayList<ArrayList<Tile>> gridMatrix;
  
  public Game(String d, int m, int p, int s) { 
    difficulty = d;
    mines = m;
    powerUps = p;
    size = s;
    tiles = s*s;

    Border blackline = BorderFactory.createLineBorder(Color.black);

    GameBoard game = new GameBoard(size, this);
    game.setVisible(true);
    
    gridMatrix = new ArrayList<>();

    for(int i=0; i < s; i++) {
      gridMatrix.add(new ArrayList<Tile>());
    }

    for (int i = 0; i < s; i++) {
      for (int j = 0; j < s; j++) {
        Tile tile = new Tile("mine");
        gridMatrix.get(i).add(tile);

        JButton cell = new JButton(tile.getType());
        // cell.setPreferredSize(new Dimension(65, 65));
        game.grid.add(cell);
        cell.setBorder(blackline);
      }
    }

  }

  public String getDifficulty () {
    return difficulty;
  }

  public int getMines () {
    return mines;
  }

  public int getPowerUps () {
    return powerUps;
  }

  public int getTiles () {
    return tiles;
  }

  public ArrayList<ArrayList<Tile>> getGridMatrix() {
    return gridMatrix;
  }
}