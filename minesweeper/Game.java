import java.util.ArrayList;
import java.util.Random;

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
  protected boolean lost = false;

  ArrayList<ArrayList<Tile>> gridMatrix;
  ArrayList<Tile> mineX;
  ArrayList<Tile> mineY;
  
  public Game(String d, int m, int p, int s) { 
    difficulty = d;
    mines = m;
    powerUps = p;
    size = s;
    tiles = s*s;

    Border blackline = BorderFactory.createLineBorder(Color.black);

    Random rand = new Random(); 
    
    gridMatrix = new ArrayList<>(size);
    mineX = new ArrayList<Tile>(mines);
    mineY = new ArrayList<Tile>(mines);

    for(int i=0; i < s; i++) {
      gridMatrix.add(new ArrayList<Tile>(size));
    }

    System.out.println(gridMatrix.size());
    System.out.println(gridMatrix.get(0).size());

    System.out.println(gridMatrix);

    for (int i = 0; i < s; i++) {
      for (int j = 0; j < s; j++) {
        Tile tile = new Tile("safe", this, j, i);
        gridMatrix.get(i).add(tile);
      }
    }

    for (int i = 0; i < mines; i++) {
      int x = rand.nextInt(size);
      int y = rand.nextInt(size);

      if (gridMatrix.get(y).get(x).type == "safe") {
        gridMatrix.get(y).set(x, new Tile("mine", this, x, y));
      } else {
        i--;
      }
    }

    Board game = new Board(size, this, difficulty);

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