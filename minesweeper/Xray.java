import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.*;
import java.awt.Image;

import javax.swing.*;
import javax.swing.JFrame;

import java.util.Date;

public class Xray extends Powerup {
  public Xray(Game game) {
    super("Xray", game);
  }

  public void effect(Board b) {
    System.out.println("xray");

    this.used = true;

    try {
      for (int y = 0; y < b.size; y++) {
        for (int x = 0; x < b.size; x++) {
          if (b.board.get(y).get(x).getType().equals("mine")) {
            if (!b.board.get(y).get(x).flag) {
              ImageIcon i = new ImageIcon(Xray.class.getResource("minesweeper/imgs/flag.png"));
              System.out.println(i);
              b.buttonGrid[y][x]                  .setIcon(b.resizeImage(i));
            }
          }
        }
      }
      // b.display.repaint();
      // b.display.revalidate();
      Thread.sleep(5000);

      // for (int y = 0; y < b.size; y++) {
      // for (int x = 0; x < b.size; x++) {
      // if (b.board.get(y).get(x).getType().equals("mine")) {
      // if (!b.board.get(y).get(x).flag) {
      // b.buttonGrid[y][x].setIcon(b.resizeImage(new
      // ImageIcon(Xray.class.getResource("minesweeper/imgs/blank.png"))));
      // }
      // }
      // }
      // }
    } catch (InterruptedException ex) {

    }

    used = true;
    remove();
  }
}