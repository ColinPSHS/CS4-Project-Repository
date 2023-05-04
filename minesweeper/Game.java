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
  protected final int mines, powerUps, size, tiles, safes, dug;
  protected boolean lost = false;
  protected boolean end = false;
  public boolean firstDig = false;
  protected ArrayList<Powerup> inventory;

  ArrayList<ArrayList<Tile>> gridMatrix;
  ArrayList<Tile> mine;

  Board game;

  Random rand = new Random(); 
  
  public Game(String d, int m, int p, int s) { 
    difficulty = d;
    mines = m;
    powerUps = p;
    size = s;
    tiles = s*s;
    safes = tiles - mines;
    dug = 0;

    Border blackline = BorderFactory.createLineBorder(Color.black);
    
    gridMatrix = new ArrayList<>(size);
    mine = new ArrayList<Tile>(mines);

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

    

    game = new Board(size, this, difficulty);

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

  public void checkState () {
    if ((dug == safes) || (lost)) {
      System.out.println("lost");
      EndScreen endScreen = new EndScreen();
      endScreen.setVisible(true);
      game.display.dispose();
    }
  }

  public void generateGame () {
    for (int i = 0; i < mines; i++) {
      int x = rand.nextInt(size);
      int y = rand.nextInt(size);

      if (gridMatrix.get(y).get(x).type == "safe") {
        gridMatrix.get(y).set(x, new Tile("mine", this, x, y));
      } else {
        i--;
      }
    }

    for (int i = 0; i < powerUps; i++) {
      int x = rand.nextInt(size);
      int y = rand.nextInt(size);

      if (gridMatrix.get(y).get(x).type == "safe") {
        gridMatrix.get(y).set(x, new Tile("powerup", this, x, y));
      } else {
        i--;
      }
    }
    System.out.println("game generated");
  }
}