import java.util.ArrayList;

import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Image;

import javax.swing.*;
import javax.swing.JFrame;

public class ReverseMine extends Powerup{
  Game game;
  ArrayList<ArrayList<Tile>> array;
  
  public ReverseMine(Game g){
    super("ReverseMine", g);
    game = g;
    array = game.getGridMatrix();
  }

  public void effect(Board board) {
    int x = board.selectedX;
    int y = board.selectedY;
      
    for (int i = -2; i < 3; i++) {
      for (int j = -2; j < 3; j++) {
        if (((x + j) < 0) || ((y + i) < 0) || ((x + j) >= array.size()) || ((y + i) >= array.size())) {
          continue;
        } else {
          if (array.get(y + i).get(x + j).getType() == "mine") {
            array.get(y + i).get(x + j).flag = true;
          } else if (array.get(y + i).get(x + j).getType() == "safe") {
            array.get(y + i).get(x + j).dig();
          } else if (array.get(y + i).get(x + j).getType() == "powerup") {
            array.get(y + i).get(x + j).dig();
          }
        }
      }

      board.writeBoard();
  }

    used = true;
    remove();
}
}